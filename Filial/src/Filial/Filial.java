package Filial;

import Controle.Control;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Platform;

public class Filial extends Application {

    private static String[] args;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try{
            //Control.getInstance().startApplication(args[0]);
            Control.getInstance().startApplication("ola mundo");
            
            WindowController janela = WindowLoader.loadWindow("/Visao/FilialMainWindow.fxml");

            janela.setOnCloseRequest(event -> {
                Control.getInstance().endApplication();
                Platform.exit();
            });
            
            janela.setResizable(false);
            janela.show();
        }catch (Exception e){
            WindowLoader.showException("Erro ao iniciar controlador.", "Ocorreu um erro irrecuperável.", e);
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        Filial.args = args;
        launch(args);
    }

    private void showInputError(){
        WindowLoader.showError("Argumento Inválido", "Os argumentos obtidos não são válidos.", "Invoque o programa com a seguinte combinação:\n <Nome da Filial> <Porta>");
    }

    private static services.Filial logar(java.lang.String nome) {
        services.MatrizServices_Service service = new services.MatrizServices_Service();
        services.MatrizServices port = service.getMatrizServicesPort();
        return port.logar(nome);
    }
    
    
}
