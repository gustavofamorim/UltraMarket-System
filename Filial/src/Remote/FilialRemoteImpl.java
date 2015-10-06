package Remote;

import Controle.Controle;
import Modelo.Cliente;
import Modelo.Filial;
import Modelo.Produto;
import Modelo.Venda.Venda;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialRemoteImpl extends UnicastRemoteObject implements FilialRemote{

    private Controle controle = null;
    private Filial filialInfo = null;

    public FilialRemoteImpl(Filial filial, Controle controle) throws RemoteException{
        this.filialInfo = filial;
        this.controle = controle;
    }

    @Override
    public Cliente existeCliente(String cpf) throws RemoteException{
        return (this.controle.getGestaoCliente().buscarClienteLocal(cpf));
    }

    @Override
    public Collection<Cliente> listarTodosOsClientes() throws RemoteException{
        return (this.controle.getGestaoCliente().obterTodosCliente());
    }

    @Override
    public Collection<Venda> listarTodasAsVendas() throws RemoteException {
        return (this.controle.getGestaoVenda().obterTodosVenda());
    }

    @Override
    public Collection<Produto> listarTodasOsProdutos() throws RemoteException {
        return (this.controle.getGestaoProduto().obterTodosProduto());
    }

    @Override
    public Integer getId() throws RemoteException{
        return (this.filialInfo.getId());
    }

    @Override
    public String getNome() throws RemoteException{
        return (this.filialInfo.getNome());
    }

    public Filial getFilialInfo() throws RemoteException{
        return (filialInfo);
    }

    public void setFilialInfo(Filial filialInfo) throws RemoteException{
        this.filialInfo = filialInfo;
    }
}
