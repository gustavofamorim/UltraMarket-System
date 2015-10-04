package Banco;

import Modelo.Cliente;
import Modelo.Produto;
import Modelo.Venda.Venda;

import java.util.ArrayList;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class BankSimulator {

    ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Venda> vendas = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public void insertIntoProduto(Produto p){
        this.produtos.add(p);
    }

    public void insertIntoCliente(Cliente c){
        this.clientes.add(c);
        System.out.println(c);
    }

    public void insertIntoVendas(Venda p){
        this.vendas.add(p);
    }

    public ArrayList<Produto> selectAllFromProduto(){
        return (this.produtos);
    }

    public ArrayList<Cliente> selectAllFromCliente(){
        return (this.clientes);
    }

    public ArrayList<Venda> selectAllFromVenda(){
        return (this.vendas);
    }
}
