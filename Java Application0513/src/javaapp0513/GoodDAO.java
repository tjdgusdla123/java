package javaapp0513;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//데이터베이스 연동 메소드를 소유한 클래스
public class GoodDAO {
//싱글톤 패턴 디자인 - 객체를 1개만 생성할 수 있도록 만든 패턴
	// 외부에서 생성할 수 없도록 생성자를 private으로
	private GoodDAO() {
	}

	// 만들어진 객체의 참조를 저장하기 위한 변수
	private static GoodDAO goodDAO = null;

	// 객체가 없으면 만들어서 리턴 // 있으면 있는 것을 리턴하도록 하는 객체 사용을 위한 메소드
	public static GoodDAO sharedInstance() {
		if (goodDAO == null) {
			goodDAO = new GoodDAO();
		}
		return goodDAO;
	}

	// 메소드 들에서 공통으로 사용할 변수
	private Connection con;
	private PreparedStatement pstmt;

	// 데이터베이스 연결 메소드
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user10", "user10");
		} catch (Exception e) {
			System.out.println("연결 실패");
			System.out.println(e.getMessage());
		}
	}

	//
	private void close() {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println("연결 실패");
			System.err.println(e.getMessage());
		}
	}

	// 전체 데이터를 가져오는 메소드 // select 는 where 절을 확인해서 매개변수 생성 // select* from good;
	// List를 리턴할 때는 인스턴스를 만들고 데이터를 추가한 후 리턴
	// 여러 개의 데이터를 가져올 때는 데이터가 없는 경우 size가0
	public List<Good> allGood() {
		//리턴할 데이터 생성
		//여러 개 일 때는 생성자를 호출해서 인스턴스를 생성
		List<Good> list = new ArrayList<Good>();
           
		// 데이터베이스 연결
		connect();
		try {
			// sql 실행 객체 생성
			pstmt = con.prepareStatement(" select* from goods");
			ResultSet rs = pstmt.executeQuery();
			// 데이터가 여러 개
			while (rs.next()) {
				// 행 단위 작업 수행
				Good imsi = new Good();
				// code 열의 값을 문자열로 읽어서 imsi에 저장
				imsi.setCode(rs.getNString("code"));
				imsi.setName(rs.getNString("name"));
				imsi.setManufacture(rs.getNString("manufacture"));
				imsi.setPrice(rs.getInt("price"));
				imsi.setReceivedate(rs.getDate("receivedate"));

				// list에 삽입
				list.add(imsi);
			}
		} catch (Exception e) {
			System.out.println("SQL 실행 에러");
			System.out.println(e.getMessage());
		}
		// 데이터베이스 연결 해제
		close();
		return list;
	}

	// code를 가지고 데이터를 잦아오는 메소드 // code는 기본키 // select * from goods where code=?
	// 하나의 행만 리턴하는 경우에는 데이터가 없으면 null을 리턴
	public Good getGood(String code) {
		Good good = null;
		
		//데이터베이스 연결
		connect();
		
		//데이터베이스 작업
		try {
			//SQL 실행 객체 생성
			pstmt =con.prepareStatement( "select * from goods where trim(code) =? ");
			pstmt.setString(1, code);
			//SQL 실행
			ResultSet rs = pstmt.executeQuery();
			//데이터가 2개 이상 나올 수 없으므로 if로 처리
			if(rs.next()) {
			good =new Good();
			good.setCode(rs.getNString("code"));
			good.setName(rs.getNString("name"));
			good.setManufacture(rs.getNString("manufacture"));
			good.setPrice(rs.getInt("price"));
			good.setReceivedate(rs.getDate("receivedate"));
		}
		}catch(Exception e) {
			System.out.println("상세보기 에러");
			System.out.println(e.getMessage());
		}
		
		//데이터베이스 연결 해제
		close();
		return good;
	}

	// 데이터를 삽입하는 메소드 // 삽입이나 수정은 매개변수가 DTO아니면 Map // -1이 리턴되면 실패 0이 리턴되면 조건에 맞는 데이터가
	// 없음
	// 양수가 리턴되면 작업을 수행한 것임
	public int intsrtGood(Good good) {
		int result = -1;
		return result;
	}

	// 데이터를 수정하는 메소드 // 삽입하는 메소드와 동일한 모양
	public int updateGood(Good good) {
		int result = -1;
		return result;
	}

	// 데이터를 삭제하는 메소드// 삭제는 대부분의 경우 기본키만으로 수행
	public int deleteGood(String code) {
		int result = -1;
		return result;
	}
}
