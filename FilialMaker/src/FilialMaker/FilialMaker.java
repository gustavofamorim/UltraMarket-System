package FilialMaker;

import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class FilialMaker {

    public void start(){
        WindowController janela = WindowLoader.loadWindow("/FilialMaker/Visao/FilialMakerMainWindow.fxml");
        janela.show();
    }

}
