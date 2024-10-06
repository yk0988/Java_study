public class p36 {
    public static void main(String[] args) {
        //변수선언//
        int score = 90;
        //(타입)(변수)//
        int value = 30;
        int result = value + 10;

        System.out.println("result = "+result);


        int hour = 3;
        int minute = 5;
        System.out.println(hour+"시간"+minute+"분");

        int totalminute = (60*hour) + minute;
        System.out.println("총시간" + totalminute);

    }
}
