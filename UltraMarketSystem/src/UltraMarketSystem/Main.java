package UltraMarketSystem;

import Tools.Controller;
import Tools.PaneLoader;
import Tools.WindowController;
import Tools.WindowLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        WindowController janela = WindowLoader.loadWindow("/Filial/Visao/FilialMainWindow.fxml", 700, 400);
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
