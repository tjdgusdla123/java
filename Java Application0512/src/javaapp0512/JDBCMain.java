package javaapp0512;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCMain {

	public static void main(String[] args) {
		try {
			// 1.데이터베이스 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.데이터베이스 접속 인스턴스 생성
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user10", "user10");
			// SQL실행 객체 생성
			PreparedStatement pstmt = con.prepareStatement
					(" DELETE FROM item WHERE num=?  ");
			pstmt.setInt(1, 2);
			
	
             //4.SQL 실행을하고 결과를 rownum에 저장 select 구문일 때는executeQuery로 실행되고 Resultset으로 받음
			
			int rownum = pstmt.executeUpdate();
			//5.결과 사용 
			if (rownum > 0) {
				System.out.println("삭제 성공");
			}else if(rownum==0) {
				System.out.println("조건에 맞는 데이터가 없음");
			} else {
				System.out.println("삭제 실패");
			}
			//6.사용한 인스턴스 연결 해제
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
