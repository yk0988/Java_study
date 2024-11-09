package ch20.oracle.sec12;

import java.util.Scanner;

public class BoardExam2 {
    private Scanner scanner = new Scanner(System.in);

    public void list() {
        System.out.println();
        System.out.println("게시물목록");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n",
                "1", "writer", "2024,10,31", "10월의 마지막");
        System.out.printf("%-6s%-12s%-16s%-40s\n",
                "2", "writer", "2024,10,31", "취업하고 싶어용");
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("메인메뉴: 1.create / 2.read / 3.clear / 4.exit ");
        System.out.print("메뉴선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> System.out.println("잘못된 입력입니다.");
        }
    }

    public void create() {
        System.out.println("*** create() 메소드 실행");
        list();
    }

    public void read() {
        System.out.println("*** read() 메소드 실행");
        list();
    }

    public void clear() {
        System.out.println("*** clear() 메소드 실행");
        list();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExam2 boardExam = new BoardExam2();
        boardExam.list();
    }
}

