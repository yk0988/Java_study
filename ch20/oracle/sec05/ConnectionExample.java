package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    public static void main(String[] args) {
        Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체 초기화

        try {
            // JDBC 드라이버 로드
            // Oracle JDBC 드라이버 클래스를 메모리에 로드
            Class.forName("oracle.jdbc.OracleDriver");

            // 데이터베이스 연결
            // JDBC URL, 사용자명, 비밀번호를 사용하여 데이터베이스에 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", // JDBC URL
                    "java", // 사용자명
                    "oracle" // 비밀번호
            );
            System.out.println("연결 성공"); // 연결 성공 메시지 출력

        } catch (ClassNotFoundException e) {
            // JDBC 드라이버를 찾을 수 없는 경우 예외 처리
            e.printStackTrace();
        } catch (SQLException e) {
            // SQL 관련 예외 처리
            e.printStackTrace();
        } finally {
            // finally 블록에서 리소스 정리
            if (conn != null) { // conn이 null이 아닐 경우
                try {
                    conn.close(); // 연결 종료
                    System.out.println("연결 종료"); // 종료 메시지 출력
                } catch (SQLException e) {
                    // 연결 종료 중 발생하는 예외 처리
                    e.printStackTrace();
                }
            }
        }
    }
}
