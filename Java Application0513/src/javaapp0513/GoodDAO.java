package javaapp0513;

import java.util.ArrayList;
import java.util.List;

//데이터베이스 연동 메소드를 소유한 클래스
public class GoodDAO {
//싱글톤 패턴 디자인 - 객체를 1개만 생성할 수 있도록 만든 패턴
	//외부에서 생성할 수 없도록 생성자를 private으로
	private GoodDAO() {}
	//만들어진 객체의 참조를 저장하기 위한 변수
	private static GoodDAO goodDAO =null;
	//객체가 없으면 만들어서 리턴
	//있으면 있는 것을 리턴하도록 하는 객체 사용을 위한 메소드
	private static GoodDAO sharedInstance() {
		if(goodDAO==null) {
			goodDAO = new GoodDAO();
		}
		return goodDAO;
	}
	
	//전체 데이터를 가져오는 메소드
	//select 는 where 절을 확인해서 매개변수 생성
	//select* from good;
	//List를 리턴할 때는 인스턴스를 만들고 데이터를 추가한 후 리턴
	//여러 개의 데이터를 가져올 때는 데이터가 없는 경우 size가0
	public List<Good> allGood(){
		List<Good> list =new ArrayList<Good>();
		
		return list;
		
	}
	//code를 가지고 데이터를 잦아오는 메소드
	//code는 기본키 
	//select * from goods where code=?
	//하나의 행만 리턴하는 경우에는 데이터가 없으면 null을 리턴
	public Good getGood(String code) {
		Good good = null;
		
		return null;
		
	}
	//데이터를 삽입하는 메소드
	//삽입이나 수정은 매개변수가 DTO아니면 Map
	//-1이 리턴되면 실패 0이 리턴되면 조건에 맞는 데이터가 없음
	//양수가 리턴되면 작업을 수행한 것임
	public int intsrtGood(Good good) {
		int result = -1;
		
		return result;
	}
	
	//데이터를 수정하는 메소드
	//삽입하는 메소드와 동일한 모양
	public int updateGood(Good good) {
		int result = -1;
		
		return result;
	}
	
	//데이터를 삭제하는 메소드
	//삭제는 대부분의 경우 기본키만으로 수행 
	public int deleteGood(String code) {
		int result = -1;
		
		return result;
	}
	
}
