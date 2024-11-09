package ch20.oracle.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoderDelete {
    public static void main(String[] args) {

                Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체 초기화

                try {
                    // JDBC Driver 등록
                    Class.forName("oracle.jdbc.OracleDriver"); // Oracle JDBC 드라이버를 메모리에 로드

                    // 연결하기
                    conn = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521/xe", // JDBC URL
                            "java", // 데이터베이스 사용자명
                            "oracle" // 데이터베이스 비밀번호
                    );

                    // 매개변수화된 SQL문 작성
                    String sql = "DELETE FROM boards WHERE bwriter=?"; // 작성자가 "winter"인 게시물을 삭제하는 SQL문

                    // PreparedStatement 얻기 및 값 지정
                    PreparedStatement pstmt = conn.prepareStatement(sql); // SQL문을 PreparedStatement로 변환
                    pstmt.setString(1, "winter"); // 첫 번째 물음표에 "winter" 값 설정


                    // SQL문 실행
                    int rows = pstmt.executeUpdate(); // SQL DELETE 문 실행, 삭제된 행 수 반환
                    System.out.println("삭제 행 : " + rows + "개"); // 삭제된 행 수 출력

                    // PreparedStatement 닫기
                    pstmt.close(); // PreparedStatement 리소스 해제
                } catch (Exception e) {
                    e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
                } finally {
                    if (conn != null) { // Connection이 null이 아닐 경우
                        try {
                            // 연결 끊기
                            conn.close(); // 데이터베이스 연결 해제
                        } catch (SQLException e) {
                            e.printStackTrace(); // SQL 예외 발생 시 출력
                        }
                    }
                }
            }
        }
