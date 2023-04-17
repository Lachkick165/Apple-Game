package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerApple extends Apple{

    public PowerApple(double x, double y, double speed){

        super(x, y, speed);
        setNewImage("src/main/resources/graphic/eatenApple.png");
        width = 35;
        height = 39;
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
        drawTool.setCurrentColor(new Color(82, 57, 26));
        drawTool.drawFilledRectangle(x, y - 38, 4, 16);*/

        drawTool.drawImage(getMyImage(),x, y);
    }

    public void jumpBack(){
        y = -10;
        x = Math.random()*1000;
    }
}
