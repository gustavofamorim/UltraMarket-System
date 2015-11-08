package Visao.Visualizar;

import Controle.Control;
import Modelo.Cliente;
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
public class VisualizarClientesController extends Controller {

    @FXML
    private TableView<Cliente> dados;

    @FXML
    private TableColumn colNome;

    @FXML
    private TableColumn colSaldo;

    @FXML
    private TableColumn colCPF;

    private void update(){
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        dados.getItems().addAll(Controle.Control.getInstance().getGestaoCliente().obterTodosCliente());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }
}