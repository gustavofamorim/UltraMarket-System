package Filial.Visao;

import Tools.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMainWindowController extends Controller implements Initializable, AcceptMessage<String> {

    @FXML
    private MenuLateralController menuLateralController;

    @FXML
    private AnchorPane painel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.menuLateralController.setMyParent(this);
    }

    @Override
    public void receiveMessage(Message<String> message) {
        Controller controlador = null;

        switch (message.getMensage()){
            case "novo_venda":
                controlador = PaneLoader.load("/Filial/Visao/Novo/NovaVenda.fxml");
                break;
            case "novo_produto":
                controlador = PaneLoader.load("/Filial/Visao/Novo/NovoProduto.fxml");
                break;
            case "novo_cliente":
                controlador = PaneLoader.load("/Filial/Visao/Novo/NovoCliente.fxml");
                break;
        }
        if(controlador != null) {
            this.painel.getChildren().clear();
            this.painel.getChildren().add(controlador.getMyPane());
        }
        else{
            WindowLoader.showError("Erro ao carregar painel", "Erro ao carregar painel", "Desconhecido.");
        }
    }
}
