package Visao.Visualizar;

import Modelo.Venda.Venda;
import Tools.Visual.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class VisualizarVendasController extends Controller{

    @FXML
    private TableView<Venda> dados;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colData;

    @FXML
    private TableColumn colStatus;

    private void update(){

        this.colId.setCellValueFactory(new PropertyValueFactory<>("cod"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        this.colData.setCellValueFactory(new PropertyValueFactory<>("dataEHora"));
        this.colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        this.dados.getItems().addAll(Controle.Control.getInstance().getGestaoVenda().obterTodosVenda());

    }

    @FXML
    private void verDetalhes(ActionEvent event){
/*
        WindowController detalhes = WindowLoader.loadWindow("/Visao/Visualizar/DetalheVenda.fxml");
        ((DetalheVendaController)detalhes.getInternalController()).setDados(this.dados.getSelectionModel().getSelectedItem());
        detalhes.setResizable(false);
        detalhes.getInternalController().setMyStage(detalhes);
        detalhes.showAndWait();
*/
    }

    @FXML
    private void cancelarVenda(ActionEvent event){
/*
        this.controle.getGestaoVenda().cancelarVenda(this.dados.getSelectionModel().getSelectedItem());
        WindowLoader.showMessage("Venda cancelada", "A venda foi cancelada.\nO cliente foi ressarcido com o valor pago.");
        this.dados.getItems().clear();
        this.dados.getItems().addAll(this.controle.getGestaoVenda().obterTodosVenda());
*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }
}
