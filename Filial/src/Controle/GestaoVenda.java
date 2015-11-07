package Controle;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 06/10/2015.
 */
public class GestaoVenda {

    private Control mainController = null;

    public GestaoVenda(Control mainController){
        this.mainController = mainController;
    }
/*
    public void novaVenda(Collection<ItemVenda> itens, Double pagamento, Double desconto, Cliente cliente){

        desconto /= 100;
        VendaBuilder builder = new VendaBuilder();
        builder.addItens(itens);
        builder.darDesconto(desconto);
        builder.pagar(pagamento);
        builder.cliente(cliente);
        //this.mainController.banco.insertIntoVendas(builder.getInstance());
    }

    public ArrayList<Venda> obterTodosVenda(){
        //return (this.mainController.banco.selectAllFromVenda());
        return (null);
    }

    public void cancelarVenda(Venda venda){
        if(venda.getStatus() == Venda.STATUS_VENDA.CONFIRMADA) {
            venda.getCliente().setSaldo(venda.getCliente().getSaldo() + venda.getValorPago());
            if (venda.getTroco() < 0) {
                venda.getCliente().setSaldo(venda.getCliente().getSaldo() - venda.getTroco());
            }
            venda.setStatus(Venda.STATUS_VENDA.CANCELADA);
        }
    }
*/
}
