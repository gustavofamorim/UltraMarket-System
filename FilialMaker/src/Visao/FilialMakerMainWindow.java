package Visao;

import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMakerMainWindow extends Controller implements Initializable {

    @FXML
    private TextField nome;

    @FXML
    private TextField porta;

    @FXML
    public void criar(ActionEvent event){
        Integer porta = null;

        try {
            porta = Integer.parseInt(this.porta.getText());
        }
        catch (NumberFormatException e){
            WindowLoader.showError("Dados Inválidos", "A porta é inválida.");
            porta = null;
        }

        if(this.nome.getText().length() > 0 && porta != null){
            //Inicia a filial
            try {
                //Process novaFilial = new ProcessBuilder("java -jar " + System.getProperty("user.dir") + "\\Interpretador.jar " + nome + " " + porta).start();
                Runtime.getRuntime().exec("java -jar " + System.getProperty("user.dir") + "\\Interpretador.jar " + nome + " " + porta);

                System.out.println(System.getProperty("user.dir"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            this.limpar();
        }
    }

    @FXML
    public void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.porta.setText("");
        this.nome.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
