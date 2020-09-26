package lesson1;

import lesson1.comp.*;
import lesson1.obst.*;


public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {
                new Human("Anton"),
                new Cat("Pushok"),
                new Robot("R2D2"),
                new Cat("Barsik"),
                new Human("Aleksandr")
        };

        Obstacles[] obstacles = {
                new RunningTrack(400),
                new Wall(3)
        };

        for (Competitor c : competitors) {
            for (Obstacles o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
        for (Competitor competitor : competitors) {
            competitor.info();
        }
    }
}
