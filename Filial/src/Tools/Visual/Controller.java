package Tools.Visual;

import javafx.fxml.Initializable;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public abstract class Controller implements Initializable{

    protected Stage myStage;
    protected Region myPane;
    protected Controller myParent;

    public Region getMyPane() {
        return myPane;
    }

    public void setMyPane(Region myPane) {
        this.myPane = myPane;
    }

    public Controller getMyParent() {
        return myParent;
    }

    public void setMyParent(Controller myParent) {
        this.myParent = myParent;
    }

    public Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }
}
