package ch06.sec15;

public class Singleton {
    private static Singleton Singleton = new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance() {
    return Singleton;
    }
}
