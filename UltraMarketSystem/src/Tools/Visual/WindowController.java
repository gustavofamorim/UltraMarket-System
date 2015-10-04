package Tools.Visual;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class WindowController extends Stage {

    Controller internalController;

    public WindowController(){
        super();
    }

    public Controller getInternalController() {
        return internalController;
    }

    public void setInternalController(Controller internalController) {
        this.internalController = internalController;
    }
}
