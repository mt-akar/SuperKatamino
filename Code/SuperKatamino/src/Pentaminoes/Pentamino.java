package Pentaminoes;

import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import Scenes.GameScene;

public abstract class Pentamino extends Polygon {

    final double gl = GameScene.gl; // Width an height of each square

    int rotationEnum;
    public boolean[][] structure;
    public boolean placed = false;

    public Pentamino(){
        super();

        rotationEnum = 0;

        this.displace();
        this.setStroke(Color.BLACK);
    }

    // Piece is pale if it is not correctly placed and vivid if it is.
    public abstract void displace();
    public abstract void place();

    public abstract void Rotate();
    protected abstract void SetShape();

}
