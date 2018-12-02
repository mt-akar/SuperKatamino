package Pentaminoes;

import javafx.scene.paint.Color;

public class XPiece extends Pentamino { // Type 12

    public XPiece(){
        super();
        SetShape();
        SetStructure();
    }

    public void displace(){
        this.setFill(Color.rgb(127,255,127));
        placed = false;
    }

    public void place(){
        this.setFill(Color.rgb(0,255,0));
        placed = true;
    }

    @Override
    public void Rotate() {

    }

    protected void SetShape(){
        this.getPoints().clear();
        this.getPoints().addAll(new Double[]{
                gl*2, gl*1,
                gl*3, gl*1,
                gl*3, gl*2,
                gl*4, gl*2,
                gl*4, gl*3,
                gl*3, gl*3,
                gl*3, gl*4,
                gl*2, gl*4,
                gl*2, gl*3,
                gl*1, gl*3,
                gl*1, gl*2,
                gl*2, gl*2});
    }

    private void SetStructure(){
        structure = new boolean[][] {{false, false, false, false, false},
                {false, false, true, false, false},
                {false, true, true, true, false},
                {false, false, true, false, false},
                {false, false, false, false, false}};
    }
}
