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

    public boolean iniciar() {
        try {
            registry = createRegistry(MatrizRemote.PORTA);
        } catch (RemoteException ex) {
            try {
                System.out.println("Registro já foi criado, tentar conectar.");
                registry = getRegistry(MatrizRemote.PORTA);
            } catch (RemoteException e) {
                WindowLoader.showMessage("Erro ao iniciar servidor Matriz.", "Falha ao inicar servidor RMI.");
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        try {
            MatrizRemote matriz = new MatrizRemoteImpl();
            Naming.rebind(MatrizRemote.OBJECT_NAME, matriz);
            return true;
        } catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Matriz.", "Erro na inicializa��o do servidor Matriz.", e);
            return false;
        }
    }

    public boolean finalizar() {
        try {
            registry.unbind(MatrizRemote.OBJECT_NAME);
            return true;
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
