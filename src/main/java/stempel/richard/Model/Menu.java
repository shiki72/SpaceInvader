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

    /**This is the constructor of the menu scene with 2 {@code Button}s.*/
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

    /**This method will add the {@code Button}s to the root element.
     *
     * @param root is the main {@code Pane} container.*/
    public void addTo (Pane root) {
        root.getChildren().addAll(this.start, this.exit);
    }

    /**This method will set the {@code menu}'s visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible (Status status) {
        if (status == Status.MENU) {
            this.start.setVisible(true);
            this.exit.setVisible(true);
        } else {
            this.start.setVisible(false);
            this.exit.setVisible(false);
        }
    }

    /**@param bool is true or false and the menu's visibility will set depends on it's value.*/
    public void setVisible(boolean bool) {
        start.setVisible(bool);
        exit.setVisible(bool);
    }

    /**@return the start button.*/
    public Button getStart() {
        return start;
    }

    /**@param start will be set to the menu's start {@code Button}.*/
    public void setStart(Button start) {
        this.start = start;
    }

    /**@return the exit button.*/
    public Button getExit() {
        return exit;
    }

    /**@param exit will be set to the menu's exit {@code Button}.*/
    public void setExit(Button exit) {
        this.exit = exit;
    }

    /**@return the start {@code Button}'s horizontal position.*/
    public int getStart_posX() {
        return start_posX;
    }

    /**@param start_posX will be set to the start {@code Button}'s horizontal position.*/
    public void setStart_posX(int start_posX) {
        this.start_posX = start_posX;
    }

    /**@return the start {@code Button}'s vertical position.*/
    public int getStart_posY() {
        return start_posY;
    }

    /**@param start_posY will be set to the start {@code Button}'s vertical position.*/
    public void setStart_posY(int start_posY) {
        this.start_posY = start_posY;
    }

    /**@return the exit {@code Button}'s horizontal position.*/
    public int getExit_posX() {
        return exit_posX;
    }

    /**@param exit_posX will be set to the exit {@code Button}'s horizontal position.*/
    public void setExit_posX(int exit_posX) {
        this.exit_posX = exit_posX;
    }

    /**@return the exit {@code Button}'s vertical position.*/
    public int getExit_posY() {
        return exit_posY;
    }

    /**@param exit_posY will be set to the exit {@code Button}'s vertical position.*/
    public void setExit_posY(int exit_posY) {
        this.exit_posY = exit_posY;
    }
}
