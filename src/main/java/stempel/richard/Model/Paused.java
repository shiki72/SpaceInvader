package stempel.richard.Model;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stempel.richard.Status;

public class Paused {
    private Text text = new Text();

    /**This is the constructor of the paused scene.
     *
     * @param str is the text on the paused scene.*/
    public Paused(String str) {
        text.setText(str);
        text.setId("text");
        text.setLayoutX(150);
        text.setLayoutY(100);
    }

    /**This method will add the {@code Text} element to the root.
     *
     * @param root is the root element.*/
    public void addTo(Pane root) {
        root.getChildren().add(this.text);
    }

    /**This method will set the {@code Paused} scene's visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible(Status status) {
        if (status == Status.PAUSED) {
            this.text.setVisible(true);
        } else {
            this.text.setVisible(false);
        }
    }

    /**@return the pop up text.*/
    public Text getText() {
        return text;
    }

    /**@param bool is decides if the {@code Paused} scene will be visible or not.*/
    public void setVisible(boolean bool) {
        text.setVisible(bool);
    }
}
