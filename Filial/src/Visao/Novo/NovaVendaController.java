package Visao.Novo;

import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;
import services.Cliente;
import Modelo.Venda.ItemVenda;
import Modelo.Produto;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class NovaVendaController extends Controller{
    
    private Cliente cliente = null;

    @FXML
    private ListView<Produto> itens;

    @FXML
    private ListView<ItemVenda> itensAdicionados;

    @FXML
    private TextField desconto;

    @FXML
    private TextField valorPago;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Label resultadoBusca;

    @FXML
    private Label debitosCliente;

    @FXML
    private ToggleButton buscaToggle;

    @FXML
    private void novoCliente(ActionEvent event){
        cliente = Controle.Control.getInstance().getGestaoCliente().windowSaveCliente();
        
        if(cliente != null){
            resultadoBusca.setText("Nome: " + cliente.getNome());
            debitosCliente.setText("Débito: " + cliente.getSaldo());
        }
    }

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
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setItem(selecionado);
            itemVenda.setQtd(Integer.parseInt(quantidade.get()));
            itemVenda.setTotal(selecionado.getValor()*itemVenda.getQtd());
            itensAdicionados.getItems().add(itemVenda);
        }
    }

    @FXML
    private void finalizar(ActionEvent event){
        if (itensAdicionados.getItems().isEmpty() || cliente == null) {
            WindowLoader.showError("Venda sem itens.", "Adicione itens para prosseguir.", "");
        }
        else {
            Controle.Control.getInstance().getGestaoVenda().novaVenda(this);
            limpar();
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        limpar();
    }

    public void limpar(){
        itensAdicionados.getItems().clear();
        desconto.setText("");
        valorPago.setText("");
        cliente = null;
        resultadoBusca.setText("Nome: ");
        debitosCliente.setText("Débitos: ");
    }

    public void update(){
        itens.getItems().addAll(Controle.Control.getInstance().getGestaoProduto().obterTodosProduto());  
    }

    @FXML
    private void buscarCliente(ActionEvent event){    
        if(!cpfCliente.getText().isEmpty()){
            cliente = Controle.Control.getInstance().getGestaoCliente().searchCliente(cpfCliente.getText());

            if(cliente == null){
                WindowLoader.showMessage("Não cadastrado", "O cliente não está cadastrado na nossa base de dados.\nCadastre-o.");
            }
            else {
                resultadoBusca.setText("Nome: " + cliente.getNome());
                debitosCliente.setText("Débitos: " + cliente.getSaldo());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDesconto() {
        return desconto.getText();
    }

    public String getValorPago() {
        return valorPago.getText();
    }

    public Collection<ItemVenda> getItensAdicionados() {
        return itensAdicionados.getItems();
    }
    
    
}
