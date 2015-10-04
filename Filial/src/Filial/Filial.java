package Filial;

import Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Filial extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        WindowController janela = WindowLoader.loadWindow("/Visao/FilialMainWindow.fxml");
        ((UsaCamadaControle)janela.getInternalController()).setControle(new Controle());
        janela.setResizable(false);
        janela.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
