package Filial.Visao.Novo;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */

import Filial.Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NovoProdutoController extends Controller implements UsaCamadaControle<Controle> {

    private Controle controle;

    @FXML
    private TextField nome;

    @FXML
    private TextField valor;

    @FXML
    private void cadastrar(ActionEvent event){

        Double valor = null;

        if(this.controle == null){
            throw new NullPointerException("O controlador não foi setado.");
        }
        else {

            try {
                valor = Double.parseDouble(this.valor.getText().replace(",", "."));
            }
            catch(NumberFormatException e){
                WindowLoader.showMessage("Entrada Inválida", "Valor é um campo numérico.");
                valor = null;
            }

            if (this.nome.getText().length() == 0 && this.valor.getText().length() == 0 && valor > 0) {
                WindowLoader.showError("Preencha todos os campos.", "É necessário que todos os campos estejam preenchidos corretamente.");
            } else {
                this.controle.salvarProduto(this.nome.getText(), valor);
                this.limpar();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.nome.setText("");
        this.valor.setText("");
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
