package Matriz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Emerson C. Romaneli on 26/09.
 */
public abstract class FXMLApplication extends Application {
    protected static final int STAGE_SHOW = 0;
    protected static final int STAGE_SHOW_AND_WHAIT = 1;
    private FXMLLoader loader;
    private URL fileUrl;
    private Stage stage;
    private Scene scene;
    private Region region;

    @Override
    public void start(final Stage stage) {
        this.stage = stage;
    }

    protected void start(Scene scene, String title, int mode) {
        getStage().setScene(scene);
        getStage().setTitle(title);
        if (mode == STAGE_SHOW) {
            getStage().show();
        } else {
            getStage().showAndWait();
        }
    }

    private void initLoader(){
        try {
            if (fileUrl == null) {
                throw new NullPointerException("FXML file not associated!");
            }
            loader = new FXMLLoader();
            loader.setLocation(fileUrl);
        } catch (NullPointerException e) {
            System.out.println("initLoader error:");
            e.printStackTrace();
        }
    }

    protected void associateFile(String fxml) {
        associateFile(getClass().getResource(fxml));
    }

    protected void associateFile(URL fileUrl) {
        loader = null;
        scene = null;
        region = null;
        this.fileUrl = fileUrl;
    }

    @SuppressWarnings("unchecked")
    protected <T>T getRegion() {
        try {
            if (region == null) {
                if (loader == null) {
                    initLoader();
                }
                region = loader.load();
            }
            return (T)region;
        } catch (IOException e) {
            System.out.println("getRegion error:");
            e.printStackTrace();
            return null;
        }
    }

    protected Scene getScene() {
        if (scene == null) {
            scene = new Scene(getRegion());
        }
        return scene;
    }

    @SuppressWarnings("unchecked")
    protected <T> T getController() {
        try {
            if (loader == null) {
                initLoader();
            }
            if (region == null) {
                getRegion();
            }
            return (T) loader.getController();
        } catch (NullPointerException e) {
            System.out.println("getController() Error:");
            e.printStackTrace();
            return null;
        }
    }

    protected Stage getStage() {
        if(stage == null) {
            stage = new Stage();
        }
        return stage;
    }

    protected void setStage(Stage stage) {
        this.stage = stage;
    }
}
