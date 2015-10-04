package Matriz;

import Tools.Visual.WindowLoader;

import java.rmi.Naming;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Matriz {

    public static final Integer PORTA = 1099;
    public static final String NOME_OBJETO = "matriz";

    public void start(){
        try {
            java.rmi.registry.LocateRegistry.createRegistry(Matriz.PORTA);
            MatrizRemote matriz = new MatrizRemoteImpl();
            Naming.rebind(Matriz.NOME_OBJETO, matriz);
            WindowLoader.showMessage("Matriz iniciada.", "O servidor matriz foi iniciado com sucesso na porta: " + Matriz.PORTA);
        }
        catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Matriz.", "Erro na inicialização do servidor Matriz.", e);
        }
    }

}
