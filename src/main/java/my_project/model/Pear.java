package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Pear extends GraphicalObject {

    //Attribute
    private double speed;
    private double timer;

    public Pear(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
        width = 25;
        height = 35;
        timer = 0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    @Override
    public void update(double dt) {
        y += speed*dt;
        timer += dt;

        if(y>1029){
            jumpBack();
        }
        //TODO 03 Eine Birne soll von oben herab fallen. Sobald sie unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 04).

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
    //TODO 04 Lege eine Methode jumpBack() an, die bei Aufruf das Pear-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.
}

