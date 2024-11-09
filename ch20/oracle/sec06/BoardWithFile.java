package ch20.oracle.sec06;
import java.sql.Connection; // 데이터베이스 연결을 위한 클래스
import java.sql.DriverManager; // 드라이버 매니저를 통한 연결 관리
import java.sql.PreparedStatement; // 매개변수화된 SQL문을 위한 클래스
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하는 클래스
import java.sql.SQLException; // SQL 관련 예외 처리를 위한 클래스

public class BoardWithFile {
    public static void main(String[] args) {
        Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체 초기화
        PreparedStatement pstmt = null; // SQL 실행을 위한 PreparedStatement 객체 초기화
        ResultSet rs = null; // 쿼리 결과를 저장할 ResultSet 객체 초기화

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", // JDBC URL
                    "java", // 사용자명
                    "oracle" // 비밀번호
            );

            // INSERT SQL 문 정의
            String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
                    "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";

//            // PreparedStatement 생성 및 SQL문 설정
//            pstmt = conn.prepareStatement(sql, new String[]{"bno"}); // bno를 반환할 수 있도록 설정
//            pstmt.setString(1, "눈오는 날"); // 첫 번째 물음표에 제목 지정
//            pstmt.setString(2, "함박눈 펑펑"); // 두 번째 물음표에 내용 지정
//            pstmt.setString(3, "winter"); // 세 번째 물음표에 작성자 지정
//            pstmt.setString(4, "snow.jpg"); // 네 번째 물음표에 파일 이름 지정

//            // PreparedStatement 생성 및 SQL문 설정
//            pstmt = conn.prepareStatement(sql, new String[]{"bno"}); // bno를 반환할 수 있도록 설정
//            pstmt.setString(1, "봄의 정원"); // 첫 번째 물음표에 제목 지정
//            pstmt.setString(2, "정원의 꽃이 아름다워요"); // 두 번째 물음표에 내용 지정
//            pstmt.setString(3, "winter"); // 세 번째 물음표에 작성자 지정
//            pstmt.setString(4, "spring.jpg"); // 네 번째 물음표에 파일 이름 지정

//// PreparedStatement 생성 및 SQL문 설정
//            pstmt = conn.prepareStatement(sql, new String[]{"bno"}); // bno를 반환할 수 있도록 설정
//            pstmt.setString(1, "눈오는 날"); // 첫 번째 물음표에 제목 지정
//            pstmt.setString(2, "함박눈 펑펑"); // 두 번째 물음표에 내용 지정
//            pstmt.setString(3, "winter"); // 세 번째 물음표에 작성자 지정
//            pstmt.setString(4, "snow.jpg"); // 네 번째 물음표에 파일 이름 지정

            // PreparedStatement 생성 및 SQL문 설정
            pstmt = conn.prepareStatement(sql, new String[]{"bno"}); // bno를 반환할 수 있도록 설정
            pstmt.setString(1, "크리스마스"); // 첫 번째 물음표에 제목 지정
            pstmt.setString(2, "메리크리스마스"); // 두 번째 물음표에 내용 지정
            pstmt.setString(3, "winter"); // 세 번째 물음표에 작성자 지정
            pstmt.setString(4, "christmas.jpg"); // 네 번째 물음표에 파일 이름 지정



            // BLOB 데이터 설정 (파일 데이터)
            pstmt.setBlob(5, BoardWithFile.class.getResourceAsStream("/ch20/oracle/sec06/snow.jpg")); // 다섯 번째 물음표에 이미지 파일 데이터 지정

            // SQL문 실행
            int rows = pstmt.executeUpdate(); // INSERT 실행 후 수정된 행 수 반환
            System.out.println("저장된 행 수: " + rows); // 저장된 행 수 출력

            // bno 값 얻기 (자동 생성된 키)
            if (rows == 1) { // 하나의 행이 성공적으로 저장되었을 경우
                rs = pstmt.getGeneratedKeys(); // 생성된 키를 가져오기
                if (rs.next()) { // 결과가 있을 경우
                    int bno = rs.getInt(1); // 첫 번째 컬럼에서 bno 값 읽기
                    System.out.println("저장된 bno: " + bno); // 저장된 bno 출력
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close(); // ResultSet 닫기
                if (pstmt != null) pstmt.close(); // PreparedStatement 닫기
                if (conn != null) conn.close(); // Connection 닫기
            } catch (SQLException e) {
                e.printStackTrace(); // SQL 예외 발생 시 출력
            }
        }
    }
}
