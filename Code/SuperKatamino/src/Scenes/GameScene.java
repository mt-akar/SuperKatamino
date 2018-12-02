package Scenes;

import Application.Main;
import Pentaminoes.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import Application.GameLevel;

public class GameScene extends Scene {

    public static final double gl = 30; // Width an height of each square

    static final double gameBoardOffsetX = gl*10;
    static final double gameBoardOffsetY = gl;

    static double mousePrevX, mousePrevY;

    GameLevel level; // The game level that is represented in this scene
    boolean[][] gameBoard; // State of the game board

    public GameScene(GameLevel level){
        super(new Pane(), 900, 600);
        Pane gameLayout = new Pane();
        setRoot(gameLayout);

        // Draw game board, change
        for (int i = 0; i < 6; i++){
            Line l = new Line(gameBoardOffsetX, gameBoardOffsetY + gl * i, gameBoardOffsetX + level.width * gl, gameBoardOffsetY + gl * i);
            if (i != 0 && i != 5)
                l.setStroke(Color.rgb(127, 127, 127));
            gameLayout.getChildren().add(l);
        }
        for (int i = 0; i < level.width + 1; i++){
            Line l = new Line(gameBoardOffsetX + gl * i, gameBoardOffsetY, gameBoardOffsetX + gl * i, gameBoardOffsetY + gl * 5);
            if (i != 0 && i != level.width)
                l.setStroke(Color.rgb(127, 127, 127));
            gameLayout.getChildren().add(l);
        }

        // Draw pieces, change
        for (int i = 0; i < level.pieces.length; i++){
            Pentamino shape1 = PentaminoGenerator(level.pieces[i]);
            shape1.setLayoutX(i*gl*5 + (i+1)*(gl/2));
            shape1.setLayoutY(200);
            gameLayout.getChildren().add(shape1);
        }

        // Initialize members
        this.level = level;
        gameBoard = new boolean[5][level.width];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < level.width; j++) {
                gameBoard[i][j] = false;
            }
        }

        // Back button
        Button back = new Button("Back");
        gameLayout.getChildren().add(back);
        back.setOnAction(e -> {
            Main.mainStage.setScene(new LevelPickerScene());
        });
    }

    // TODO: Add remaining pieces
    private Pentamino PentaminoGenerator(int type){
        Pentamino p = null;
        if (type == 1) p = new IPiece();
        else if (type == 2) p = new IPiece();
        else if (type == 3) p = new IPiece();
        else if (type == 4) p = new SPiece();
        else if (type == 5) p = new VPiece();
        else if (type == 6) p = new IPiece();
        else if (type == 7) p = new IPiece();
        else if (type == 8) p = new IPiece();
        else if (type == 9) p = new IPiece();
        else if (type == 10) p = new IPiece();
        else if (type == 11) p = new IPiece();
        else if (type == 12) p = new XPiece();
        else System.out.println("Undefined pentamino type");

        p.setOnMousePressed(OnMousePressedEventHandler);
        p.setOnMouseDragged(OnMouseDraggedEventHandler);
        p.setOnMouseReleased(OnMouseReleasedEventHandler);
        return p;
    }

    public EventHandler<MouseEvent> OnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // If the piece is placed, remove
                    if (p.placed){
                        int offsetX = (int)((p.getLayoutX() - gameBoardOffsetX) / gl);
                        int offsetY = (int)((p.getLayoutY() - gameBoardOffsetY) / gl);
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (p.structure[i][j]){
                                    gameBoard[i+offsetY][j+offsetX] = false;
                                }
                            }
                        }
                        p.displace();
                    }

                    // If left button pressed, rotate
                    if (t.getButton() == MouseButton.SECONDARY) {
                        p.Rotate();
                        return;
                    }

                    // Save the mouse position when the dragging starts
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();

                    // Bring piece to front
                    p.toFront();
                }
            };

    public EventHandler<MouseEvent> OnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // Move the piece
                    if (p.getLayoutX() + t.getSceneX() - mousePrevX >= 0)
                        p.setLayoutX(p.getLayoutX() + t.getSceneX() - mousePrevX);
                    p.setLayoutY(Math.max(p.getLayoutY() + t.getSceneY() - mousePrevY, 0));

                    // Update the mouse position after a drag happens
                    mousePrevX = t.getSceneX();
                    mousePrevY = t.getSceneY();
                }
            };

    public EventHandler<MouseEvent> OnMouseReleasedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    // If right button clicked
                    if (t.getButton() == MouseButton.SECONDARY)
                        return;

                    // Define a pointer to pentamino object
                    Pentamino p = ((Pentamino)(t.getSource()));

                    // If piece is dropped outside the box
                    if(p.getLayoutX() < gameBoardOffsetX - gl*2.5 || gameBoardOffsetX + gl*(level.width - .5) <= p.getLayoutX() ||
                            p.getLayoutY() < gameBoardOffsetY - gl*2.5 || gameBoardOffsetY + gl*4.5 <= p.getLayoutY())
                        return;

                    // Calculate offsets
                    int offsetX = (int)((NearestGL(p.getLayoutX()) - gameBoardOffsetX) / gl);
                    int offsetY = (int)((NearestGL(p.getLayoutY()) - gameBoardOffsetY) / gl);

                    // Check if the piece can be placed
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++) {
                            if ((i+offsetY >= 5 || i+offsetY < 0 || j+offsetX >= level.width || j+offsetX < 0 || gameBoard[i+offsetY][j+offsetX]) && p.structure[i][j]){
                                return; // If cannot, return
                            }
                        }
                    }

                    // Place the piece into the gameboard
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++) {
                            if (p.structure[i][j]){
                                gameBoard[i+offsetY][j+offsetX] = true;
                            }
                        }
                    }

                    /* Monitor game board
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < level.width; j++) {
                            System.out.print(gameBoard[i][j] + " ");
                        }
                        System.out.println();
                    }*/

                    // Snap the piece to grid
                    p.setLayoutX(NearestGL(p.getLayoutX()));
                    p.setLayoutY(NearestGL(p.getLayoutY()));
                    p.place();

                    // Check if game has ended
                    for (int i = 0; i < gameBoard.length; i++) {
                        for (int j = 0; j < gameBoard[0].length; j++) {
                            if (!gameBoard[i][j]){
                                return;
                            }
                        }
                    }

                    // TODO: Add game ended action here
                    System.out.println("Game ended");
                }
            };

    // Helper func that gives the nearest multiple of 'GL' to a given number
    private long NearestGL(double x){
        return Math.round(x / gl) * (long)gl;
    }
}
