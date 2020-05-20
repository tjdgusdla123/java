package javaapp0519;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CovidDAO {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("드라이버 클래스 로드");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private CovidDAO() {
	}

	private static CovidDAO covidDAO;

	// 외부에서 생성된 인스턴스를 사용할 수 있도록 리턴해주는 메소드
	public static CovidDAO sharedInstance() {
		// static 변수이므로 null을 대입하지 않는 이상
		// 맨 처음에만 null이고 이후에는 null이 될 수 없음
		if (covidDAO == null) {
			covidDAO = new CovidDAO();
		}
		return covidDAO;
	}

	private Connection con;
	private PreparedStatement pstmt;

	private void connect() {
			try {
				//데이터베이스 연결
				con = DriverManager.getConnection(
					"jdbc:mysql://192.168.0.200:3306/sample?useUnicode=true&characterEncoding=utf8",
					"root","*******");
				//System.out.println("데이터베이스 접속 성공");
			}catch(Exception e) {
				System.err.println("데이터베이스 연결 실패");
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
	}
	private void close() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.err.println("데이터베이스 해제 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Covid> allCovid() {
		List<Covid> list = new ArrayList<Covid>();
		connect();
		try {
			pstmt = con.prepareStatement("select * from covid19 ");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Covid covid = new Covid();
				covid.setNum(rs.getInt("num"));
				covid.setNation(rs.getString("nation"));
				covid.setDeathcount(rs.getInt("deathcount"));
				list.add(covid);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("전체 데이터 가져오기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		close();
		return list;
		
	}

}
