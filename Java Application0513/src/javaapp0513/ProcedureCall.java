package javaapp0513;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProcedureCall {

	public static void main(String[] args) {
		try {
			// 1.드라이버 클래스 로드 - 1번만 수행
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user10", "user10");
            //메뉴얼 commit으로 변경
			con.setAutoCommit(false);
			
			//실행 객체 생성
			CallableStatement cstmt =con.prepareCall("{CALL insert_dept_proc(?,?,?)}"); 
			cstmt.setInt(1, 2);
			cstmt.setString(2, "설계");
			cstmt.setString(3, "독도");
			
			//4.실행
			int rownum =cstmt.executeUpdate();
			
			//5.결과 사용
			if(rownum>0) {
				System.out.println("데이터 삽입 성공하셨습니다 형님");
			}else {
				System.out.println("데이터 삽입 실패 잘좀 하십시오 형님");
			}
			
			cstmt.close();
			//작업을 데이터베이스에 반영
			con.commit();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}


