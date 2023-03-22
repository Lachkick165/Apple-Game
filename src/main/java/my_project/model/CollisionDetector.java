package my_project.model;

public class CollisionDetector {
    public static boolean circleWithRectangle(double cx, double cy, double radius, double rx, double ry, double rw, double rh){

        double testX = cx;
        double testY = cy;

        if (cx < rx)         testX = rx;
        else if (cx > rx+rw) testX = rx+rw;
        if (cy < ry)         testY = ry;
        else if (cy > ry+rh) testY = ry+rh;

        double distX = cx-testX;
        double distY = cy-testY;
        double distance = Math.sqrt( (distX*distX) + (distY*distY) );

        if (distance <= radius) {
            return true;
        }
        return false;
    }
}
