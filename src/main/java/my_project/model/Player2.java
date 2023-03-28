package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class Player2 extends InteractiveGraphicalObject  {

    public double speed;
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;

    public Player2(double x, double y){
        this.x = x;
        this.y = y;

        width = 80;
        height = 40;
        speed = 150;

        this.keyToGoLeft    = KeyEvent.VK_LEFT;
        this.keyToGoRight   = KeyEvent.VK_RIGHT;
        this.direction      = -1;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
    }

    public void update(double dt) {
        if(direction == 0 && x < Config.WINDOW_WIDTH-width-18){
            x = x + speed*dt;
        }
        if(direction == 2 && x > 0){
            x = x - speed*dt;
        }
        if(x < 0){
            x = 0;
        }
    }

    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }
}
