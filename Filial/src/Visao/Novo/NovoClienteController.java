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
import Tools.Visual.WindowLoader;

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
    private Button cancelarButton;

    @FXML
    private void cadastrar(ActionEvent event){
        if (!getNome().isEmpty() && !getCPF().isEmpty()) {
            cliente = Control.getInstance().getGestaoCliente().saveCliente(this);
            if (cliente != null) {
                WindowLoader.showMessage("Cliente cadastrado", "O cliente foi cadastrado com sucesso!");
                if(getMyStage() != null){
                    getMyStage().close();
                }
                limpar();
            } else {
                WindowLoader.showError("Cliente não cadastrado", "Ocorreu um erro ao cadastrar o cliente!",
                                       "Por favor, tente novamente.\n Caso o erro persista, entre em contato com "
                                     + "o administrador do sistema.");
            }
        } else {
            WindowLoader.showError("Campos não preenchidos", "Preencha todos os campos!", "É necessário que todos os campos estejam preenchidos.");
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        limpar();
        if(getMyStage() != null){
            getMyStage().close();
        }
    }

    public void limpar(){
        nome.setText("");
        CPF.setText("");
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
