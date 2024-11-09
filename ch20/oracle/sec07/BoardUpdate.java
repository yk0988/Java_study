package ch20.oracle.sec07;

import java.sql.Connection; // 데이터베이스 연결을 위한 클래스
import java.sql.DriverManager; // 드라이버 매니저를 통한 연결 관리
import java.sql.PreparedStatement; // 매개변수화된 SQL문을 위한 클래스
import java.sql.SQLException; // SQL 관련 예외 처리를 위한 클래스

public class BoardUpdate {
    public static void main(String[] args) {
        Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체 초기화

        try {
            // JDBC 드라이버 등록
            // Oracle JDBC 드라이버 클래스를 메모리에 로드
            Class.forName("oracle.jdbc.OracleDriver");

            // 데이터베이스에 연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe", // JDBC URL
                    "java", // 사용자명
                    "oracle" // 비밀번호
            );

            // 매개변수화된 SQL문 작성
            // boards 테이블의 데이터 업데이트를 위한 SQL문
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ") // 게시글 제목
                    .append("bcontent=?, ") // 게시글 내용
                    .append("bfilename=?, ") // 파일 이름
                    .append("bfiledata=? ") // 파일 데이터
                    .append("WHERE bno=?") // 업데이트할 게시물 번호(bno)
                    .toString();

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람"); // 첫 번째 물음표에 제목 지정
            pstmt.setString(2, "눈으로 만든 사람"); // 두 번째 물음표에 내용 지정
            pstmt.setString(3, "snowman.jpg"); // 세 번째 물음표에 파일 이름 지정
            pstmt.setBlob(4, BoardUpdate.class.getResourceAsStream("/ch20/oracle/sec06/snow.jpg")); // 네 번째 물음표에 파일 데이터 지정
            pstmt.setInt(5, 3); // boards 테이블에 있는 게시물 번호(bno) 지정 (예: 3)

            // SQL문 실행
            int rows = pstmt.executeUpdate(); // 업데이트 실행 및 수정된 행 수 반환
            System.out.println("수정된 행 수: " + rows); // 수정된 행 수 출력

            // PreparedStatement 닫기
            pstmt.close(); // PreparedStatement 자원 해제
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        } finally {
            // 연결 끊기
            if (conn != null) {
                try {
                    conn.close(); // 연결 종료
                } catch (SQLException e) {
                    e.printStackTrace(); // 연결 종료 중 발생하는 예외 출력
                }
            }
        }
    }
}
