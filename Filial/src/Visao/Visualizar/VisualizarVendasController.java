package Visao.Visualizar;

import Modelo.Venda.Venda;
import Tools.Visual.Controller;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.StatusVENDA;

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
    
    @FXML
    private Button detalhes;

    private void update(){

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalLiquido"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataEHora"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        dados.getItems().addAll(Controle.Control.getInstance().getGestaoVenda().obterTodosVenda());
        dados.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            detalhes.setDisable(false);
        });
    }

    @FXML
    private void verDetalhes(ActionEvent event){
        WindowController detalhes = WindowLoader.loadWindow("/Visao/Visualizar/DetalheVenda.fxml");
        ((DetalheVendaController)detalhes.getInternalController()).setDados(dados.getSelectionModel().getSelectedItem());
        detalhes.setResizable(false);
        detalhes.getInternalController().setMyStage(detalhes);
        detalhes.showAndWait();
    }

    @FXML
    private void cancelarVenda(ActionEvent event){
        Venda selecionada = dados.getSelectionModel().getSelectedItem();
        if (selecionada.getStatus() != StatusVENDA.CANCELADA) {
            Controle.Control.getInstance().getGestaoVenda().cancelarVenda(dados.getSelectionModel().getSelectedItem());
            WindowLoader.showMessage("Venda cancelada", "A venda foi cancelada.\nO cliente foi ressarcido com o valor pago.");
            this.dados.getItems().clear();
            this.dados.getItems().addAll(Controle.Control.getInstance().getGestaoVenda().obterTodosVenda());
        } else {
            WindowLoader.showError("Erro ao cancelar venda", "Venda Inválida!", "A venda selecionada já se encontra cancelada.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        detalhes.setDisable(true);
        update();
    }
}
