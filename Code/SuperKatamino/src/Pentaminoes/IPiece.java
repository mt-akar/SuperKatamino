package Pentaminoes;

import javafx.scene.paint.Color;

public class IPiece extends Pentamino { // Type 1

    public IPiece(){
        super();
        SetShape();
        SetStructure();
    }

    public void displace(){
        this.setFill(Color.rgb(255,138,201));
        placed = false;
    }

    public void place(){
        this.setFill(Color.rgb(255,20,147));
        placed = true;
    }

    @Override
    public void Rotate() {
        if (rotationEnum != 1)
            rotationEnum++;
        else
            rotationEnum = 0;

        SetShape();
        SetStructure();
    }

    protected void SetShape(){
        if(rotationEnum == 0) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*2,
                    gl*5, gl*2,
                    gl*5, gl*3,
                    gl*0, gl*3});
        }
        else if(rotationEnum == 1) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*2, gl*0,
                    gl*3, gl*0,
                    gl*3, gl*5,
                    gl*2, gl*5});
        }
    }

    private void SetStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, false, false, false, false},
                    {false, false, false, false, false},
                    {true, true, true, true, true},
                    {false, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, false, true, false, false},
                    {false, false, true, false, false},
                    {false, false, true, false, false},
                    {false, false, true, false, false},
                    {false, false, true, false, false}};
        }
    }
}
