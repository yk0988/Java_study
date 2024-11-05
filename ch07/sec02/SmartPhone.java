package ch07.sec02;

public class SmartPhone extends Phone{

            public boolean wifi;
            public SmartPhone (String model, String color) {
                this.model = model;
                this.color = color;
            }

            // wifi 상태를 설정하는 메서드
            public void setwifi(boolean wifi) {  // viod → void로 수정
                this.wifi = wifi;
                System.out.println("와이파이 상태를 변경했습니다");
            }

            // 인터넷 사용을 표시하는 메서드
            public void internet() {  // viod → void로 수정
                System.out.println("인터넷에 연결되었습니다");  // 메시지 수정 (중복 방지)
            }
        }