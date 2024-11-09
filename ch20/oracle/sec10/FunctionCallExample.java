package ch20.oracle.sec10;

import java.sql.*;

public class FunctionCallExample {
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
            String sql = "{?=call user_login(?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, "winter2");
            cstmt.setString(3, "12345");

            cstmt.execute();
            int result = cstmt.getInt(1);

            cstmt.close();


            String message = switch (result) {
                case 0 -> "로그인 성공";
                case 1 -> "비밀번호 틀림";
                default -> "아이디 없음";
            };

            System.out.println(message);
        }catch (Exception e) {
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
