package Tools.Visual;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class WindowLoader {

    public static WindowController loadWindow(String source){

        WindowController janela = null;
        Controller controlador = PaneLoader.load(source);

        if(controlador != null) {
            janela = new WindowController();
            janela.setScene(new Scene(controlador.getMyPane()));
            janela.setInternalController(controlador);
        }

        return janela;
    }

    public static WindowController loadWindow(String source, double width, double height){

        WindowController janela = WindowLoader.loadWindow(source);

        if(janela != null){
            janela.setWidth(width);
            janela.setHeight(height);
        }

        return (janela);
    }

    public static void showException(String titulo, String cabecalho, Exception excessao){

        Alert erro = new Alert(Alert.AlertType.ERROR);
        TextArea mensagem;

        erro.setTitle(titulo);
        erro.setHeaderText(cabecalho);

        StringWriter sw = new StringWriter();
        excessao.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();

        mensagem = new TextArea();
        mensagem.setEditable(false);
        mensagem.setWrapText(true);
        mensagem.setText("Descrição: " + excessao.getMessage() + "\nRastro da Pilha:\n" + sw);

        mensagem.setMaxWidth(Double.MAX_VALUE);
        mensagem.setMaxHeight(Double.MAX_VALUE);
        mensagem.setMinWidth(1000.0);
        mensagem.setMinHeight(500.0);

        GridPane.setVgrow(mensagem, Priority.ALWAYS);
        GridPane.setHgrow(mensagem, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(mensagem, 0, 0);

        erro.getDialogPane().setExpandableContent(expContent);
        erro.showAndWait();
    }

    public static void showError(String titulo, String conteudo){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(conteudo);
        alert.showAndWait();
    }

    public static void showError(String titulo, String cabecalho, String conteudo){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        alert.showAndWait();
    }

    public static void showMessage(String titulo, String conteudo){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(conteudo);
        alert.showAndWait();
    }

    public static void showMessage(String titulo, String conteudo, String cabecalho){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        alert.showAndWait();
    }

}
