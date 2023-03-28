package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Points extends InteractiveGraphicalObject {

    int points;
    private boolean minusPointsboolean;

    public Points(int points){

        this.points = points;
        minusPointsboolean = false;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(255, 255, 255));
        drawTool.drawText(0, 10, "Points: "+ points);
        drawTool.setCurrentColor(Color.WHITE);
    }

    public void update(double dt) {
        if (minusPointsboolean){
            points -= 1;
        }
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() {
        return points;
    }

    public boolean isMinusPointsboolean() {
        return minusPointsboolean;
    }

    public void setMinusPointsboolean(boolean minusPointsboolean) {
        this.minusPointsboolean = false;
    }

    public void minusPoints(){ minusPointsboolean = true;}
}
