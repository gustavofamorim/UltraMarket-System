package Modelo;

import Modelo.FilialRemote.FilialBuilder;
import Modelo.FilialRemote.FilialRemote;
import Modelo.FilialRemote.Filial;


import java.rmi.RemoteException;
import java.rmi.registry.Registry;
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
    public Filial requisitarLogon(String hostname, Integer porta) throws RemoteException {

        FilialBuilder builder = new FilialBuilder();
        Filial novaFilial = builder.getInstance(lastId, "Filial " + lastId, hostname, porta);

        filiaisOnline.put(lastId, novaFilial);
        lastId++;

        return (novaFilial);
    }

    @Override
    public boolean requisitarLogOff(FilialRemote filial) throws RemoteException {

        if(this.filiaisOnline.values().contains(filial)){
            this.filiaisOnline.remove(filial.getId());
            return (true);
        }
        filiaisOnline.get(0);
        return false;
    }

    @Override
    public Cliente buscarCliente (String cpf)throws RemoteException {

        Cliente cliente;
        FilialRemote filialRemote;
        Registry registry;
        for(Filial filial : this.filiaisOnline.values()){
//            if((cliente = filial.existeCliente(cpf)) != null){
//                return (cliente);
//            }
        }

        return null;
    }
}