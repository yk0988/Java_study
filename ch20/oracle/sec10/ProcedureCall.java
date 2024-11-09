package ch20.oracle.sec10;

import java.sql.*;

public class ProcedureCall {
    public static void main(String[] args) {
        Connection conn = null;
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
            String sql = "{call user_create(?,?,?,?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, "summer");
            cstmt.setString(2, "한여름");
            cstmt.setString(3, "12345");
            cstmt.setInt(4, 26);
            cstmt.setString(5, "summer@mycompany.com");
            cstmt.registerOutParameter(6, Types.INTEGER);

            cstmt.execute();
            int rows = cstmt.getInt(6);
            System.out.println("저장된 행 수 " + rows);

            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
