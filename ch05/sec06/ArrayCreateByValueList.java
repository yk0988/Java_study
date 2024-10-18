package ch05.sec06;

public class ArrayCreateByValueList {
    public static void main(String[] args) {
        int[] scores; //가변적 사용//
        scores = new int[]{83,90,87};
        int sum1=0;
        for(int i=0; i<3; i++){
            sum1+= scores[i];
        }

        System.out.println("총합 :" + sum1);
        //*사용자 메서드-밑에 느낌표 ! 부분 호출//
        printItem(new int[]{83,90,87});
    }
          //정적 메모리-메모리에 항상 남아있음//
    public static void printItem(int[]scores){
        for(int i=0; i<3; i++){
            System.out.println("scores["+1+"]:"+ scores[i]);
        }             //!!!!!*먼저써주기!!!!!!!//
    }
}
