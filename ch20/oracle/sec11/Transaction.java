//package ch20.oracle.sec11;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class Transaction {
//    public static void main(String[] args) {
//        Connection conn = null;
//        try {
//            // JDBC Driver 등록
//            Class.forName("oracle.jdbc.OracleDriver");
//
//            // 데이터베이스 연결
//            conn = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521/xe",
//                    "java",
//                    "oracle"
//            );
//
//            conn.setAutoCommit(false);
//
//            String sql1 = "UPDATE accounts SET balance=bal-1 WHERE ano=?";
//            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
//            pstmt1.setInt(1, 10000);
//            pstmt1.setString(2, "111-111-1111");
//            int rows1 = pstmt1.executeUpdate();
//            if (rows1 == 0) throw new Exception("출금되지 않음");
//            pstmt1.close();
//
//            String sql2 = "UPDATE accounts SET balance=bal-1 WHERE ano=?";
//            PreparedStatement pstmt2 = conn.prepareStatement(sql1);
//            pstmt2.setInt(1, 10000);
//            pstmt2.setString(2, "222-222-2222");
//            int rows2 = pstmt2.executeUpdate();
//            if (rows2 == 0) throw new Exception("입금되지 않음");
//            pstmt2.close();
//
//            conn.commit();
//            System.out.println("계좌 이체 성공");
//
//
//        } catch (Exception e) {
//            try{
//                conn.rollback();
//            } catch (SQLException e1){}
//            System.out.println("계좌이체 실패");
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//}
