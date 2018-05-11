package stempel.richard.View;

import javafx.scene.Scene;

public class CssLoader {
    public CssLoader(Scene scene) {
        scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
    }
}
