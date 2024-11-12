package movie2;

public class MainApp {
    
    public static void main(String[]args){
        System.out.println("프로그램 시작");//프로그램 실행문구
        Menu menu = MainMenu.getInstance();
        
        while (menu !=null){
            menu.print();
            menu=menu.next();
        }
        System.out.println("프로그램종료");
    }
}
