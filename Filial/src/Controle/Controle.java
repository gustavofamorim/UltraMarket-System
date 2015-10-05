package Controle;

import Banco.BankSimulator;
import Modelo.Cliente;
import Modelo.Filial;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Modelo.Venda.Venda;
import Modelo.Venda.VendaBuilder;
import Remote.FilialRemote;
import Tools.Visual.WindowLoader;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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


    public Controle(String nome, String hostName, Integer porta) throws RemoteException, MalformedURLException, NotBoundException {

        this.filial = new Filial(nome, hostName, porta, FilialRemote.OBJECT_NAME);
        Integer id = this.rmiClientManager.getMatrizRemote().requisitarLogon(this.filial);
        this.filial.setId(id);

        //this.rmiServerManager.iniciar(new FilialRemoteImpl(this.filial, this));
    }

    public Cliente buscarCliente(String cpf) {
        Cliente result = this.banco.selectFromClienteWhereCpfEquals(cpf);

        if(result == null){
            try {
                result = this.rmiClientManager.getMatrizRemote().buscarCliente(cpf);
            } catch (Exception e) {
                WindowLoader.showException("Erro", "Erro ao se comunicar com o servidor.", e);
            }
        }

        return (result);
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
