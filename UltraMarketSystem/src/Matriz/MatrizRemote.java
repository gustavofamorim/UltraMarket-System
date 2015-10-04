package Matriz;

import Filial.Modelo.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public interface MatrizRemote extends Remote{

    public Cliente buscarCliente(String cpf) throws RemoteException;

}
