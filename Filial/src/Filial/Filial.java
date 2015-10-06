package Filial;

import Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.rmi.RemoteException;

public class Filial extends Application {

    private static String[] args;

    @Override
    public void start(Stage primaryStage) throws Exception {

        String nome;
        Integer porta = -1;
        String hostName;

        if(args.length < 3){
            showInputError();
            die();
        }

        try{
            porta = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e){
            showInputError();
            die();
        }

        if(porta <= 1024){
            showInputError();
            die();
        }

        nome = args[0];
        hostName = args[1];
        try{
            final Controle controle = new Controle(nome, hostName, porta);

            WindowController janela = WindowLoader.loadWindow("/Visao/FilialMainWindow.fxml");
            ((UsaCamadaControle) janela.getInternalController()).setControle(controle);
            janela.setResizable(false);
            janela.setOnCloseRequest(event -> {
                controle.fecharConexao();
            });
            janela.show();
        }catch (Exception e){
            WindowLoader.showException("Erro ao iniciar controlador.", "Ocorreu um erro irrecuperável.", e);
            die();
        }
    }

    public static void main(String[] args) {
        Filial.args = args;

        System.out.println("Conteudo");
        for(String s: args){
            System.out.println(s);
        }
        System.out.println("end");
        launch(args);
    }

    private void showInputError(){
        WindowLoader.showError("Argumento Inválido", "Os argumentos obtidos não são válidos.", "Invoque o programa com a seguinte combinação:\n <Nome da Filial> <Porta>");
    }

    private void die(){
        System.exit(-1);
    }
}
