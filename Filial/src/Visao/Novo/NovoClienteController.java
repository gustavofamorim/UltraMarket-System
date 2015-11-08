package Visao.Novo;

import Controle.Control;
import Tools.Visual.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import Modelo.Cliente;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class NovoClienteController extends Controller implements Initializable{
    
    Cliente cliente;
    
    @FXML
    private TextField nome;

    @FXML
    private TextField CPF;

    @FXML
    public Button cancelarButton;

    @FXML
    private void cadastrar(ActionEvent event){
        this.cliente = Control.getInstance().getGestaoCliente().saveCliente(this);
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

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public String getCPF() {
        return CPF.getText();
    }

    public void setCPF(String CPF) {
        this.CPF.setText(CPF);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
