package stempel.richard.Model;

import javafx.scene.layout.Pane;
import stempel.richard.Status;

public class Player {
    private Pane player = new Pane();
    private int PosX;
    private int PosY;

    private static final int HEIGHT = 50;
    private static final int WIDTH = 50;

    public Player (int PosX, int PosY) {
        player.setId("player");
        this.PosX = PosX;
        this.PosY = PosY;
        player.setLayoutX(getPosX());
        player.setLayoutY(getPosY());
        player.setPrefWidth(WIDTH);
        player.setPrefHeight(HEIGHT);
    }

    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.player.setVisible(true);
        } else {
            this.player.setVisible(false);
        }
    }

    public void addTo(Pane root) {
        root.getChildren().addAll(this.player);
    }

    public void setVisible(boolean bool){
        player.setVisible(bool);
    }

    public void goRight() {
        setPosX(Math.min(getPosX()+5,420));
        player.setLayoutX(PosX);
    }

    public void goLeft() {
        setPosX(Math.max(getPosX()-5,20));
        player.setLayoutX(PosX);
    }

    public Pane getPlayer() {
        return player;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }
}
