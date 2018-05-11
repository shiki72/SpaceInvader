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

    /**This is the {@code Bullet}'s constructor where it's properties will set.
     *
     * @param posX is the {@code Bullet}'s horizontal position.
     * @param posY is the {@code Bullet}'s vertical position.*/
    public Bullet(int posX, int posY) {
        bullet.setId("bullet");
        PosX = posX;
        PosY = posY;
        bullet.setLayoutX(PosX);
        bullet.setLayoutY(PosY);
        bullet.setPrefWidth(WIDTH);
        bullet.setPrefHeight(HEIGHT);
    }

    /**This method will add the {@code Bullet} to the {@param root} container.*/
    public void addTo(Pane root) {
        root.getChildren().add(this.bullet);
    }

    /**This methond will set the {@code Bullet}'s container's visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible(Status status) {
        if (status == Status.STAGE) {
            this.bullet.setVisible(true);
        } else {
            this.bullet.setVisible(false);
        }
    }

    /**This method will set the {@code Bullet}'s visibility.*/
    public void setVisible(boolean bool) {
        this.bullet.setVisible(bool);
    }

    /**This method will move the {@code Bullet} upwards.*/
    public void move() {
        PosY = getPosY() - 10;
        bullet.setLayoutY(PosY);
    }

    /**@return the {@code Bullet}'s container.*/
    public Pane getBullet() {
        return bullet;
    }

    /**@return the {@code Bullet}'s horizontal position.*/
    public int getPosX() {
        return PosX;
    }

    /**@return the {@code Bullet}'s vertical position.*/
    public int getPosY() {
        return PosY;
    }

    /**@return true if this bullet do hit one enemy.*/
    public boolean isHit() {
        return hit;
    }

    /**@param hit's value will be the {@code Bullet}'s hit status.
     * If it's true then this bullet won't be visible at the scene.*/
    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
