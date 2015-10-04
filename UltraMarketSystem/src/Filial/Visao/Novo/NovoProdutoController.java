package Filial.Visao.Novo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */

import Filial.Controle.Controle;
import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NovoProdutoController extends Controller {

    @FXML
    private TextField nome;

    @FXML
    private TextField valor;

    @FXML
    private void cadastrar(ActionEvent event){
        if(this.nome.getText().length() == 0 && this.valor.getText().length() == 0){
            WindowLoader.showError("Preencha todos os campos.", "� necess�rio que todos os campos estejam preenchidos.", "");
        }
        else {
            Controle.salvarProduto(this.nome.getText(), Double.parseDouble(this.valor.getText().replace(",", ".")));
            this.limpar();
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.nome.setText("");
        this.valor.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
