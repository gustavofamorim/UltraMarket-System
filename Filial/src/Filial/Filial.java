package Filial;

import Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class Filial extends Application {

    private static String[] args;

    @Override
    public void start(Stage primaryStage) throws Exception{

        String nome;
        Integer porta = -1;
        String hostName;

        if(args.length < 3){
            showError();
            die();
        }

        try{
            porta = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e){
            showError();
        }

        if(porta <= 1024){
            showError();
            die();
        }


        nome = args[0];
        hostName = args[1];

        WindowController janela = WindowLoader.loadWindow("/Visao/FilialMainWindow.fxml");
        ((UsaCamadaControle)janela.getInternalController()).setControle(new Controle(nome, hostName, porta));
        janela.setResizable(false);
        janela.show();
    }

    public static void main(String[] args) {
        Filial.args = args;
        System.out.println(args);
        System.out.println("Conteudo");
        for(String s: args){
            System.out.println(s);
        }
        System.out.println("end");
        launch(args);
    }

    private void showError(){
        WindowLoader.showError("Argumento Inválido", "Os argumentos obtidos não são válidos.", "Invoque o programa com a seguinte combinação:\n <Nome da Filial> <Porta>");
    }

    private void die(){
        System.exit(-1);
    }
}
