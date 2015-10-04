package Remote.MatrizRemote;

import Modelo.Filial;
import Modelo.Cliente;
import Remote.FilialRemote.FilialRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public interface MatrizRemote extends Remote{

    public static final Integer PORTA = 1099;
    public static final String HOST_NAME = "localhost";
    public static final String OBJECT_NAME = "matriz";

    public Filial requisitarLogon(FilialRemote filial, String nome) throws RemoteException;

    public boolean requisitarLogOff(FilialRemote filial) throws RemoteException;

    public Cliente buscarCliente(String cpf) throws RemoteException;

}
