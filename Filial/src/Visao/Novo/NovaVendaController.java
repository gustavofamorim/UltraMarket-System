package Visao.Novo;

import Controle.Controle;
import Modelo.Cliente;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class NovaVendaController extends Controller implements UsaCamadaControle<Controle>{

    private Controle controle = null;

    @FXML
    private ListView<Produto> itens;

    @FXML
    private ListView<ItemVenda> itensAdicionados;

    @FXML
    private TextField desconto;

    @FXML
    private TextField valorPago;

    @FXML
    private ComboBox<Cliente> clientes;

    @FXML
    private void addItem(ActionEvent event){
        Produto selecionado = this.itens.getSelectionModel().getSelectedItem();
        if(selecionado != null){

            Optional<String> quantidade = null;

            while(quantidade == null) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Quantidade");
                dialog.setHeaderText("");
                dialog.setContentText("Quantidade: ");

                quantidade = dialog.showAndWait();

                try{
                    if(Integer.parseInt(quantidade.get()) <= 0){
                        quantidade = null;
                    }
                }
                catch (NumberFormatException e){
                    WindowLoader.showError("Entrada Inválida.", "Quantidade é um campo numérico.", "");
                }
            }

            this.itensAdicionados.getItems().addAll(new ItemVenda(selecionado, Integer.parseInt(quantidade.get())));
        }
    }

    @FXML
    private void finalizar(ActionEvent event){
        if(this.controle == null){
            throw new NullPointerException("O controlador não foi setado.");
        }
        else {
            if (this.itensAdicionados.getItems().size() == 0) {
                WindowLoader.showError("Venda sem itens.", "Adicione itens para prosseguir.", "");
            } else {
                try {
                    Double desconto = Double.parseDouble(this.desconto.getText().replace(",", "."));
                    Double valorPago = Double.parseDouble(this.valorPago.getText().replace(",", "."));
                    this.controle.novaVenda(this.itensAdicionados.getItems(), valorPago, desconto, this.clientes.getSelectionModel().getSelectedItem());
                } catch (NumberFormatException e) {
                    WindowLoader.showError("Entrada Incorreta", "Desconto e Valor Pago devem ser números.", "");
                }

                this.limpar();
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.itensAdicionados.getItems().clear();
        this.desconto.setText("");
        this.valorPago.setText("");
        this.clientes.getSelectionModel().clearSelection();
    }

    public void update(){
        this.itens.getItems().addAll(this.controle.obterTodosProduto());
        this.clientes.getItems().addAll(this.controle.obterTodosCliente());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            while(this.controle == null){}
            this.update();
        });
    }

    @Override
    public Controle getControle() {
        return (this.controle);
    }

    @Override
    public void setControle(Controle controle){
        this.controle = controle;
    }
}
