package stempel.richard.Model;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import stempel.richard.Status;

import java.time.LocalDateTime;

public class Menu {
    private Button start = new Button();
    private Button exit = new Button();
    private int start_posX;
    private int start_posY;
    private int exit_posX;
    private int exit_posY;

    public Menu(int start_posX, int start_posY, int exit_posX, int exit_posY) {
        this.start_posX = start_posX;
        this.start_posY = start_posY;
        this.exit_posX = exit_posX;
        this.exit_posY = exit_posY;
        start.setLayoutX(start_posX);
        start.setLayoutY(start_posY);
        start.setPrefSize(150,75);
        exit.setLayoutX(exit_posX);
        exit.setLayoutY(exit_posY);
        exit.setPrefSize(150,75);
        start.setText("Start");
        start.setId("start");
        exit.setText("Exit");
        exit.setId("exit");
    }

    public void addTo (Pane root) {
        root.getChildren().addAll(this.start, this.exit);
    }

    public void checkVisible (Status status) {
        if (status == Status.MENU) {
            this.start.setVisible(true);
            this.exit.setVisible(true);
        } else {
            this.start.setVisible(false);
            this.exit.setVisible(false);
        }
    }

    public void setVisible(boolean bool) {
        start.setVisible(bool);
        exit.setVisible(bool);
    }

    public Button getStart() {
        return start;
    }

    public void setStart(Button start) {
        this.start = start;
    }

    public Button getExit() {
        return exit;
    }

    public void setExit(Button exit) {
        this.exit = exit;
    }

    public int getStart_posX() {
        return start_posX;
    }

    public void setStart_posX(int start_posX) {
        this.start_posX = start_posX;
    }

    public int getStart_posY() {
        return start_posY;
    }

    public void setStart_posY(int start_posY) {
        this.start_posY = start_posY;
    }

    public int getExit_posX() {
        return exit_posX;
    }

    public void setExit_posX(int exit_posX) {
        this.exit_posX = exit_posX;
    }

    public int getExit_posY() {
        return exit_posY;
    }

    public void setExit_posY(int exit_posY) {
        this.exit_posY = exit_posY;
    }
}
