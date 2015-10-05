package Remote;

import Modelo.Filial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class MatrizRemoteImpl extends UnicastRemoteObject implements MatrizRemote {

    int lastId = 0;
    HashMap<Integer, Filial> filiaisOnline = new HashMap<>();

    public MatrizRemoteImpl() throws RemoteException {

    }

    @Override
    public int requisitarLogon(Filial filial) throws RemoteException {
        filial.setId(this.lastId);
        this.filiaisOnline.put(this.lastId, filial);
        this.lastId++;
        System.out.println("Filial se conectou: " + filial.getNome());
        return (filial.getId());
    }

    @Override
    public boolean requisitarLogOff(Filial filial) throws RemoteException {
        if(this.filiaisOnline.containsKey(filial.getId())){
            this.filiaisOnline.remove(filial.getId());
            return (true);
        }
        return false;
    }
}