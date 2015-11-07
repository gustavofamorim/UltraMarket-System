package Visao.Visualizar;

import Controle.Controle;
import Tools.Visual.Controller;
import Tools.Visual.UsaCamadaControle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class VisualizarProdutosController extends Controller implements UsaCamadaControle<Controle> {

    private Controle controle;

    //@FXML
    //private TableView<Produto> dados;

    @FXML
    private TableColumn colNome;

    @FXML
    private TableColumn colValor;

    private void update(){
/*
        this.colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        this.dados.getItems().addAll(this.controle.getGestaoProduto().obterTodosProduto());
*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public Controle getControle() {
        return (this.controle);
    }

    @Override
    public void setControle(Controle controle) {
        this.controle = controle;
        this.update();
    }
}
