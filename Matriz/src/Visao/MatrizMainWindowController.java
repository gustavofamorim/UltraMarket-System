package Visao;

import Controle.Controle;
import Tools.Visual.Controller;
import Tools.Visual.UsaCamadaControle;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 04/10/2015.
 */
public class MatrizMainWindowController extends Controller implements Initializable, UsaCamadaControle<Controle> {

    private Controle controle;

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
    }
}
