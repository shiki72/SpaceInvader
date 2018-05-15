package stempel.richard.Model;

import javafx.scene.layout.Pane;
import stempel.richard.Status;

public class Player {
    private Pane player = new Pane();
    private int PosX;
    private int PosY;

    private static final int HEIGHT = 50;
    private static final int WIDTH = 50;

    /**This is the constructor of the player ship.
     *
     * @param PosX is the horizontal position.
     * @param PosY is the vertical position.*/
    public Player (int PosX, int PosY) {
        player.setId("player");
        this.PosX = PosX;
        this.PosY = PosY;
        player.setLayoutX(getPosX());
        player.setLayoutY(getPosY());
        player.setPrefWidth(WIDTH);
        player.setPrefHeight(HEIGHT);
    }

    /**This method will set the {@code Player} visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.player.setVisible(true);
        } else {
            this.player.setVisible(false);
        }
    }

    /**This method will add the {@code Player} to the root.
     *
     * @param root is the root {@code Pane}.*/
    public void addTo(Pane root) {
        root.getChildren().addAll(this.player);
    }

    /**@param bool decides if the {@code Player}'s ship will be visible or not.*/
    public void setVisible(boolean bool){
        player.setVisible(bool);
    }

    /**This method will move the ship right.*/
    public void goRight() {
        setPosX(Math.min(getPosX()+5,420));
        player.setLayoutX(PosX);
    }

    /**This method will move the ship left.*/
    public void goLeft() {
        setPosX(Math.max(getPosX()-5,20));
        player.setLayoutX(PosX);
    }

    /**@return the {@code Player}'s container {@code Pane}.*/
    public Pane getPlayer() {
        return player;
    }

    /**@return the {@code Player}'s horizontal position.*/
    public int getPosX() {
        return PosX;
    }

    /**@param posX will be set to the {@code Player}'s horizontal position.*/
    public void setPosX(int posX) {
        PosX = posX;
    }

    /**@return the {@code Player}'s vertical position.*/
    public int getPosY() {
        return PosY;
    }

    /**@param posY will be set to the {@code Player}'s vertical position.*/
    public void setPosY(int posY) {
        PosY = posY;
    }
}
