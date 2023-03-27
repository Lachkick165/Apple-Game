package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;

public class Fruit extends InteractiveGraphicalObject {

    public double speed;

    public Fruit(double x, double y, double speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void update(double dt) {
        y = y + speed*dt;

        if(y>1029){
            jumpBack();
        }
    }

    public void jumpBack(){}
}
