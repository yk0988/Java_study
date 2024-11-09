package ch20.oracle.sec12;

public class BoardExam {
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
        System.out.println("메인메뉴: 1.생성 / 2.읽기 / 3.제거 / 4. 나가기 ");
        System.out.print("메뉴선택");
        System.out.println();
    }

    public static void main(String[] args) {
        BoardExam boardExam = new BoardExam();
        boardExam.list();
    }
}

