package Controle;

import Remote.FilialRemote;
import Remote.FilialRemoteImpl;
import Tools.Visual.WindowLoader;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import static java.rmi.registry.LocateRegistry.createRegistry;
import static java.rmi.registry.LocateRegistry.getRegistry;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class RMIServerManager {

    private static RMIServerManager instance;
    private Registry registry;

    private RMIServerManager() {}

    public static RMIServerManager getInstance() {
        if (instance == null) {
            instance = new RMIServerManager();
        }
        return instance;
    }

    public boolean iniciar(FilialRemoteImpl filialRemote) {
        try {
            registry = createRegistry(filialRemote.getFilialInfo().getServerPort());
        } catch (RemoteException ex) {
            try {
                System.out.println("Registro já foi criado, tentar conectar.");
                registry = getRegistry(filialRemote.getFilialInfo().getServerPort());
            } catch (RemoteException e) {
                WindowLoader.showMessage("Erro ao iniciar servidor.", "Falha ao inicar servidor RMI.");
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        try {
            Naming.rebind(filialRemote.getFilialInfo().getObjectName(), filialRemote);
            return true;
        } catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Filial.", "Erro na inicialização do servidor filial.", e);
            return false;
        }
    }

    public boolean finalizar(String filialRemote) {
        try {
            registry.unbind(filialRemote);
            return true;
        } catch (RemoteException | NotBoundException e) {
            //e.printStackTrace();
            return false;
        }
    }
}
