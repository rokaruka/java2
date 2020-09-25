package lesson1.comp;

import lesson1.comp.Competitor;

public class Robot implements Competitor {
    private String name;
    private int maxJump;
    private int maxRun;
    private boolean onDiastance;

    public Robot(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.onDiastance = true;
    }

    public Robot(String name) {

        this(name, 6, 10000);
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRun) {
            System.out.println(name + " успешно пробежал " + dist + " метров");
        } else {
            System.out.println(name + " не смогу  успешно пробежать " +dist + " метров");
            onDiastance = false;
        }
    }

    @Override
    public void jump(int dist) {
        if (dist <= maxJump) {
            System.out.println(name + " успешно перепрыгнул " + dist + " метров");
        } else {
            System.out.println(name + " не смогу  успешно перепрыгнуть " +dist + " метров");
            onDiastance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDiastance;
    }

    @Override
    public void info() {
        System.out.println(name +" " + onDiastance);
    }
}
