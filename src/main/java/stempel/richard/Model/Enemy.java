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

    public Enemy(int posX, int posY, int tmp) {
        //enemy.setStyle("-fx-background-image: url(\"enemy.png\");");
        /*enemy.setStyle("-fx-background-image: url(\"enemy.png\");\n" +
                "    -fx-rotate: 180;\n" +
                "    -fx-background-repeat: stretch;\n" +
                "    -fx-background-size: 50 50;");*/
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

    private int direction = 1;

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

    public void setVisible(boolean bool) {
        enemy.setVisible(bool);
    }

    public Pane getEnemy() {
        return enemy;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
