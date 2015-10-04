package Modelo;

import Modelo.FilialRemote.FilialRemote;
import Modelo.FilialRemote.Filial;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class MatrizRemoteImpl extends UnicastRemoteObject implements MatrizRemote {

    int lastId = 0;
    HashMap<Integer, FilialRemote> filiaisOnline = new HashMap<>();

    public MatrizRemoteImpl() throws RemoteException {

    }

    @Override
    public Filial requisitarLogon(String hostname, Integer porta) throws RemoteException {
/*
        FilialBuilder builder = new FilialBuilder();
        Filial novaFilial = builder.getInstance(this.lastId, nome);

        this.filiaisOnline.put(this.lastId, filial);
        this.lastId++;

        return (novaFilial);*/
        return (null);
    }

    @Override
    public boolean requisitarLogOff(FilialRemote filial) throws RemoteException {

        if(this.filiaisOnline.values().contains(filial)){
            this.filiaisOnline.remove(filial.getId());
            return (true);
        }

        return false;
    }

    @Override
    public Cliente buscarCliente (String cpf)throws RemoteException {

        Cliente cliente;

        for(FilialRemote filial : this.filiaisOnline.values()){
            if((cliente = filial.existeCliente(cpf)) != null){
                return (cliente);
            }
        }

        return null;
    }
}