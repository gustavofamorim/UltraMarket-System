package Tools.Visual;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOException;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class PaneLoader {

    public static Controller load(String source) {

        Region painel = null;
        Controller controlador = null;
        FXMLLoader loader = new FXMLLoader(java.net.URL.class.getClass().getResource(source));

        try {

            painel = loader.load();
            controlador = loader.getController();
            controlador.setMyPane(painel);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return (controlador);
    }

}
