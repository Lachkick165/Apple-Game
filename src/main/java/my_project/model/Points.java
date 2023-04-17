package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Points extends InteractiveGraphicalObject {

    int points;
    private boolean minusPointsboolean;

    private boolean winScreen;

    public Points(int points, double x, double y){
        this.x = x;
        this.y = y;

        this.points = points;
        minusPointsboolean = false;
        winScreen = false;

        setNewImage("src/main/resources/graphic/winScreen2.png");
        width = 1892;
        height = 849;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(255, 255, 255));
        drawTool.drawText(x, y, "Points: "+ points + "/20");
        drawTool.setCurrentColor(Color.WHITE);

        if (winScreen){
            /*drawTool.setCurrentColor(new Color(1, 1, 1));
            drawTool.drawFilledRectangle(0, 0, 2000, 2000);*/

            drawTool.drawImage(getMyImage(),x, y);
        }
    }

    public void update(double dt) {
        if (minusPointsboolean){
            points -= 1;
        }

        if (points >= 2){
            winScreen = true;
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
