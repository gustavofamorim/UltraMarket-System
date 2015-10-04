package Filial.Controle;

import Filial.Banco.BankSimulator;
import Filial.Modelo.Cliente;
import Filial.Modelo.Produto;
import Filial.Modelo.Venda.ItemVenda;
import Filial.Modelo.Venda.VendaBuilder;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Controle {

    private static BankSimulator banco = new BankSimulator();

    public static void salvarProduto(String nome, Double valor){
        banco.insertIntoProduto(new Produto(nome, valor));
    }

    public static void salvarCliente(String nome, String CPF){
        banco.insertIntoCliente(new Cliente(nome, CPF));
    }

    public static ArrayList<Produto> obterTodosProduto(){
        return (banco.selectAllFromProduto());
    }

    public static ArrayList<Cliente> obterTodosCliente(){
        return (banco.selectAllFromCliente());
    }

    public static void novaVenda(Collection<ItemVenda> itens, Double pagamento, Double desconto, Cliente cliente){

        desconto /= 100;

        VendaBuilder builder = new VendaBuilder();
        builder.addItens(itens);
        builder.darDesconto(desconto);
        builder.pagar(pagamento);
        builder.cliente(cliente);

        banco.insertIntoVendas(builder.getInstance());
    }
}
