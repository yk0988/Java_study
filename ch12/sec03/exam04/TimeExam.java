package ch12.sec03.exam04;

public class TimeExam {
    public static void main(String[] args) {
        long time1 = System.nanoTime();
        int sum=0;
        for(int i=1; i<=1000000; i++){
            sum += i;
        }
        long time2 = System.nanoTime();

        System.out.println("1~1000000까지의 합:"+sum);
        System.out.println("계산 : "+(time1+time2)+"나노초가 소요됩니다.");
    }
}
