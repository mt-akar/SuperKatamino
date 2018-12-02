package Pentaminoes;

import javafx.scene.paint.Color;

public class SPiece extends Pentamino { // Type 4

    public SPiece(){
        super();
        SetShape();
        SetStructure();
    }

    public void displace(){
        this.setFill(Color.rgb(255, 127, 127));
        placed = false;
    }

    public void place(){
        this.setFill(Color.rgb(255, 0, 0));
        placed = true;
    }

    @Override
    public void Rotate() {
        if (rotationEnum != 7)
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
                    gl*2, gl*0,
                    gl*4, gl*0,
                    gl*4, gl*1,
                    gl*3, gl*1,
                    gl*3, gl*2,
                    gl*0, gl*2,
                    gl*0, gl*1,
                    gl*2, gl*1});
        }
        else if(rotationEnum == 1) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*0,
                    gl*1, gl*0,
                    gl*1, gl*2,
                    gl*2, gl*2,
                    gl*2, gl*4,
                    gl*1, gl*4,
                    gl*1, gl*3,
                    gl*0, gl*3});
        }
        else if(rotationEnum == 2) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*1, gl*0,
                    gl*4, gl*0,
                    gl*4, gl*1,
                    gl*2, gl*1,
                    gl*2, gl*2,
                    gl*0, gl*2,
                    gl*0, gl*1,
                    gl*1, gl*1});
        }
        else if(rotationEnum == 3) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*0,
                    gl*1, gl*0,
                    gl*1, gl*1,
                    gl*2, gl*1,
                    gl*2, gl*4,
                    gl*1, gl*4,
                    gl*1, gl*2,
                    gl*0, gl*2});
        }
        else if(rotationEnum == 4) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*0,
                    gl*3, gl*0,
                    gl*3, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*2,
                    gl*2, gl*2,
                    gl*2, gl*1,
                    gl*0, gl*1});
        }
        else if(rotationEnum == 4) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*0,
                    gl*3, gl*0,
                    gl*3, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*2,
                    gl*2, gl*2,
                    gl*2, gl*1,
                    gl*0, gl*1});
        }
        else if(rotationEnum == 5) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*1, gl*0,
                    gl*2, gl*0,
                    gl*2, gl*3,
                    gl*1, gl*3,
                    gl*1, gl*4,
                    gl*0, gl*4,
                    gl*0, gl*2,
                    gl*1, gl*2});
        }
        else if(rotationEnum == 6) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*0, gl*0,
                    gl*2, gl*0,
                    gl*2, gl*1,
                    gl*4, gl*1,
                    gl*4, gl*2,
                    gl*1, gl*2,
                    gl*1, gl*1,
                    gl*0, gl*1});
        }
        else if(rotationEnum == 7) {
            this.getPoints().clear();
            this.getPoints().addAll(new Double[]{
                    gl*1, gl*0,
                    gl*2, gl*0,
                    gl*2, gl*2,
                    gl*1, gl*2,
                    gl*1, gl*4,
                    gl*0, gl*4,
                    gl*0, gl*1,
                    gl*1, gl*1});
        }
    }

    private void SetStructure(){
        if(rotationEnum == 0){
            structure = new boolean[][] {{false, false, true, true, false},
                    {true, true, true, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 1){
            structure = new boolean[][] {{true, false, false, false, false},
                    {true, false, false, false, false},
                    {true, true, false, false, false},
                    {false, true, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 2){
            structure = new boolean[][] {{false, true, true, true, false},
                    {true, true, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 3){
            structure = new boolean[][] {{true, false, false, false, false},
                    {true, true, false, false, false},
                    {false, true, false, false, false},
                    {false, true, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 4){
            structure = new boolean[][] {{true, true, true, false, false},
                    {false, false, true, true, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 5){
            structure = new boolean[][] {{false, true, false, false, false},
                    {false, true, false, false, false},
                    {true, true, false, false, false},
                    {true, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 6){
            structure = new boolean[][] {{true, true, false, false, false},
                    {false, true, true, true, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false}};
        }
        else if(rotationEnum == 7){
            structure = new boolean[][] {{false, true, false, false, false},
                    {true, true, false, false, false},
                    {true, false, false, false, false},
                    {true, false, false, false, false},
                    {false, false, false, false, false}};
        }
    }
}
