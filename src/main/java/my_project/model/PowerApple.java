package my_project.model;

import KAGO_framework.view.DrawTool;

import java.awt.*;

public class PowerApple extends Apple{

    public PowerApple(double x, double y){
        super(x, y);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(new Color(113, 132, 77));
        drawTool.drawFilledCircle(x, y, 20);
    }
}
