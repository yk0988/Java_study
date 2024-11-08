package ch15.sec05.exam01;

import java.sql.SQLOutput;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeExample {
    public static void main(String[] args) {
        TreeSet<Integer> scores= new TreeSet<>();

        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);


for (Integer s: scores){
    System.out.println(s+"");
}
        System.out.println("\n");
        System.out.println("가장낮은 점수:"+ scores.first());
        System.out.println("가장 높은 점수:"+ scores.last());
        System.out.println("95아래 점수:"+ scores.lower(95));
        System.out.println("95위 점수:"+ scores.higher(95));
        System.out.println("95점 이거나 바로 아래 점수 점수:"+ scores.floor(95));
        System.out.println("98점 이거나 바로 아래 점수 점수:"+ scores.ceiling(85));

        NavigableSet<Integer>
        rangeset =scores.tailSet(80,true);
        for (Integer s: rangeset){
            System.out.println(s+"");
        }
        System.out.println("\n");


        rangeset =scores.subSet(80,true,90,false);
        for (Integer s: rangeset){
            System.out.println(s+"");
        }
        System.out.println("\n");

    }
}
