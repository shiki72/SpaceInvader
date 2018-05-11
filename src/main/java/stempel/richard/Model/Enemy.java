package stempel.richard.Model;

import javafx.scene.layout.Pane;

public class Enemy {
    private Pane enemy = new Pane();
    private int PosX;
    private int PosY;
    private int startPosX;
    private int startPosY;
    private int life;

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int MOVEX = 1;
    private static final int MOVEY = 10;

    /**This is the {@code Enemy}'s constructor where it's properties will set.
     *
     * @param posX is the {@code Enemy}'s horizontal position.
     * @param posY is the {@code Enemy}'s vertical position.
     * @param tmp will be set to the life point.*/
    public Enemy(int posX, int posY, int tmp) {
        PosX = posX;
        startPosX = PosX;
        startPosY = PosY;
        PosY = posY;
        enemy.setPrefWidth(WIDTH);
        enemy.setPrefHeight(HEIGHT);
        enemy.setLayoutX(PosX);
        enemy.setLayoutY(PosY);
        life = tmp;
        if (life == 1) {
            enemy.setId("mob1");
        } else if (life == 2) {
            enemy.setId("mob2");
        }
    }

    /**This method will set the {@code Enemy}'s visibility.*/
    public void setVisible(boolean bool) {
        this.enemy.setVisible(bool);
    }

    private int direction = 1;

    /**This method is doing the {@code Enemy}'s moving at the scene.*/
    public void move() {
        if (getPosX() - startPosX == 0) {
            setPosY(getPosY() + MOVEY);
            direction = 1;
        } else if (getPosX() - startPosX == 100) {
            setPosY(getPosY() + MOVEY);
            direction = -1;
        }
        setPosX(getPosX() + (direction * MOVEX));
        enemy.setLayoutX(PosX);
        enemy.setLayoutY(PosY);
    }

    /**@return the {@code Enemy}'s container.*/
    public Pane getEnemy() {
        return enemy;
    }

    /**@return the {@code Enemy}'s horizontal position.*/
    public int getPosX() {
        return PosX;
    }

    /**This method will set the {@code Enemy}'s horizontal position.
     *
     * @param posX is the horizontal position.*/
    public void setPosX(int posX) {
        PosX = posX;
    }

    /**@return the {@code Enemy}'s vertical position.*/
    public int getPosY() {
        return PosY;
    }

    /**This method will set the {@code Enemy}'s vertical position.
     *
     * @param posY is the vertical position.*/
    public void setPosY(int posY) {
        PosY = posY;
    }

    /**@return the {@code Enemy}'s current life points.*/
    public int getLife() {
        return life;
    }

    /**@param life will be set to the {@code Enenmy}'s life point.*/
    public void setLife(int life) {
        this.life = life;
    }
}
