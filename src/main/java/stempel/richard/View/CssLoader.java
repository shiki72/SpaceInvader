package stempel.richard.View;

import javafx.scene.Scene;

public class CssLoader {
    /**This method will load the css to a scene.
     *
     * @param scene is the scene which th css file will be added to.*/
    public CssLoader(Scene scene) {
        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
    }
}
