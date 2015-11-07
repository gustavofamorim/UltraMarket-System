package Controle;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class GestaoCliente {

    public Controle mainController;

    public GestaoCliente(Controle mainController){
        this.mainController = mainController;
    }
/*
    public Cliente buscarCliente(String cpf) {
        return (null);
    }
    
    public services.Cliente buscarCliente(String cpf) {
        return obterClienteByCPF(cpf);
    }

    public boolean salvarCliente(String nome, String CPF){
        if(this.mainController.getGestaoCliente().buscarCliente(CPF) == null) {
            this.mainController.banco.insertIntoCliente(new Cliente(nome, CPF));
            //Insere cliente no webservice
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
*/
}
