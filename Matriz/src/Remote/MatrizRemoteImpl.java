package Remote;

import Controle.RMIManager;
import Modelo.Cliente;
import Modelo.Filial;
import Visao.MatrizController;
import javafx.application.Platform;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class MatrizRemoteImpl extends UnicastRemoteObject implements MatrizRemote {

    int lastId = 0;

    public MatrizRemoteImpl() throws RemoteException {}

    @Override
    public int requisitarLogon(Filial filial) throws RemoteException {
        //Adiciona a ação na thread FX para evitar erros dentro da thread principal.
        Platform.runLater(()->{
            MatrizController.filiais.add(filial);
        });

        filial.setId(this.lastId);
        this.lastId++;
        System.out.println("Filial se conectou: " + filial.getNome());
        return (filial.getId());
    }

    @Override
    public boolean requisitarLogOff(Integer idFilial) throws RemoteException {
        for(Filial filial : MatrizController.filiais){
            if(filial.getId().equals(idFilial)){
                Platform.runLater(()-> {
                    MatrizController.filiais.remove(filial);
                });
                return (true);
            }
        }
        return (false);
    }

    @Override
    public Cliente buscarCliente(Integer idFilial, String cpf) throws RemoteException {
        Cliente cliente;
        for (Filial filial : MatrizController.filiais) {
            if(!filial.getId().equals(idFilial)) {
                FilialRemote filialRemote = (FilialRemote) RMIManager.getInstance().lookup(filial.getHostName(), filial.getServerPort(), filial.getObjectName());
                if(filialRemote != null) {
                    cliente = filialRemote.existeCliente(cpf);
                    if (cliente != null) {
                        return cliente;
                    }
                }
            }
        }
        return null;
    }
}