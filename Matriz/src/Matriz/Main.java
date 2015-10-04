package Matriz;

import Modelo.MatrizRemote;
import Modelo.MatrizRemoteImpl;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.Naming;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            java.rmi.registry.LocateRegistry.createRegistry(MatrizRemote.PORTA);
            MatrizRemote matriz = new MatrizRemoteImpl();
            Naming.rebind(MatrizRemote.OBJECT_NAME, matriz);
            WindowLoader.showMessage("Matriz iniciada.", "O servidor matriz foi iniciado com sucesso na porta: " + MatrizRemote.PORTA);
        }
        catch (Exception e){
            WindowLoader.showException("Erro ao iniciar servidor Matriz.", "Erro na inicialização do servidor Matriz.", e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
