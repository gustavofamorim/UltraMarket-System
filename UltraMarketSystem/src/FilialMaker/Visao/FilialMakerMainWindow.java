package FilialMaker.Visao;

import FilialMaker.FilialMaker;
import Tools.Visual.Controller;
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

    @FXML
    private TextField nome;

    @FXML
    private TextField id;

    @FXML
    public void criar(ActionEvent event){
        this.limpar();
    }

    @FXML
    public void cancelar(ActionEvent event){
        this.limpar();
        this.atualizarId();
    }

    public void limpar(){
        this.nome.setText("");
    }

    public void atualizarId(){
        //Solicita o id à matriz.
        this.id.setText("" + 1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.atualizarId();
    }
}
