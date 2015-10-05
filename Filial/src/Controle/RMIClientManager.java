package Controle;


import Remote.MatrizRemote;

import java.rmi.Naming;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class RMIClientManager {

    private static MatrizRemote matriz = null;
    private static RMIClientManager instance = null;

    private RMIClientManager() {}

    public static RMIClientManager getInstance() {
        if (RMIClientManager.instance == null) {
            RMIClientManager.instance = new RMIClientManager();
        }
        return RMIClientManager.instance;
    }

    public MatrizRemote getMatrizRemote() {
        if (RMIClientManager.matriz == null) {
            this.conectar();
            return (RMIClientManager.matriz);
        }
        return (RMIClientManager.matriz);
    }

    public boolean conectar() {

        try {
            System.out.println("Conectando-se com a matriz.");
            RMIClientManager.matriz = (MatrizRemote) Naming.lookup("rmi://" + MatrizRemote.HOST_NAME + "/" + MatrizRemote.OBJECT_NAME);
            System.out.println("Conectado com sucesso! =D");
            return (true);
        }
        catch (Exception e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean desconectar() {
        RMIClientManager.matriz = null;
        return (true);
    }
}
