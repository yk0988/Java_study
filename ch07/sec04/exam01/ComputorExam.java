package ch07.sec04.exam01;

public class ComputorExam {
    public static void main(String[] args) {
        int r = 10;

        Calculator calculator=new Calculator();
        System.out.println("원 면적"+ calculator.areaCircle(r));
        System.out.println();
    }
}
