package stempel.richard.Model;

import javafx.scene.layout.Pane;
import stempel.richard.Status;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    private int level;
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    /**This is the level constructor.
     *
     * @param level is the number that sets which level will be load.
     *
     * @throws IOException if exception occurred.*/
    public Level(int level) throws IOException {
        this.level = level;
        //String pathname = this.getClass().getClassLoader().getResources("stage" + this.level).toString();//"${project.basedir}/src/main/resources/stage" + this.level;
        //Scanner scanner = new Scanner(new File(String.valueOf(this.getClass().getResource("src/resources/stempel/richard/Model/stage3").toExternalForm())));
        ArrayList<Integer> stageinput = new ArrayList<Integer>();
        for (int i = 0; i < 5*7; i++) {
            stageinput.add(i%2+1);
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                this.enemies.add(new Enemy(30 + (col * 50),50 + (row * 50), stageinput.get(row*7+col)));
            }
        }
    }

    /**This method will set the {@code Level}'s visibility.
     *
     * @param status is the current scene {@code Status}.*/
    public void checkVisible(Status status) {
        for (int i = 0; i < this.enemies.size(); i++) {
            if (status == Status.STAGE) {
                this.enemies.get(i).setVisible(true);
            } else {
                this.enemies.get(i).setVisible(false);
            }
        }
    }

    /**This method will add every {@code Enemy} at this level to the root as it's children.
     *
     * @param root is the container.*/
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

    /**@return the list of the {@code Enemy}s at this level.*/
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
