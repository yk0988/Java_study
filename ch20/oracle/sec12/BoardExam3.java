package ch20.oracle.sec12;

import java.sql.*;
import java.util.Scanner;


import ch20.oracle.sec09.exam02.Board;
public class BoardExam3 {
    private Scanner scanner = new Scanner(System.in);
    private Connection conn;

    public BoardExam3() {
        try {
            Class.forName("oracle.jdbc.Driver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "java",
                    "oracle"
            );

        } catch (Exception e) {
            e.printStackTrace();
            exit();  // 수정된 부분
        }
    }

    private void list(){
        System.out.println();
        System.out.println("게시물목록");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------");


        try {

            String sql = "+" +
                    "SELECT bno, btitle, bwriter, bdate" +
                    " FROM boards " +
                    "ORDER BY bno DESC"; // SQL 쿼리
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("Bwriter"));
                board.setBdate(rs.getDate("bdate"));

                System.out.println("%-6s%-12s%-16s%-40s\n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                         board.getBtitle());

            }
            rs.close();
            pstmt.close();
         } catch (SQLException e) {
        e.printStackTrace();
        exit();
        }

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
            exit();
        }

        public static void main(String[] args) {
            BoardExam3 boardExam = new BoardExam3();
            boardExam.list();
        }
    }




