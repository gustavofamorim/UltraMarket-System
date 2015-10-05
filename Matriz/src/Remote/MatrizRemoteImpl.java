package Remote;

import Modelo.Filial;
import Visao.MatrizController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class MatrizRemoteImpl extends UnicastRemoteObject implements MatrizRemote {

    int lastId = 0;

    public MatrizRemoteImpl() throws RemoteException {}

    @Override
    public int requisitarLogon(Filial filial) throws RemoteException {
        MatrizController.filiais.add(filial);
        filial.setId(this.lastId);
        this.lastId++;
        System.out.println("Filial se conectou: " + filial.getNome());
        return (filial.getId());
    }

    @Override
    public boolean requisitarLogOff(Filial filial) throws RemoteException {
//        if(filiaisOnline.containsKey(filial.getId())){
//            filiaisOnline.remove(filial.getId());
//            return (true);
//        }
        return false;
    }
}