package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;

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
    Points points;
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
            Pear pp = new Pear(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100);
            pearArrayList.add(pp);
            viewController.draw(pp);
        }

        for (int i = 0; i < 3; i++) {
            Apple aa = new Apple(Math.random()*(Config.WINDOW_WIDTH)-50 + 50, Math.random()*(Config.WINDOW_HEIGHT-50) + 50, Math.random()*150 + 100);
            appleArrayList.add(aa);
            viewController.draw(aa);
        }

        player = new Player(50, Config.WINDOW_HEIGHT-100);
        viewController.draw(player);
        viewController.register(player);

        points = new Points(0);
        viewController.draw(points);

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
            if(checkAndHandleCollision(p)){
                p.jumpBack();
                points.setPoints(points.getPoints()+1);
            }
        }

        for(Apple a : appleArrayList){
            if(checkAndHandleCollision(a)){
                a.jumpBack();
                points.setPoints(points.getPoints()+1);
            }
        }

        if (checkAndHandleCollision(powerApple01)){
            powerApple01.jumpBack();
            player.boost();
        }

        if (checkAndHandleCollision(illustration)){
            illustration.jumpBack2();
            player.boost();
            player.randomx();
            points.setPoints(points.getPoints()-1);
        }
        //TODO 08 Nachdem Sie die TODOs 01-07 erledigt haben: Setzen Sie um, dass im Falle einer Kollision (siehe TODO 06 bzw. 07) zwischen dem Spieler und dem Apfel bzw. dem Spieler und der Birne, die jumpBack()-Methode von dem Apfel bzw. der Birne aufgerufen wird.
        //Weitere TODOs folgen und werden im Unterricht formuliert. Spätestens nach TODO 08 sollte der Aufbau des Projekts durchdacht werden.
    }

    public boolean checkAndHandleCollision(Apple a){
        return player.collidesWith(a);
    }

    public boolean checkAndHandleCollision(Pear p){
        return player.collidesWith(p);
    }

    public boolean checkAndHandleCollision(PowerApple pa){
        return player.collidesWith(pa);
    }

    public boolean checkAndHandleCollision(Illustration il){
        return player.collidesWith(il);
    }



    //TODO 06 Fügen Sie eine Methode checkAndHandleCollision(Apple a) hinzu. Diese gibt true zurück, falls das Apple-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.

    //TODO 07 Fügen Sie eine Methode checkAndHandleCollision(Pear p) hinzu. Diese gibt true zurück, falls das Pear-Objekt mit dem Player-Objekt kollidiert. Nutzen Sie hierzu die collidesWith-Methode der Klasse GraphicalObject.
}
