package Matriz;

import Modelo.MatrizRemote;
import Modelo.MatrizRemoteImpl;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import java.rmi.Naming;
import java.rmi.registry.Registry;

import static java.rmi.registry.LocateRegistry.createRegistry;
import static java.rmi.registry.LocateRegistry.getRegistry;

public class Main extends FXMLApplication {

    @Override
    public void start(Stage primaryStage) {
        associateFile("../Visao/Matriz.fxml");
        start(getScene(), "Servidor Matriz", FXMLApplication.STAGE_SHOW);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
