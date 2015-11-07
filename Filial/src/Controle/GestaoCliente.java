package Controle;

import Modelo.Cliente;

import java.util.ArrayList;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class GestaoCliente {

    public Controle mainController;

    public GestaoCliente(Controle mainController){
        this.mainController = mainController;
    }

    public Cliente buscarCliente(String cpf) {
            
    }

    public boolean salvarCliente(String nome, String CPF){
        if(this.mainController.getGestaoCliente().buscarCliente(CPF) == null) {
            //this.mainController.banco.insertIntoCliente(new Cliente(nome, CPF));
            // Insere cliente no webservice
            return (true);
        }
        else {
            return (false);
        }
    }

    public ArrayList<Cliente> obterTodosCliente(){
        // busca todos clientes no webservice
        return (null);
    }

    private static boolean cadastrarCliente(services.Cliente cliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.cadastrarCliente(cliente);
    }

    private static boolean excluirCliente(int idCliente) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.excluirCliente(idCliente);
    }

    private static java.util.List<services.Cliente> obterClientes() {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.obterClientes();
    }


}
