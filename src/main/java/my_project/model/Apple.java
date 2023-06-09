package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Apple extends Fruit {

    //Attribute

    public Apple(double x, double y, double speed){
        super(x, y, speed);
        radius = 30;
        setNewImage("src/main/resources/graphic/normalApple.png");
        width = 30;
        height = 38;
    }

    @Override
    public void draw(DrawTool drawTool) {
        /*drawTool.setCurrentColor(255,0,0,255);
        drawTool.drawFilledCircle(x,y,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);*/
        drawTool.drawImage(getMyImage(),x, y);
    }

    @Override
    public void update(double dt) {
        //TODO 01 Ein Apfel soll von oben herab fallen. Sobald er unten den Bildschirmrand berührt wird die Methode jumpBack() aufgerufen (siehe TODO 02).
        super.update(dt);
    }

    //TODO 02 Lege eine Methode jumpBack() an, die bei Aufruf das Apple-Objekt oben am oberen Bildschirmrand an einer zufälligen x-Position positioniert.

    public void jumpBack(){
        y = -10;
        x = Math.random()*1000;
    }
}
