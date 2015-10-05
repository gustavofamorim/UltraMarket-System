package Controle;

import Modelo.MatrizRemote;
import Modelo.MatrizRemoteImpl;
import Tools.Visual.WindowLoader;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import static java.rmi.registry.LocateRegistry.createRegistry;
import static java.rmi.registry.LocateRegistry.getRegistry;

/**
 * Created by Emerson C. Romaneli on 04/10.
 */
public class RMIManager {
    private static RMIManager instance;
    private Registry registry;

    private RMIManager() {}

    public static RMIManager getInstance() {
        if (instance == null) {
            instance = new RMIManager();
        }
        return instance;
    }

    public boolean rebind(int porta, String objectName) {
        try {
            registry = createRegistry(porta);
        } catch (RemoteException ex) {
            try {
                System.out.println("Registro já foi criado, tentar conectar.");
                registry = getRegistry(porta);
            } catch (RemoteException e) {
                WindowLoader.showMessage("Erro ao iniciar servidor.", "Falha ao inicar servidor RMI.");
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        try {
            MatrizRemote matriz = new MatrizRemoteImpl();
            Naming.rebind(objectName, matriz);
            return true;
        } catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Matriz.", "Erro na inicializa��o do servidor Matriz.", e);
            return false;
        }
    }

    public boolean unbind(String objectName) {
        try {
            registry.unbind(objectName);
            return true;
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object lookup(String hostname, int porta, String objectName) {
        try {
            MatrizRemote matriz = new MatrizRemoteImpl();
            Object object = Naming.lookup("rmi://" + hostName + "/" + objeto);
            return Naming.lookup("rmi://"+hostname+":"+porta+"/"+objectName);
        } catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Matriz.", "Erro na inicializa��o do servidor Matriz.", e);
            return null;
        }
    }
}
