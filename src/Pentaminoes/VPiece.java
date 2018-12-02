package Pentaminoes;

import javafx.scene.paint.Color;

public class VPiece extends Pentamino { // Type 5

    public VPiece(){
        super();
        SetShape();
        SetStructure();
    }

    public void displace(){
        this.setFill(Color.rgb(202, 127, 233));
        placed = false;
    }

    public void place(){
        this.setFill(Color.rgb(148,0,211));
        placed = true;
    }

    @Override
    public void Rotate() {
        if (rotationEnum != 3)
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
                    gl*1, gl*1,
                    gl*2, gl*1,
                    gl*2, gl*3,
                    gl*4, gl*3,
                    gl*4, gl*4,
                    gl*1, gl*4});
        }
        else if(rotationEnum == 1) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*1, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*2,
                    gl*2, gl*2,
                    gl*2, gl*4,
                    gl*1, gl*4});
        }
        else if(rotationEnum == 2) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*1, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*4,
                    gl*3, gl*4,
                    gl*3, gl*2,
                    gl*1, gl*2});
        }
        else if(rotationEnum == 3) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*3, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*4,
                    gl*1, gl*4,
                    gl*1, gl*3,
                    gl*3, gl*3});
        }
    }

    private void SetStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, false, false, false, false},
                    {false, true, false, false, false},
                    {false, true, false, false, false},
                    {false, true, true, true, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{false, false, false, false, false},
                    {false, true, true, true, false},
                    {false, true, false, false, false},
                    {false, true, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, false, false, false, false},
                    {false, true, true, true, false},
                    {false, false, false, true, false},
                    {false, false, false, true, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{false, false, false, false, false},
                    {false, false, false, true, false},
                    {false, false, false, true, false},
                    {false, true, true, true, false},
                    {false, false, false, false, false}};
        }
    }
}
