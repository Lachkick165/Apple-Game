package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Pear extends Fruit {

    //Attribute
    public double speed;
    private double timer;
    private boolean saying;
    private int alpha;
    private double xt;

    public Pear(double x, double y, double speed, double xt){
        super(x, y, speed);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.xt = xt;
        width = 25;
        height = 35;
        timer = 0;
        saying = false;
        alpha = 255;

        setNewImage("src/main/resources/graphic/pear.png");
        width = 34;
        height = 47;
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);*/

        drawTool.drawImage(getMyImage(),x, y);

        drawTool.setCurrentColor(new Color(255, 255, 255, alpha));
        if (saying){drawTool.drawText(xt-75, 925, "In der Not frisst der Teufel Birnen");}
    }

    @Override
    public void update(double dt) {
        if (saying){
            alpha -= 1*dt;
        }
        if (alpha == 0){
            saying = false;
            alpha = 255;
        }

        y += speed*dt;
        timer += dt;

        if(y>1029){
            jumpBack();
        }

        if((int)timer % 2 == 0){
            x += 20 *dt;
        }else{
            x -= 20 * dt;
        }
    }

    public void jumpBack(){
        y = -10;
        x = Math.random()*1000;
    }

    public void saying(){saying = true;}

    public double getXt() {
        return xt;
    }
    public void setXt(double xt) {
        this.xt = xt;
    }
}

