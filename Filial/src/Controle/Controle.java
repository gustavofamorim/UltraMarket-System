package Controle;

import Banco.BankSimulator;
import Modelo.Cliente;
import Modelo.Filial;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Modelo.Venda.Venda;
import Modelo.Venda.VendaBuilder;
import Remote.FilialRemote;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Controle {

    Filial filial = null;
    private final BankSimulator banco = new BankSimulator();
    private final RMIClientManager rmiClientManager = RMIClientManager.getInstance();
    private final RMIServerManager rmiServerManager = RMIServerManager.getInstance();


    public Controle(String nome, String hostName, Integer porta) throws RemoteException {

        this.filial = new Filial(nome, hostName, porta, FilialRemote.OBJECT_NAME);

        try {
            Integer id = this.rmiClientManager.getMatrizRemote().requisitarLogon(this.filial);
            this.filial.setId(id);
        } catch (RemoteException e) {
            throw (e);
        }

        //this.rmiServerManager.iniciar(new FilialRemoteImpl(this.filial, this));
    }

    

    public void salvarProduto(String nome, Double valor){
        banco.insertIntoProduto(new Produto(nome, valor));
    }

    public void salvarCliente(String nome, String CPF){
        banco.insertIntoCliente(new Cliente(nome, CPF));
    }

    public ArrayList<Produto> obterTodosProduto(){
        return (banco.selectAllFromProduto());
    }

    public ArrayList<Cliente> obterTodosCliente(){
        return (banco.selectAllFromCliente());
    }

    public ArrayList<Venda> obterTodosVenda(){
        return (banco.selectAllFromVenda());
    }

    public void novaVenda(Collection<ItemVenda> itens, Double pagamento, Double desconto, Cliente cliente){

        desconto /= 100;

        VendaBuilder builder = new VendaBuilder();
        builder.addItens(itens);
        builder.darDesconto(desconto);
        builder.pagar(pagamento);
        builder.cliente(cliente);

        banco.insertIntoVendas(builder.getInstance());
    }
}
