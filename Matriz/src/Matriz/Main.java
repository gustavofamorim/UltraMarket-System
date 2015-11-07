package Matriz;

import DAO.ClienteDAO;
import DAO.Gerenciador.GerenciadorBD;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Modelo.Cliente;
import Modelo.Produto;
import Modelo.Venda.ItemVenda;
import Modelo.Venda.VendaBuilder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends FXMLApplication {

    @Override
    public void start(Stage primaryStage) {
        associateFile("../Visao/Matriz.fxml");
        start(getScene(), "Servidor Matriz", FXMLApplication.STAGE_SHOW);

        getStage().setOnCloseRequest(event -> {
            Platform.exit();
        });
    }

    @Override
    public void stop(){
        System.out.println("Matriz finalizada.");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
