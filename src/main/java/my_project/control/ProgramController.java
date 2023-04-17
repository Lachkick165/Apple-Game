package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Illustration illustration;
    private Player player;
    private Player player2;
    private Points points;
    private Points points2;
    private PowerApple powerApple01;
    public static ArrayList<Pear> pearArrayList = new ArrayList<>();
    public static ArrayList<Apple> appleArrayList = new ArrayList<>();

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        for (int i = 0; i < 3; i++){
            Pear pp = new Pear(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100, 0);
            pearArrayList.add(pp);
            viewController.draw(pp);
        }

        for (int i = 0; i < 3; i++) {
            Apple aa = new Apple(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100);
            appleArrayList.add(aa);
            viewController.draw(aa);
        }

        player = new Player(50, Config.WINDOW_HEIGHT-100, 0, KeyEvent.VK_A, KeyEvent.VK_D);
        viewController.draw(player);
        viewController.register(player);

        player2 = new Player(200, Config.WINDOW_HEIGHT-100, 918, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        viewController.draw(player2);
        viewController.register(player2);

        points = new Points(0, 0, 10);
        viewController.draw(points);

        points2 = new Points(0, 917, 10);
        viewController.draw(points2);


        powerApple01 = new PowerApple(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100);
        viewController.draw(powerApple01);

        illustration = new Illustration(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100);
        viewController.draw(illustration);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){
        for(Pear p : pearArrayList){
            if(p.checkAndHandleCollision(player)){
                p.setXt(p.getX());

                p.jumpBack();
                p.saying();
                points.setPoints(points.getPoints()+1);
                points.setMinusPointsboolean(points.isMinusPointsboolean()==false);
            }
        }

        for(Pear p : pearArrayList){
            if(p.checkAndHandleCollision(player2)){
                p.setXt(p.getX());

                p.jumpBack();
                p.saying();
                points2.setPoints(points2.getPoints()+1);
                points2.setMinusPointsboolean(points2.isMinusPointsboolean()==false);
            }
        }

        for(Apple a : appleArrayList){
            if(a.checkAndHandleCollision(player)){
                a.jumpBack();
                points.setPoints(points.getPoints()+1);
                points.setMinusPointsboolean(points.isMinusPointsboolean()==false);
            }
        }

        for(Apple a : appleArrayList){
            if(a.checkAndHandleCollision(player2)){
                a.jumpBack();
                points2.setPoints(points2.getPoints()+1);
                points2.setMinusPointsboolean(points2.isMinusPointsboolean()==false);
            }
        }

        if (powerApple01.checkAndHandleCollision(player)){
            powerApple01.jumpBack();
            player.boost();
        }

        if (powerApple01.checkAndHandleCollision(player2)){
            powerApple01.jumpBack();
            player2.boost();
        }

        if (illustration.checkAndHandleCollision(player)){
            illustration.jumpBack2();
            player.stop();
            player.randomx();
            points.minusPoints();
        }

        if (illustration.checkAndHandleCollision(player2)){
            illustration.jumpBack2();
            player2.stop();
            player2.randomx();
            points2.minusPoints();
        }
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
    }

    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
}
