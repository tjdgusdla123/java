package javaapp0513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Text0513 {

	public static void main(String[] args) {
		try {
			//1 드라이버 연결해주는것
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("연결 성공");
			// 2데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user10", "user10");
			// 3실행 객체 생성
			PreparedStatement pstmt = con.prepareStatement("insert into dept(deptno, dname, loc) values(?,?,?)");
			pstmt.setInt(1,88);
			pstmt.setString(2, "영업");
			pstmt.setString(3, "은평구");
			//4sql
			int rownum= pstmt.executeUpdate();
			
			//5.삽입은 성공한 경우 1이상의 정수가 리턴됩니다.
			if(rownum > 0) {
				System.out.println("데이터 삽입 성공");
			}else {
				System.out.println("데이터 삽입 실패");
			}
			
			//6.사용이 끝난 객체 정리
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
