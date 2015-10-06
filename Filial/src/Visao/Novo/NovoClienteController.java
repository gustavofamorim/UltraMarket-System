package Visao.Novo;

import Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class NovoClienteController extends Controller implements Initializable, UsaCamadaControle<Controle> {

    private Controle controle;

    @FXML
    private TextField nome;

    @FXML
    private TextField CPF;

    @FXML
    public Button cancelarButton;

    @FXML
    private void cadastrar(ActionEvent event){
        if(this.controle == null){
            throw new NullPointerException("O controlador não foi setado.");
        }
        else {
            if (this.nome.getText().length() == 0 && this.CPF.getText().length() == 0) {
                WindowLoader.showError("Preencha todos os campos.", "É necessário que todos os campos estejam preenchidos.", "");
            } else {
                this.controle.getGestaoCliente().salvarCliente(this.nome.getText(), this.CPF.getText());
                this.limpar();
                if(this.getMyStage() != null){
                    this.getMyStage().close();
                }
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
        if(this.getMyStage() != null){
            this.getMyStage().close();
        }
    }

    public void limpar(){
        this.nome.setText("");
        this.CPF.setText("");
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
    }
}
