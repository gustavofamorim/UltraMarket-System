package Filial.Visao.Novo;

import Filial.Controle.Controle;
import Filial.Modelo.Cliente;
import Filial.Modelo.Produto;
import Filial.Modelo.Venda.ItemVenda;
import Tools.Controller;
import Tools.WindowLoader;
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
public class NovaVendaController extends Controller {

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
                    WindowLoader.showError("Entrada Inv�lida.", "Quantidade � um campo num�rico.", "");
                }
            }

            this.itensAdicionados.getItems().addAll(new ItemVenda(selecionado, Integer.parseInt(quantidade.get())));
        }
    }

    @FXML
    private void finalizar(ActionEvent event){

        if(this.itensAdicionados.getItems().size() == 0){
            WindowLoader.showError("Venda sem itens.", "Adicione itens para prosseguir.", "");
        }
        else {
            try {
                Double desconto = Double.parseDouble(this.desconto.getText().replace(",", "."));
                Double valorPago = Double.parseDouble(this.valorPago.getText().replace(",", "."));
                Controle.novaVenda(this.itensAdicionados.getItems(), valorPago, desconto, this.clientes.getSelectionModel().getSelectedItem());
            } catch (NumberFormatException e) {
                WindowLoader.showError("Entrada Incorreta", "Desconto e Valor Pago devem ser n�meros.", "");
            }

            this.limpar();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.itens.getItems().addAll(Controle.obterTodosProduto());
        this.clientes.getItems().addAll(Controle.obterTodosCliente());
    }
}
