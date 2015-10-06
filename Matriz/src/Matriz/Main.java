package Matriz;

import javafx.stage.Stage;

import static java.rmi.registry.LocateRegistry.createRegistry;
import static java.rmi.registry.LocateRegistry.getRegistry;

public class Main extends FXMLApplication {

    @Override
    public void start(Stage primaryStage) {
        associateFile("../Visao/Matriz.fxml");
        start(getScene(), "Servidor Matriz", FXMLApplication.STAGE_SHOW);

        //Força o fechamento da aplicação quando a janela é fechada
        getStage().setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
