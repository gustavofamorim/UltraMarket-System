package Filial;

import Filial.Controle.Controle;
import Filial.Visao.UsaCamadaControle;
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
        ((UsaCamadaControle)this.controlador.getInternalControllers().get(0)).setControle(new Controle());
        this.controlador.show();

    }

}
