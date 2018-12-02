package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Application.GameLevel;
import Application.Main;

public class MainScene extends Scene {

    public MainScene() {
        super(new Pane(), 900, 600);
        VBox mainLayout = new VBox();
        setRoot(mainLayout);

        Button tutorialButton = new Button("Tutorial");
        Button resumeButton = new Button("Resume");
        Button playButton = new Button("Play");
        Button optionsButton = new Button("Options");

        mainLayout.getChildren().addAll(tutorialButton, resumeButton, playButton, optionsButton);

        resumeButton.setOnAction(e -> {
            Main.mainStage.setScene(new LevelPickerScene());
        });
    }
}
