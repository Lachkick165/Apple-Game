package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;

public class Fruit extends InteractiveGraphicalObject {

    protected double speed;

    public Fruit(double x, double y){
        this.x = x;
        this.y = y;
        speed = 150;
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
