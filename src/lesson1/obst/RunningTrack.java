package lesson1.obst;

import lesson1.comp.Competitor;

public class RunningTrack implements Obstacles {
    private int dist;

    public RunningTrack(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor c) {
        c.run(dist);
    }
}
