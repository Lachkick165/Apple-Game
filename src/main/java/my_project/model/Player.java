package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double speed;
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    private boolean haa;
    private boolean haa2;
    private boolean stoptimer;
    private double timer;

    public Player(double x, double y){
        this.x = x;
        this.y = y;

        speed = 150;

        width = 80;
        height = 40;
        haa = false;
        haa2 = false;
        stoptimer = false;
        timer = 0;

        this.keyToGoLeft    = KeyEvent.VK_A;
        this.keyToGoRight   = KeyEvent.VK_D;
        this.direction      = -1;
    }

    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(157,152,3,255);
        drawTool.drawFilledRectangle(x,y,width,height);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x,y,width,height);
        drawTool.setCurrentColor(Color.white);
        drawTool.drawText(0, 20, "Speed "+ speed);
    }

    public void update(double dt) {
        if (haa) {
            if (haa2 == false){
                speed += 100*dt;
            }

            if (speed >= Math.random()*400 + 450){
                haa2 = true;
            }

            if (haa2){
                speed -= 100*dt;
            }

            if (speed <= 150){
                haa = false;
                haa2 = false;
                speed = 150;
            }
        }
        if (stoptimer){
            timer += dt;

            if (timer<=5){
                speed = 50;
            }else{
                speed = 150;
                stoptimer = false;
            }
        }
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

    public void boost(){
        haa = true;
    }
    public void stop(){ stoptimer = true;}

    public void randomx(){ x = Math.random()*960;}
}
