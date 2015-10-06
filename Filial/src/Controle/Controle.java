package Controle;

import Banco.BankSimulator;
import Modelo.Cliente;
import Modelo.Filial;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Modelo.Venda.Venda;
import Modelo.Venda.VendaBuilder;
import Remote.FilialRemote;
import Remote.FilialRemoteImpl;
import Tools.Visual.WindowLoader;
import javafx.application.Platform;

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
    protected final BankSimulator banco = new BankSimulator();
    protected final RMIClientManager rmiClientManager = RMIClientManager.getInstance();
    protected final RMIServerManager rmiServerManager = RMIServerManager.getInstance();
    protected final GestaoCliente gestaoCliente = new GestaoCliente(this);

    public Controle(String nome, String hostName, Integer porta) throws RemoteException, NotBoundException, MalformedURLException {
        this.filial = new Filial(nome, hostName, porta, nome);
        this.iniciarConexao();
    }

    public void iniciarConexao() throws RemoteException, MalformedURLException, NotBoundException {
        Integer id = this.rmiClientManager.getMatrizRemote().requisitarLogon(this.filial);
        this.filial.setId(id);
        this.rmiServerManager.iniciar(new FilialRemoteImpl(this.filial, this));
    }

    public void fecharConexao(){
        this.rmiClientManager.desconectar();
        this.rmiServerManager.finalizar(this.filial.getObjectName());
    }

    public void salvarProduto(String nome, Double valor){
        banco.insertIntoProduto(new Produto(nome, valor));
    }

    public ArrayList<Produto> obterTodosProduto(){
        return (banco.selectAllFromProduto());
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

    public GestaoCliente getGestaoCliente() {
        return gestaoCliente;
    }
}
