package stempel.richard.Model;

import javafx.scene.layout.Pane;
import stempel.richard.Status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    private int level;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public Level(int level) throws IOException {
        this.level = level;
        String pathname = "src/main/resources/stage" + this.level;
        Scanner scanner = new Scanner(new File(pathname));
        ArrayList<Integer> stageinput = new ArrayList<Integer>();
        int o;
        while(scanner.hasNextInt()){
            o = scanner.nextInt();
            stageinput.add(o);
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                this.enemies.add(new Enemy(30 + (col * 50),50 + (row * 50), stageinput.get(row*7+col)));
            }
        }
    }

    public void checkVisible(Status status) {
        for (int i = 0; i < this.enemies.size(); i++) {
            if (status == Status.STAGE) {
                this.enemies.get(i).setVisible(true);
            } else {
                this.enemies.get(i).setVisible(false);
            }
        }
    }

    public void addTo(Pane root) {
        for (int i = 0; i < this.enemies.size(); i++) {
            root.getChildren().add(this.enemies.get(i).getEnemy());
        }
    }

    /*public void reload (int level, ArrayList<Enemy> enemies) throws FileNotFoundException {
        this.level = level;
        String pathname = "C:\\Users\\Stempel Richárd\\Downloads\\Test\\src\\main\\resources\\stage" + level;
        Scanner scanner = new Scanner(new File(pathname));
        ArrayList<Integer> stageinput = new ArrayList<Integer>();
        int o ;
        while(scanner.hasNextInt()){
            o = scanner.nextInt();
            stageinput.add(o);
        }

        //enemies.clear();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                enemies.add(new Enemy(30 + (col * 50),50 + (row * 50), stageinput.get(row*7+col)));
            }
        }
    }*/

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
