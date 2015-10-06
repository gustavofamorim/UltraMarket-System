package Remote;

import Controle.RMIManager;
import Modelo.Cliente;
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
        return MatrizController.filiais.remove(filial);
    }

    @Override
    public Cliente buscarCliente(Integer idFilial, String cpf) throws RemoteException {
        Cliente cliente;
        for (Filial filial : MatrizController.filiais) {
            FilialRemote filialRemote = (FilialRemote) RMIManager.getInstance().lookup(filial.getHostName(), filial.getServerPort(), filial.getObjectName());
            cliente = filialRemote.existeCliente(cpf);
            if (cliente != null) {
                return cliente;
            }
        }
        return null;
    }
}