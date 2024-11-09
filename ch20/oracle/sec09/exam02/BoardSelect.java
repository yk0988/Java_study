package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "java",
                    "oracle"
            );

            // SQL
            String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
                    "FROM boards " +
                    "WHERE bwriter = ?";

            // PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            // 쿼리 실행
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                // Board 객체 생성
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));

                System.out.println(board);
                System.out.println();

                Blob blob = board.getBfiledata();
                if (blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream
                            ("c:/temp/" + board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {

            }
            }
        }
    }
}