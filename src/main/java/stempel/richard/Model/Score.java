package stempel.richard.Model;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stempel.richard.Status;

public class Score {
    Text text = new Text();

    /**This is the {@code Score}'s constructor.
     *
     * @param string is the text which will be wrote to the screen.*/
    public Score(String string) {
        text.setText(string);
        text.setLayoutX(20);
        text.setLayoutY(30);
        text.setId("score");
    }

    /**this method will add the text to a container.
     *
     * @param root will be the container.*/
    public void addTo(Pane root) {
        root.getChildren().add(this.text);
    }

    /**This method will set the {@code Score} visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.text.setVisible(true);
        } else {
            this.text.setVisible(false);
        }
    }

    /**@param bool decides if the {@code Score} will be visible or not.*/
    public void setVisible (boolean bool) {
        text.setVisible(bool);
    }

    /**@return the {@code Score}'s text.*/
    public Text getText() {
        return text;
    }

    /**@param text will be set to the {@code Score}'s text.*/
    public void setText(String text) {
        this.text.setText(text);
    }
}
