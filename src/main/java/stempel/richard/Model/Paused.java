package stempel.richard.Model;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stempel.richard.Status;

public class Paused {
    private Text text = new Text();

    public Paused(String str) {
        text.setText(str);
        text.setId("text");
        text.setLayoutX(150);
        text.setLayoutY(100);
    }

    public void addTo(Pane root) {
        root.getChildren().add(this.text);
    }

    public void checkVisible(Status status) {
        if (status == Status.PAUSED) {
            this.text.setVisible(true);
        } else {
            this.text.setVisible(false);
        }
    }

    public Text getText() {
        return text;
    }

    public void setVisible(boolean bool) {
        text.setVisible(bool);
    }
}
