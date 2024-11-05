package ch06.sec11.exam01;

public class Koreanexam {
    public static void main(String[] args) {

        Korean K1 = new Korean("12234-1222","김자바");

        System.out.println(K1.nation);
        System.out.println(K1.ssn);
        System.out.println(K1.name);

        K1.name ="김자바";


//        K1.nation ="USA";
//        K1.ssn ="12434-2333";
//
//
//        System.out.println(K1.nation);
//        System.out.println(K1.ssn);
    }
}
