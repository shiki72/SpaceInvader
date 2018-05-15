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

    /**This is the contructor where the game over scene's propetries will set.
     *
     * @param str is a {@code String} which will be set to the main text's text.*/
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

    /**This is the method where all element of the {@code GameOver} class will add to the root
     * element as it's children.
     *
     * @param root it the {@code Pane} where the elements will add to;*/
    public void addTo(Pane root) {
        root.getChildren().addAll(this.text, this.score, this.name, this.exit, this.textField);
    }

    /**This method will set the visibility of the elements depends on the current scene.
     *
     * @param status is the variable which says that which game scene ar we at.*/
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

    /**@return the main text of the {@code GameOver} class.*/
    public Text getText() {
        return text;
    }

    /**valami*/
    public void setVisible(boolean bool) {
        text.setVisible(bool);
        score.setVisible(bool);
        textField.setVisible(bool);
        name.setVisible(bool);
        exit.setVisible(bool);
    }

    /**@return the score at the end of the game.*/
    public Text getScore() {
        return score;
    }

    /**@param score is the input score which will be set to the class's score variable.*/
    public void setScore(Text score) {
        this.score = score;
    }

    /**@return the text field where the player will wrote her/his name.*/
    public TextField getTextField() {
        return textField;
    }

    /**@param textField will set to the {@code GameOver} class's text field.*/
    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    /**@return the name text.*/
    public Text getName() {
        return name;
    }

    /**@param name will set to the {@code GameOver} class's name text.*/
    public void setName(Text name) {
        this.name = name;
    }

    /**@return the {@code GameOver} class's exit {@code Button}.*/
    public Button getExit() {
        return exit;
    }

    /**@param exit will be set to the {@code GameOver} class's exit {@code Button}*/
    public void setExit(Button exit) {
        this.exit = exit;
    }
}
