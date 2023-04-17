package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Illustration extends Apple{

    public Illustration(double x, double y, double speed){

        super(x, y, speed);
        setNewImage("src/main/resources/graphic/greenApple.png");
        width = 40;
        height = 41;
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*drawTool.setCurrentColor(new Color(255, 0, 0));
        drawTool.drawFilledCircle(x, y, radius);*/

        drawTool.drawImage(getMyImage(),x, y);
    }

    public void jumpBack(){
        y = -10;
        x = Math.random()*1000;
    }

    public void jumpBack2(){
       x = Math.random()*940 + 30;
    }
}
