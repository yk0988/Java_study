package movie2;


import java.util.Scanner;

abstract class AbstractMenu implements Menu {
    protected String menuText; // 기본 문구
    protected Menu prevMenu;   // 이전 메뉴
    protected static final Scanner scanner = new Scanner(System.in);

    // 생성자
    public AbstractMenu(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    // print() 메서드
    @Override
    public void print() {
        System.out.println("\n" + menuText);
    }

    // setPrevMenu 메서드 (이전에 빠져있던 부분을 클래스 내부에 추가)
    public void setPrevMenu(Menu prevMenu) {
        this.prevMenu = prevMenu;
    }
}
