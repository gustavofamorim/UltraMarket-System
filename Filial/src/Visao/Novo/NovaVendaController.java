package Visao.Novo;

import Controle.Controle;
<<<<<<< HEAD
=======
import services.Cliente;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
>>>>>>> origin/master
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.Controller;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 02/10/2015.
 */
public class NovaVendaController extends Controller implements UsaCamadaControle<Controle>{

    //private Cliente cliente = null;
    private Controle controle = null;

    //@FXML
    //private ListView<Produto> itens;

    //@FXML
    //private ListView<ItemVenda> itensAdicionados;

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
    public void novoCliente(ActionEvent event){
        WindowController janela = WindowLoader.loadWindow("/Visao/Novo/NovoCliente.fxml");
        ((UsaCamadaControle)janela.getInternalController()).setControle(this.controle);
        janela.getInternalController().setMyStage(janela);
        ((NovoClienteController)janela.getInternalController()).cancelarButton.setDisable(true);
        janela.initStyle(StageStyle.UNDECORATED);
        janela.showAndWait();
/*
        if(this.controle.getGestaoCliente().obterTodosCliente().size() > 0){
            this.cliente = this.controle.getGestaoCliente().obterTodosCliente().get(this.controle.getGestaoCliente().obterTodosCliente().size() - 1);
            this.resultadoBusca.setText("Nome: " + this.cliente.getNome());
            this.debitosCliente.setText("Débito: " + this.cliente.getSaldo());
        }
*/
    }

    @FXML
    private void addItem(ActionEvent event){
/*
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
*/
    }

    @FXML
    private void finalizar(ActionEvent event){
/*
        if(this.controle == null){
            throw new NullPointerException("O controlador não foi setado.");
        }
        else {
            if (this.itensAdicionados.getItems().size() == 0 || this.cliente == null) {
                WindowLoader.showError("Venda sem itens.", "Adicione itens para prosseguir.", "");
            }
            else {

                if(this.cliente.getSaldo() > 0){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("O cliente possui débito");
                    alert.setHeaderText("O cliente deve pagar o débito.");
                    alert.setContentText("Ele tem dinheiro disponível?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        this.execFinalizar();
                    }
                    else {
                        this.limpar();
                        WindowLoader.showMessage("Cancelada", "A venda foi cancelada por falta de grana.");
                    }
                }
                else{
                    this.execFinalizar();
                }
                this.limpar();
            }
        }
*/
    }

    private void execFinalizar(){
/*
        try {
            Double desconto = Double.parseDouble(this.desconto.getText().replace(",", "."));
            Double valorPago = Double.parseDouble(this.valorPago.getText().replace(",", "."));
            this.controle.getGestaoVenda().novaVenda(this.itensAdicionados.getItems(), valorPago, desconto, this.cliente);
        } catch (NumberFormatException e) {
            WindowLoader.showError("Entrada Incorreta", "Desconto e Valor Pago devem ser números.", "");
        }
*/
    }

    @FXML
    private void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
/*
        this.itensAdicionados.getItems().clear();
        this.desconto.setText("");
        this.valorPago.setText("");
        this.cliente = null;
        this.resultadoBusca.setText("Nome: ");
        this.debitosCliente.setText("Débitos: ");
*/      
    }

    public void update(){
/*      
        this.itens.getItems().addAll(this.controle.getGestaoProduto().obterTodosProduto());
*/      
    }

    @FXML
    private void buscarCliente(ActionEvent event){
/*        
        if(this.cpfCliente.getText().length() > 0){
            this.cliente = this.controle.getGestaoCliente().buscarCliente(this.cpfCliente.getText());

            if(this.cliente == null){
                WindowLoader.showMessage("Não cadastrado", "O cliente não está cadastrado na nossa base de dados.\nCadastre-o.");
            }
            else {
                this.resultadoBusca.setText("Nome: " + this.cliente.getNome());
                this.debitosCliente.setText("Débitos: " + this.cliente.getSaldo());
            }
        }
*/        
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
