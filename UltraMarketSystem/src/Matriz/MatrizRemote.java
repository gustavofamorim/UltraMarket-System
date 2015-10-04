package Matriz;

import Filial.Modelo.Filial;
import Filial.Modelo.Cliente;
import Filial.FilialRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public interface MatrizRemote extends Remote{

    public Filial requisitarLogon(FilialRemote filial, String nome) throws RemoteException;

    public boolean requisitarLogOff(FilialRemote filial) throws RemoteException;

    public Cliente buscarCliente(String cpf) throws RemoteException;

}
