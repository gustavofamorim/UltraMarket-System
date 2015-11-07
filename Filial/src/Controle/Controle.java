package Controle;

import Modelo.Filial;
import Modelo.Produto;

import java.net.MalformedURLException;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Controle {

    public static Filial filial = null;

    protected final GestaoCliente gestaoCliente = new GestaoCliente(this);
    protected final GestaoVenda gestaoVenda = new GestaoVenda(this);
    protected final GestaoProduto gestaoProduto = new GestaoProduto(this);

    public Controle(String nome, String hostName, Integer porta) throws MalformedURLException {
//        Controle.filial = new Filial(nome, hostName, porta, nome);
//        this.iniciarConexao();
    }

    public void iniciarConexao() throws MalformedURLException {
        //Integer id = this.rmiClientManager.getMatrizRemote().requisitarLogon(this.filial);
        //this.filial.setId(id);
        //this.rmiServerManager.iniciar(new FilialRemoteImpl(this.filial, this));
    }

    public void fecharConexao(){
        //this.rmiClientManager.desconectar();
        //this.rmiServerManager.finalizar(this.filial.getObjectName());
    }

    public GestaoCliente getGestaoCliente() {
        return gestaoCliente;
    }

    public GestaoProduto getGestaoProduto() {
        return gestaoProduto;
    }

    public GestaoVenda getGestaoVenda() {
        return gestaoVenda;
    }
}
