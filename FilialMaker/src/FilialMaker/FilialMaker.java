package FilialMaker;

import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMaker extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WindowController janela = WindowLoader.loadWindow("/Visao/FilialMakerMainWindow.fxml");
        janela.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}
