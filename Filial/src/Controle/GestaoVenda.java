package Controle;

import Modelo.VendaBuilder;
import Tools.DateParser;
import Tools.Visual.WindowLoader;
import Visao.Novo.NovaVendaController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import services.StatusVENDA;
import services.Venda;

/**
 * Created by Gustavo Freitas on 06/10/2015.
 */
public class GestaoVenda {

    public void novaVenda(NovaVendaController form){
        boolean check = false;
        if(form.getCliente().getSaldo() > 0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("O cliente possui débito");
            alert.setHeaderText("O cliente deve pagar o débito.");
            alert.setContentText("Ele tem dinheiro disponível?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                check = true;
            }
            else {
                WindowLoader.showMessage("Cancelada", "A venda foi cancelada por falta de grana.");
            }
        }
        else{
            check = true;
        }
        if (check) {
            Double desconto = Double.parseDouble(form.getDesconto().replace(",", "."));
            Double valorPago = Double.parseDouble(form.getValorPago().replace(",", "."));

            desconto /= 100;
            VendaBuilder builder = new VendaBuilder();
            builder.addItens(form.getItensAdicionados());
            builder.darDesconto(desconto);
            builder.pagar(valorPago);
            builder.cliente(form.getCliente());
            Modelo.Venda venda = builder.getInstance();
            Venda vendaService = new Venda();
            vendaService.setCliente(venda.getCliente());
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(venda.getDataEHora());
            XMLGregorianCalendar date = null;
            try {
                date = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(GestaoVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            vendaService.setDataEHora(date);
            vendaService.setId(venda.getId());
            vendaService.setStatus(venda.getStatus() == Modelo.Venda.STATUS_VENDA.CANCELADA ? StatusVENDA.CANCELADA : StatusVENDA.CONFIRMADA);
            vendaService.setTotalBruto(venda.getTotalBruto());
            vendaService.setTotalLiquido(venda.getTroco());
            vendaService.setTroco(venda.getTroco());
            vendaService.setValorPago(venda.getValorPago());
            cadastrarVenda(vendaService, Control.filial);
        }
    }

    public ArrayList<Venda> obterTodosVenda(){
        //return (this.mainController.banco.selectAllFromVenda());
        return (null);
    }

    public void cancelarVenda(Modelo.Venda venda){
//        if(venda.getStatus() == Modelo.Venda.STATUS_VENDA.CONFIRMADA) {
//            venda.getCliente().setSaldo(venda.getCliente().getSaldo() + venda.getValorPago());
//            if (venda.getTroco() < 0) {
//                venda.getCliente().setSaldo(venda.getCliente().getSaldo() - venda.getTroco());
//            }
//            venda.setStatus(Modelo.Venda.STATUS_VENDA.CANCELADA);
//        }
        cancelarVenda(venda.getId());
    }

    private static Venda cadastrarVenda(services.Venda venda, services.Filial filial) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cadastrarVenda(venda, filial);
    }

    private static boolean cancelarVenda(int idVenda) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cancelarVenda(idVenda);
    }

}
