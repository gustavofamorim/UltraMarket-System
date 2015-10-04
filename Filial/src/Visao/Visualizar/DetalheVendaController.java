package Visao.Visualizar;

import Modelo.Venda.Venda;
import Tools.Visual.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class DetalheVendaController extends Controller {

    @FXML
    private TextArea detalhesVenda;

    public void setDados(Venda venda){
        this.detalhesVenda.setText(venda.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
