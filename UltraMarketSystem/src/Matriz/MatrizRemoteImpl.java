package Matriz;

import Filial.FilialRemote;
import Filial.Modelo.Cliente;
import Filial.Modelo.Filial;
import Filial.Modelo.FilialBuilder;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
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
    public Filial requisitarLogon(FilialRemote filial, String nome) throws RemoteException {

        FilialBuilder builder = new FilialBuilder();
        Filial novaFilial = builder.getInstance(this.lastId, nome);

        this.filiaisOnline.put(this.lastId, filial);
        this.lastId++;

        return (novaFilial);
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

        for(FilialRemote filial : this.filiaisOnline.values()){
            Cliente cliente = filial.existeCliente(cpf);

            if(cliente != null){
                return (cliente);
            }
        }

        return null;
    }
}