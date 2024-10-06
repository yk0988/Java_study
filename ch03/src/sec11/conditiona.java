package sec11;
//삼항 연산자 - if문은 간략하게 쓰기위해 사용함 (예의상 앞에 괄호를 써줌-혼동방지)
public class conditiona {
    public static void main(String[] args) {
/*int score = 85;
char grade = (score>90) ? 'A': ((score>90)?'B':'C');
      System.out.println(score +"점은" +grade +"동급입니다");
주석 컨트롤 쉬프트 슬래시/*/

        int score = 100;
/*        char grade ;

        if (score>90)
            grade = 'A';

        else
            grade = 'B';*/

        char grade = (score>90) ? 'A':(score>80)? 'B':'c';

        System.out.println(score + "점은" + grade+ "등급입니다.");
    }
}
