package stempel.richard.Model;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stempel.richard.Status;

public class Score {
    Text text = new Text();

    public Score(String string) {
        text.setText(string);
        text.setLayoutX(20);
        text.setLayoutY(30);
        text.setId("score");
    }

    public void addTo(Pane root) {
        root.getChildren().add(this.text);
    }

    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.text.setVisible(true);
        } else {
            this.text.setVisible(false);
        }
    }

    public void setVisible (boolean bool) {
        text.setVisible(bool);
    }

    public Text getText() {
        return text;
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
