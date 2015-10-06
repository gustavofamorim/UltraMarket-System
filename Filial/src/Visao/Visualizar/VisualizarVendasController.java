package Visao.Visualizar;

import Controle.Controle;
import Modelo.Cliente;
import Modelo.Venda.Venda;
import Tools.Visual.Controller;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class VisualizarVendasController extends Controller implements UsaCamadaControle<Controle> {

    private Controle controle;

    @FXML
    private TableView<Cliente> dados;

    @FXML
    private TableColumn colNome;

    @FXML
    private TableColumn colDebito;

    @FXML
    private TableColumn colCPF;

    private void update(){
        this.colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colDebito.setCellValueFactory(new PropertyValueFactory<>("debito"));
        this.colCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        this.dados.getItems().addAll(this.controle.getGestaoCliente().obterTodosCliente());
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
