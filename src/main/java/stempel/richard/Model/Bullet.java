package stempel.richard.Model;

import javafx.scene.layout.Pane;
import stempel.richard.Status;

public class Bullet {
    private Pane bullet = new Pane();
    private int PosX;
    private int PosY;
    private boolean hit = false;

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public Bullet(int posX, int posY) {
        bullet.setId("bullet");
        PosX = posX;
        PosY = posY;
        bullet.setLayoutX(PosX);
        bullet.setLayoutY(PosY);
        bullet.setPrefWidth(WIDTH);
        bullet.setPrefHeight(HEIGHT);
    }

    public void addTo(Pane root) {
        root.getChildren().add(this.bullet);
    }

    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.bullet.setVisible(true);
        } else {
            this.bullet.setVisible(false);
        }
    }

    public void move() {
        PosY = getPosY() - 10;
        bullet.setLayoutY(PosY);
    }

    public void setVisible(boolean bool) {
        bullet.setVisible(bool);
    }

    public Pane getBullet() {
        return bullet;
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

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
