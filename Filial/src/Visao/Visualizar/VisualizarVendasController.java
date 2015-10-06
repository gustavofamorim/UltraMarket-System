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
    private TableView<Venda> dados;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colData;

    private void update(){
        this.colId.setCellValueFactory(new PropertyValueFactory<>("cod"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        this.colData.setCellValueFactory(new PropertyValueFactory<>("dataEHora"));
        this.dados.getItems().addAll(this.controle.getGestaoVenda().obterTodosVenda());
    }

    @FXML
    private void verDetalhes(ActionEvent event){
        WindowController detalhes = WindowLoader.loadWindow("/Visao/Visualizar/DetalheVenda.fxml");
        ((DetalheVendaController)detalhes.getInternalController()).setDados(this.dados.getSelectionModel().getSelectedItem());
        detalhes.setResizable(false);
        detalhes.getInternalController().setMyStage(detalhes);
        detalhes.showAndWait();
    }

    @FXML
    private void cancelarVenda(ActionEvent event){
        this.controle.getGestaoVenda().cancelarVenda(this.dados.getSelectionModel().getSelectedItem());
        WindowLoader.showMessage("Venda cancelada", "A venda foi cancelada.\nO cliente foi ressarcido com o valor pago.");
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
