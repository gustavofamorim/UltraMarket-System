package Matriz;

import Filial.Modelo.Cliente;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class MatrizRemoteImpl extends UnicastRemoteObject implements MatrizRemote{

    public MatrizRemoteImpl() throws RemoteException{

    }

    @Override
    public Cliente buscarCliente(String cpf) throws RemoteException {
        return null;
    }
}
