public class p40 {
    public static void main(String[] args) {
        //변수 교환//

        int x = 3;
        int y = 5;

        System.out.println("x :" + x + "/  y :" + y);

        int temp = x;
        x = y;
        y = temp;
        System.out.println("x :" + x + ",  y :" + y);

    }
}
