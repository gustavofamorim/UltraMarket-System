package UltraMarketSystem;

import Filial.Filial;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Filial filial = new Filial();
        filial.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
