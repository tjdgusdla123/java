package javaapp0513;

import java.util.List;
import java.util.Scanner;

public class GoodMain {
//static 초기화
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 클래스 로드 성공");
		} catch (Exception e) {
			// 드라이버 클래스 로드 성공 했는지 확인후 주석 처리 System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 키보드로 부터 입력받기 위한 인스턴스 생성
		Scanner sc = new Scanner(System.in);

		// GoodDAO 인스턴스를 생성
		GoodDAO dao = GoodDAO.sharedInstance();
		mainloop: while (true) {
			System.out.println("메뉴 입력(1.전체 데이터 보기 2.코드로 데이터 조회하기 3.데이터 삽입 4.데이터 수정 5.데이터 삭제 6.종료)");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				// 전체데이터 가져오는 메소드 호출
				List<Good> list = dao.allGood();
				// list 순회하면서 출력하기
				for (Good g : list) {
					System.out.println(g.getCode() + ":" + g.getName() + ":" + g.getPrice() + "원");
				}
				System.out.println("전체 데이터 출력");
				break;
			case "2":
				// 코드1개 입력받기
				System.out.println("조회할 코드 입력");
				String code = sc.nextLine();
				// Dao 메소드 호출
				Good good1 = dao.getGood(code);
				if (good1 == null) {
					System.out.println("코드에 해당하는 데이터 없음");
				} else {
					System.out.println(good1);
				}
				break;
			case "3":
				System.out.println("데이터 삽입");
				break;
			case "4":
				System.out.println("데이터 수정");
				break;
			case "5":
				System.out.println("데이터 삭제");
				break;
			case "6":
				System.out.println("프로그램 종료");
				// break mainloop라는 반복문을 종료
				break mainloop;

			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다.");
				break;
			}
		}
		// 사용이 끝나면 키보드 연결 해제
		sc.close();
	}
}
