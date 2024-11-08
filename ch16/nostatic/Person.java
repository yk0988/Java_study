package ch16.nostatic;

public class Person {

//    String name;
//    int population;
//
    String name;
    static int population =5;

    public Person(String name) {
        this.name = name;
        population++;
    }
}