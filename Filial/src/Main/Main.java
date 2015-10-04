package Main;

import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        WindowController janela = WindowLoader.loadWindow("/Filial/Visao/FilialMainWindow.fxml");
        janela.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
