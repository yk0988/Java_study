package ch06.sec07.exam03;

public class KoreaExam {
    public static void main(String[] args) {

        Korea kor1 = new Korea("kim");
        Korea kor2 = new Korea("min","이게모야");

        System.out.println("1차 이름 " +kor1.name);
        System.out.println("2차 이름 " +kor2.name+" ssn "+ kor2.ssn);
         }
}
