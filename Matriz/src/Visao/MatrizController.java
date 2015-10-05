package Visao;

import Controle.Controle;
import Modelo.Filial;
import Remote.MatrizRemote;
import Tools.Visual.Controller;
import Tools.Visual.UsaCamadaControle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Controle.RMIManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class MatrizController extends Controller implements UsaCamadaControle<Controle> {
    public static ObservableList<Filial> filiais = FXCollections.observableArrayList();

    private Controle controle;
    private RMIManager rmiManager;

    @FXML
    private Button iniciar;
    @FXML
    private Button finalizar;
    @FXML
    private ListView<Filial> lista;
    @FXML
    private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rmiManager = RMIManager.getInstance();
        finalizar.setDisable(true);
        lista.setItems(MatrizController.filiais);
    }

    @Override
    public Controle getControle() {
        return (this.controle);
    }

    @Override
    public void setControle(Controle controle) {
        this.controle = controle;
    }

    @FXML
    private void iniciarClick() {
        iniciar.setDisable(true);
        finalizar.setDisable(false);
        rmiManager.rebind(MatrizRemote.PORTA, MatrizRemote.OBJECT_NAME);
        status.setText("Servidor iniciado na porta: " + MatrizRemote.PORTA);
        status.setTextFill(Color.GREEN);
    }

    @FXML
    private void finalizarClick() {
        iniciar.setDisable(false);
        finalizar.setDisable(true);
        rmiManager.unbind(MatrizRemote.OBJECT_NAME);
        status.setText("Não iniciado");
        status.setTextFill(Color.RED);
    }
}
