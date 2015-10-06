package Controle;

import Modelo.Cliente;
import Tools.Visual.WindowLoader;

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
        Cliente result = this.mainController.banco.selectFromClienteWhereCpfEquals(cpf);

        if(result == null){
            try {
                result = this.mainController.rmiClientManager.getMatrizRemote().buscarCliente(this.mainController.filial.getId(), cpf);
            } catch (Exception e) {
                WindowLoader.showException("Erro", "Erro ao se comunicar com o servidor.", e);
            }
        }

        return (result);
    }

    public Cliente buscarClienteRemote(String cpf) {
        return (this.mainController.banco.selectFromClienteWhereCpfEquals(cpf));
    }

    public boolean salvarCliente(String nome, String CPF){
        if(this.mainController.getGestaoCliente().buscarClienteRemote(CPF) == null) {
            this.mainController.banco.insertIntoCliente(new Cliente(nome, CPF));
            return (true);
        }
        else {
            return (false);
        }
    }

    public ArrayList<Cliente> obterTodosCliente(){
        return (this.mainController.banco.selectAllFromCliente());
    }


}
