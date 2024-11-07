public class p36 {
    public static void main(String[] args) {
        // 변수 선언: score라는 정수형 변수에 90을 할당
        int score = 90;

        // (타입)(변수): value라는 정수형 변수에 30을 할당
        int value = 30;

        // result라는 변수에 value에 10을 더한 값을 할당
        int result = value + 10;

        // result 변수의 값을 출력
        System.out.println("result = " + result);

        // 시간과 분을 나타내는 변수 선언
        int hour = 3;    // 시간은 3시간
        int minute = 5;   // 분은 5분

        // 시간과 분을 출력 (문자열 연결)
        System.out.println(hour + "시간" + minute + "분");

        // 총 분을 계산: (60 * hour)로 시간당 분수를 구하고, 거기에 minute을 더하여 총 분을 구함
        int totalminute = (60 * hour) + minute;

        // 총 분을 출력
        System.out.println("총시간 = " + totalminute);
    }
}
