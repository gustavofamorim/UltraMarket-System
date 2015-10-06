package Remote;

import Modelo.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public interface FilialRemote extends Remote {

    public Cliente existeCliente(String cpf) throws RemoteException;
    public Collection<Cliente> listarTodosOsClientes() throws RemoteException;

    public Integer getId() throws RemoteException;
    public String getNome() throws RemoteException;

}
