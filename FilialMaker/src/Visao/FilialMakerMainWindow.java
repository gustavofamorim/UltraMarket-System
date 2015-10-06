package Visao;

import Tools.Visual.Controller;
import Tools.Visual.WindowLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMakerMainWindow extends Controller implements Initializable {

    @FXML
    private TextField local;

    @FXML
    private TextField nome;

    @FXML
    private TextField porta;

    @FXML
    public void selecionarExecutavel(ActionEvent event){
        String src = WindowLoader.obterArquivo(null, System.getProperty("user.dir"));

        if(src != null){
            this.local.setText(src);
            this.local.setDisable(false);
        }

    }

    @FXML
    public void criar(ActionEvent event){

        Integer porta = null;

        try {
            porta = Integer.parseInt(this.porta.getText());
        }
        catch (NumberFormatException e){
            WindowLoader.showError("Dados Inválidos", "A porta é inválida.");
            porta = null;
        }

        if(this.nome.getText().length() > 0 && porta != null && this.local.getText().length() > 0){
            //Inicia a filial
            try {
                Process processo = Runtime.getRuntime().exec("java -jar " + this.local.getText() + " " + nome.getText() + " localhost " + "1099");
                BufferedReader processOutput = new BufferedReader(new InputStreamReader(processo.getInputStream()));

                Thread printResult = new Thread(() -> {
                    String nome = "Filial - " + this.nome.getText() + ": ";
                    while(true){
                        try {
                            String out = processOutput.readLine();
                            if(out != null){
                                System.out.println(nome + out);
                            }
                            else{
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
                printResult.start();

                System.out.println(this.local.getText());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            this.limpar();
        }
        else{
            WindowLoader.showError("Dados Inválidos", "Preencha todos os campos corretamente.");
        }
    }

    @FXML
    public void cancelar(ActionEvent event){
        this.limpar();
    }

    public void limpar(){
        this.porta.setText("");
        this.nome.setText("");
        //this.local.setText("");
        //this.local.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.local.setDisable(true);
    }
}
