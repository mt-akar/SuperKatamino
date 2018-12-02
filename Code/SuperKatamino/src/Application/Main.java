package Application;

import Scenes.GameScene;
import Scenes.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage mainStage;

    GameScene savedGameScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        primaryStage.setTitle("Super Katamino");



        MainScene mainScene = new MainScene();
        primaryStage.setScene(mainScene);
        primaryStage.show();

        /*
        Button button1 = new Button("go to scene 2");
        Button button3 = new Button("pop up alert window");
        Label label1 = new Label("Scene 1");
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label1, button1, button3);
        scene1 = new Scene(layout1, 500, 400);

        Button button2 = new Button("go to scene 1");
        Label label2 = new Label("Scene 2");
        VBox layout2 = new VBox();
        layout2.getChildren().addAll(label2, button2);
        scene2 = new Scene(layout2, 500, 400);

        button1.setOnAction(e -> {
            primaryStage.setScene(scene2);
            primaryStage.show();
            label1.setText("you came back? lol");
        });

        button2.setOnAction(e -> {
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        button3.setOnAction(e -> AlertBox.display("Title of Window", "Wow this alert box is awesome!"));
        */
    }



}
