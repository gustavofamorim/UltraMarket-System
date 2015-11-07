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

    public services.Cliente buscarCliente(String cpf) {
        return obterClienteByCPF(cpf);
    }

    public boolean salvarCliente(String nome, String CPF){
        if(this.mainController.getGestaoCliente().buscarCliente(CPF) == null) {
            cadastrarCliente(new services.Cliente(nome, CPF))
            return (true);
        }
        else {
            return (false);
        }
    }

    public ArrayList<Cliente> obterTodosCliente(){
        return (obterTodosCliente());
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
