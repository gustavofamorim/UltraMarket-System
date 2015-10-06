package Matriz;

import javafx.stage.Stage;

import static java.rmi.registry.LocateRegistry.createRegistry;
import static java.rmi.registry.LocateRegistry.getRegistry;

public class Main extends FXMLApplication {

    @Override
    public void start(Stage primaryStage) {
        associateFile("../Visao/Matriz.fxml");
        start(getScene(), "Servidor Matriz", FXMLApplication.STAGE_SHOW);

        //For�a o fechamento da aplica��o quando a janela � fechada
        getStage().setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
