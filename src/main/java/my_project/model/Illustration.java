package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Illustration extends Apple{

    public Illustration(double x, double y, double speed){

        super(x, y, speed);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(255, 0, 0));
        drawTool.drawFilledCircle(x, y, radius);
    }

    public void jumpBack(){
        y = -10;
        x = Math.random()*1000;
    }

    public void jumpBack2(){
       x = Math.random()*940 + 30;
    }
}
