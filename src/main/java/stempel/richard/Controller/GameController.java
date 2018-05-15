package stempel.richard.Controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import org.pmw.tinylog.Logger;
import stempel.richard.Model.*;
import stempel.richard.Model.Database.Entity.Board;
import stempel.richard.Service.BoardService;
import stempel.richard.Status;
import stempel.richard.Model.GameOver;
import stempel.richard.View.CssLoader;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GameController implements Serializable {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;

    private Scene scene;

    private Pane root;
    private Status status = Status.MENU;
    private Integer startTime;
    private Integer time;

    private Menu menu;
    private Player player;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private Level level;
    private Score score;
    private Paused paused;
    private GameOver gameOver;

    private boolean left = false;
    private boolean right = false;

    private BoardService boardService;

    /**
     * This is the main controller method where all the keyboard and mouse input will be handled.
     *
     * @throws IOException if exception occurred.*/

    public GameController() throws IOException {
        this.root = new Pane();
        this.root.setPrefSize(WIDTH, HEIGHT);
        this.root.setId("root");
        this.scene = new Scene(this.root, WIDTH, HEIGHT);


        Logger.info("Program started.");

        //
        // Inicializalas
        //

        this.menu = new Menu(175,300,175,400);
        this.player = new Player(225, 500);
        this.level = new Level(4);
        this.score = new Score("Score");
        this.paused = new Paused("PAUSED");
        this.gameOver = new GameOver("GAME OVER");

        //
        // Gyokerhez adas
        //

        this.menu.addTo(root);
        this.player.addTo(root);
        this.level.addTo(root);
        this.score.addTo(root);
        this.paused.addTo(root);
        this.gameOver.addTo(root);

        boardService = new BoardService();

        //
        //  Mozgatasok kezelese
        //

        /**
         * This {@code EventHandler} will handle the left and right key buttons if the are pressed.
         * */

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    left = true;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right = true;
                }
            }
        });

        /**
         * This {@code EventHandler} will handle the left and right key buttons if the are released.
         * */

        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.LEFT) {
                    left = false;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    right = false;
                }
            }
        });

        /**Handle the start button pressed at the menu screen.*/
        this.menu.getStart().setOnMouseClicked(event -> {
            Logger.info("Game started.");
            this.status = Status.STAGE;
            this.startTime = getTime();
            this.time = getTime() - startTime;
            score.getText().setText("Time: " + time.toString());
            checkVisible();
        });

        /**Handle the exit button pressed at the menu screen.*/
        this.menu.getExit().setOnMouseClicked(event -> {
            Logger.info("Exiting the program.");
            System.exit(0);
        });

        /**Handle the exit button pressed at the game over screen.*/
        this.gameOver.getExit().setOnMouseClicked(event -> {
            String tmp = gameOver.getTextField().getText();
            System.out.println(tmp);
            Board board = new Board(1,tmp,time);
            boardService.persist(board);
            System.exit(0);
        });

        /**Handle other key inputs.*/
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.CONTROL) {
                    Bullet shot = new Bullet(player.getPosX(),player.getPosY()-50);
                    bullets.add(shot);
                    shot.addTo(root);
                }
                if (event.getCode() == KeyCode.P) {
                    if (getStatus() == Status.PAUSED) {
                        Logger.info("Game resumed.");
                        startTime = getTime() - time;
                        setStatus(Status.STAGE);
                    } else if (getStatus() == Status.STAGE) {
                        Logger.info("Game paused.");
                        setStatus(Status.PAUSED);
                    }
                    checkVisible();
                }
                if (event.getCode() == KeyCode.ESCAPE) {
                    Logger.info("Exiting from the game.");
                    System.exit(0);
                }
            }
        });



        //
        //  CSS behuzasa
        //


        /**Loading the css file.*/
        new CssLoader(scene);



        //
        // Animation Timer
        //

        new AnimationTimer() {

            /**
             * Handle the {@code Enemy} and the {@code Bullet} movement, counting playing time
             * and redirrect us to the game over screen if the ship die or all the enemies ar dead.*/
            @Override
            public void handle(long currentNanoTime) {
                Animation animation = new Animation();
                if (getStatus() == Status.STAGE) {
                    time = getTime() - startTime;
                    score.getText().setText("Time: " + time.toString());

                    if (animation.hitplayer(level.getEnemies(), player)) {
                        Logger.info("Game is over.");
                        setStatus(Status.GAMEOVER);
                        checkVisible();
                    }

                    animation.gamaLoop(player, left, right);
                    ArrayList<Integer> tmp = animation.hitenemy(level.getEnemies(), bullets);
                    if (!tmp.isEmpty()) {
                        if (level.getEnemies().get(tmp.get(0)).getLife() == 0) {
                            level.getEnemies().get(tmp.get(0)).setVisible(false);
                            level.getEnemies().remove(tmp.get(0));
                        } else {
                            //System.out.println(level.getEnemies().get(tmp.get(0)).getEnemy().getId() + "_" + level.getEnemies().get(tmp.get(0)).getLife());
                            level.getEnemies().get(tmp.get(0)).getEnemy().setId(level.getEnemies().get(tmp.get(0)).getEnemy().getId() + "_" + level.getEnemies().get(tmp.get(0)).getLife());
                        }
                        if (bullets.get(tmp.get(1)).isHit()) {
                            bullets.get(tmp.get(1)).setVisible(false);
                            bullets.remove(tmp.get(1));
                        }
                    }
                    for (int i = 0; i < bullets.size(); i++) {
                        if (bullets.get(i).getPosY() < -50) {
                            bullets.get(i).setVisible(false);
                            bullets.remove(i);
                        }
                    }
                    for (int i = 0; i < level.getEnemies().size(); i++) {
                        if (level.getEnemies().get(i).getEnemy().isVisible()) level.getEnemies().get(i).move();
                    }
                    for (int i = 0; i < bullets.size(); i++) {
                        if (bullets.get(i).getBullet().isVisible()) bullets.get(i).move();
                    }
                    //System.out.println(bullet.size());

                    if (animation.isNotVisible(level.getEnemies())) {
                        Logger.info("Game is over.");
                        setStatus(Status.GAMEOVER);
                        gameOver.getScore().setText("Time: " + time.toString());
                        checkVisible();
                    }
                }
            }
        }.start();
    }

    /**
     * This method is checking which screen should be visible.*/

    public void checkVisible() {
        this.menu.checkVisible(this.status);
        this.player.checkVisible(this.status);
        this.level.checkVisible(this.status);
        this.score.checkVisible(this.status);
        for (int i = 0; i < this.bullets.size(); i++) {
            this.bullets.get(i).checkVisible(this.status);
        }
        this.paused.checkVisible(this.status);
        this.gameOver.checkVisible(this.status);
    }

    /**
     * @return the current time in seconds.
     * */

    private Integer getTime () {
        return LocalDateTime.now().getHour()*3600 + LocalDateTime.now().getMinute() * 60 + LocalDateTime.now().getSecond();
    }

    /**@return the game scene.*/
    public Scene getScene() {
        return scene;
    }

    /**This method is set the {@code Status} of the scene.
     *
     * @param status is going to have a new state.*/
    public void setStatus(Status status) {
        this.status = status;
    }

    /**This method asks the current scene {@code Status}.
     *
     * @return the scene's {@code Status} value.*/
    public Status getStatus() {
        return status;
    }
}
