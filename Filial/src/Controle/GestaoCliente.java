package Controle;

import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import Visao.Novo.NovoClienteController;
import java.util.ArrayList;
import javafx.stage.StageStyle;
import Modelo.Cliente;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class GestaoCliente {
    
    public services.Cliente searchCliente(String cpf) {
        return obterClienteByCPF(cpf);
    }
    
    public Cliente windowSaveCliente() {
        WindowController janela = WindowLoader.loadWindow("/Visao/Novo/NovoCliente.fxml");
        janela.getInternalController().setMyStage(janela);
        //((NovoClienteController)janela.getInternalController()).cancelarButton.setDisable(true);
        //janela.initStyle(StageStyle.UNDECORATED);
        janela.showAndWait();
        janela.close();
        return ((NovoClienteController)janela.getInternalController()).getCliente();
    }

    public Cliente saveCliente(NovoClienteController form){
        
        Cliente c = new Cliente();
        
        c.setNome(form.getNome());
        c.setCPF(form.getCPF());
        c = Cliente.ParseToModel(cadastrarCliente(c));
        
        return (c);
    }

    public ArrayList<Cliente> obterTodosCliente(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        obterClientes().forEach(item -> {
            clientes.add(Cliente.ParseToModel(item));
        });
        return clientes;
    }

    private static services.Cliente cadastrarCliente(services.Cliente cliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cadastrarCliente(cliente);
    }

    private static boolean excluirCliente(int idCliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.excluirCliente(idCliente);
    }

    private static services.Cliente obterClienteByCPF(java.lang.String cpf) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterClienteByCPF(cpf);
    }

    private static java.util.List<services.Cliente> obterClientes() {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterClientes();
    }
}
