/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filial.Visao;

import java.net.URL;
import java.util.ResourceBundle;

import Tools.Controller;
import Tools.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Gustavo Freitas
 */
public class MenuLateralController extends Controller implements Initializable{
    
    private Button ultimoClicado = null;
    
    @FXML
    private void opcaoPainel(ActionEvent evento){
        
        if(this.ultimoClicado != null){
            this.ultimoClicado.setStyle(null);
        }
        
        this.ultimoClicado = ((Button)evento.getSource());
        this.ultimoClicado.setStyle("-fx-background-color: #43A047");

        Message<String> mensagem = new Message<>();
        mensagem.setMessage(((Button) evento.getSource()).getId());
        ((FilialMainWindowController)this.getMyParent()).receiveMessage(mensagem);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
