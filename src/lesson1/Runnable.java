package lesson1;

public interface Runnable {
    default void run(){
        System.out.println("run");
    }
}
