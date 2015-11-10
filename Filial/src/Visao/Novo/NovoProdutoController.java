package Visao.Novo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */

import Controle.Control;
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
        Control.getInstance().getGestaoProduto().saveProduto(this);
        WindowLoader.showMessage("Produto cadastrado", "O produto foi cadastrado!", "O produto foi cadastrado com sucesso.");
        limpar();
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.nome.setText("");
        this.valor.setText("");
    }
    
    public String getNome() {
        return nome.getText();
    }
    
    public String getValor() {
        return valor.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
