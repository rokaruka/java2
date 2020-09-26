package lesson1.obst;

import lesson1.comp.Competitor;

public class Wall implements Obstacles {
    private int jumpheight;

    public Wall(int jumpheight) {
        this.jumpheight = jumpheight;
    }

    @Override
    public void doIt(Competitor c) {
        c.jump(jumpheight);
    }
}
