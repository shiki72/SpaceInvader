package stempel.richard.Model;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import stempel.richard.Status;

public class GameOver {
    private Text text = new Text();
    private TextField textField = new TextField();
    private Text score = new Text();
    private Text name = new Text();
    private Button exit = new Button();

    public GameOver(String str) {
        text.setText(str);
        text.setId("gameover");
        text.setLayoutX(100);
        text.setLayoutY(150);
        score.setId("scoretext");
        score.setLayoutX(100);
        score.setLayoutY(250);
        name.setId("name");
        name.setText("Name:");
        name.setLayoutX(100);
        name.setLayoutY(350);
        textField.setId("textfield");
        textField.setLayoutX(200);
        textField.setLayoutY(330);
        exit.setId("exitbtn");
        exit.setText("EXIT");
        exit.setLayoutX(200);
        exit.setLayoutY(400);
    }

    public void addTo(Pane root) {
        root.getChildren().addAll(this.text, this.score, this.name, this.exit, this.textField);
    }

    public void checkVisible(Status status) {
        if (status == Status.GAMEOVER) {
            this.exit.setVisible(true);
            this.name.setVisible(true);
            this.score.setVisible(true);
            this.text.setVisible(true);
            this.textField.setVisible(true);
        } else{
            this.exit.setVisible(false);
            this.name.setVisible(false);
            this.score.setVisible(false);
            this.text.setVisible(false);
            this.textField.setVisible(false);
        }
    }

    public Text getText() {
        return text;
    }

    public void setVisible(boolean bool) {
        text.setVisible(bool);
        score.setVisible(bool);
        textField.setVisible(bool);
        name.setVisible(bool);
        exit.setVisible(bool);
    }

    public Text getScore() {
        return score;
    }

    public void setScore(Text score) {
        this.score = score;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Text getName() {
        return name;
    }

    public void setName(Text name) {
        this.name = name;
    }

    public Button getExit() {
        return exit;
    }

    public void setExit(Button exit) {
        this.exit = exit;
    }
}
