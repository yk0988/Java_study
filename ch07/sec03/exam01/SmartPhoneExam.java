package ch07.sec03.exam01;
//슈퍼: 부모님이 서류정리까지 다 해주세요//
public class SmartPhoneExam {
    public static void main(String[] args) {

    SmartPhone myPhone = new SmartPhone("갤럭시","은색");

        System.out.println("모델"+ myPhone.model);
        System.out.println("색상"+ myPhone.color);

        System.out.println("Phone(String model,String color) 생성자 실행");
    }
}