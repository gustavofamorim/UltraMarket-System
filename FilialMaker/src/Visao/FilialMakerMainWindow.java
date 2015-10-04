package FilialMaker.Visao;

import FilialMaker.Controle.Controle;
import FilialMaker.FilialMaker;
import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMakerMainWindow extends Controller implements Initializable {

    private Controle controle = new Controle();

    @FXML
    private TextField nome;

    @FXML
    public void criar(ActionEvent event){
        if(this.nome.getText().length() > 0) {
            this.controle.registrarFilial(this.nome.getText());
        }
        else{
            WindowLoader.showError("Erro", "A filial precisa de um nome né...");
        }
        this.limpar();
    }

    @FXML
    public void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.nome.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controle.conectar();
    }
}
