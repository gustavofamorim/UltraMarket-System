package Tools.Visual;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class WindowController extends Stage {

    ArrayList<Controller> internalControllers = new ArrayList<>();

    public WindowController(){
        super();
    }

    public ArrayList<Controller> getInternalControllers() {
        return internalControllers;
    }
}
