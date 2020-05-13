package javaapp0513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OneDept {

	public static void main(String[] args) {
		try {
			// 1.드라이버 클래스 로드 - 1번만 수행
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user10", "user10");

			// System.out.println("접속 성공");

			// 3.SQL 실행 객체 생성
			PreparedStatement pstmt = con.prepareStatement(" select deptno, dname, loc from dept where deptno = ? ");

			pstmt.setInt(1, 30);
			// 4.SQL 실행

			ResultSet rs = pstmt.executeQuery();

			// 5.결과 사용
			// 데이터가 있는지 확인
			if (rs.next()) {
				// 각 행마다 작업

				// deptno의 값을 정수로 읽어서 deptno에 저장
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.println(deptno + "\t" + dname + "\t" + loc);

			} else {
				System.out.println("조회된 데이터 없음");
			}

			// 6.사용이 끝난 객체 정리
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			// 예외 메시지를 빨간색으로 출력
			System.err.println(e.getMessage());
		}

	}

}
