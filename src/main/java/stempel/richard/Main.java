package stempel.richard;


import javafx.application.Application;
import javafx.stage.Stage;
import stempel.richard.Controller.GameController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Test");

        GameController game = new GameController();

        game.checkVisible();

        primaryStage.setScene(game.getScene());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
