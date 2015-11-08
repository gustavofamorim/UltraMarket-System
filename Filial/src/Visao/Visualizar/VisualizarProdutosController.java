package Visao.Visualizar;

import Controle.Control;
import Modelo.Produto;
import Tools.Visual.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Gustavo Freitas on 05/10/2015.
 */
public class VisualizarProdutosController extends Controller {

    @FXML
    private TableView<Produto> dados;

    @FXML
    private TableColumn colNome;

    @FXML
    private TableColumn colValor;

    private void update(){

        this.colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        this.dados.getItems().addAll(Controle.Control.getInstance().getGestaoProduto().obterTodosProduto());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }
}
