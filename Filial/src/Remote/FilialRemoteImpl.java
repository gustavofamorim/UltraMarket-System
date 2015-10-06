package Remote;

import Controle.Controle;
import Modelo.Cliente;
import Modelo.Filial;

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
        return (this.controle.buscarClienteRemote(cpf));
    }

    @Override
    public Collection<Cliente> listarTodosOsClientes() throws RemoteException{
        return null;
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
