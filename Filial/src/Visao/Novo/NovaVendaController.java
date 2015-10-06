package Visao.Novo;

import Controle.Controle;
import Modelo.Cliente;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.Controller;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class NovaVendaController extends Controller implements UsaCamadaControle<Controle>{

    private Cliente cliente = null;
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
    private TextField cpfCliente;

    @FXML
    private Label resultadoBusca;

    @FXML
    private Label debitosCliente;

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
        if(this.controle == null){
            throw new NullPointerException("O controlador n�o foi setado.");
        }
        else {
            if (this.itensAdicionados.getItems().size() == 0) {
                WindowLoader.showError("Venda sem itens.", "Adicione itens para prosseguir.", "");
            }
            else {
                try {
                    Double desconto = Double.parseDouble(this.desconto.getText().replace(",", "."));
                    Double valorPago = Double.parseDouble(this.valorPago.getText().replace(",", "."));
                    this.controle.novaVenda(this.itensAdicionados.getItems(), valorPago, desconto, null);
                } catch (NumberFormatException e) {
                    WindowLoader.showError("Entrada Incorreta", "Desconto e Valor Pago devem ser n�meros.", "");
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
    }

    public void update(){
        this.itens.getItems().addAll(this.controle.obterTodosProduto());
    }

    @FXML
    private void buscarCliente(ActionEvent event){
        if(this.cpfCliente.getText().length() > 0){
            this.cliente = this.controle.buscarCliente(this.cpfCliente.getText());

            if(this.cliente == null){
                WindowLoader.showMessage("Cliente n�o cadastrado", "O cliente n�o est� cadastrado.\nPor favor cadastre-o.");
                WindowController janela = WindowLoader.loadWindow("/Visao/Novo/NovoCliente.fxml");
                ((UsaCamadaControle)janela.getInternalController()).setControle(this.controle);
                janela.getInternalController().setMyStage(janela);
                janela.showAndWait();
                this.cliente = this.controle.obterTodosCliente().get(this.controle.obterTodosCliente().size() - 1);
            }
            this.resultadoBusca.setText("Nome: " + this.cliente.getNome());
            this.debitosCliente.setText("D�bito: " + this.cliente.getDebito());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public Controle getControle() {
        return (this.controle);
    }

    @Override
    public void setControle(Controle controle){
        this.controle = controle;
        this.update();
    }
}
