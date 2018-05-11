package stempel.richard;


import javafx.application.Application;
import javafx.stage.Stage;
import stempel.richard.Controller.GameController;

public class Main extends Application {

    /**
     * Launch the application
     *
     * @param primaryStage is the game window
     * @throws Exception if exveption occured*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Test");

        GameController game = new GameController();

        game.checkVisible();

        primaryStage.setScene(game.getScene());
        primaryStage.show();
    }

    /**
     * Main method of the SpaceIvader application
     *
     * @param args is not used*/
    public static void main(String[] args) {
        launch(args);
    }
}
