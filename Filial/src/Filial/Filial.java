package Filial;

import Filial.Controle.Controle;
import Tools.Visual.UsaCamadaControle;
import Tools.Visual.WindowController;
import Tools.Visual.WindowLoader;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Filial {

    Filial filial = null;
    FilialRemote remoteImpl = null;
    WindowController controlador = null;

    public void start(){

        this.controlador = WindowLoader.loadWindow("/Filial/Visao/FilialMainWindow.fxml");
        ((UsaCamadaControle)this.controlador.getInternalController()).setControle(new Controle());
        this.controlador.show();

    }

}
