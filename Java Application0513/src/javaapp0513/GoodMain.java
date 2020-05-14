package javaapp0513;

import java.sql.Date;
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
			// switch 구문 내에서 사용할 변수
			List<Good> list = null;
			Good good = null;
			int result = -1;

			String code = null;
			switch (menu) {
			case "1":
				// 전체데이터 가져오는 메소드 호출
				list = dao.allGood();
				// list 순회하면서 출력하기
				for (Good g : list) {
					System.out.println(g.getCode() + ":" + g.getName() + ":" + g.getPrice() + "원");
				}
				System.out.println("전체 데이터 출력");
				break;
			case "2":
				// 코드1개 입력받기
				System.out.println("조회할 코드 입력");
				code = sc.nextLine();
				// Dao 메소드 호출
				good = dao.getGood(code);
				if (good == null) {
					System.out.println("코드에 해당하는 데이터 없음");
				} else {
					System.out.println(good);
				}
				break;
			case "3":
				// 삽입할 코드를입력
				System.out.println("삽입할 코드를 입력");
				code = sc.nextLine();
				// 코드에 해당하는 데이터를 가져오기
				good = dao.getGood(code);
				// 코드에 해당하는 데이터가 없으면
				if (good == null) {
					// 나머지 데이터 입력
					System.out.print("이름 입력:");
					String name = sc.nextLine();
					System.out.print("원산지 입력:");
					String Manufacture = sc.nextLine();
					System.out.print("가격 입력:");
					String temp = sc.nextLine();
					int price = Integer.parseInt(temp);
					// 현재 날짜 생성
					Date receivedate = new Date(System.currentTimeMillis());
					// 삽입할 데이터 생성
					good = new Good();
					good.setCode(code);
					good.setName(name);
					good.setManufacture(Manufacture);
					good.setPrice(price);
					good.setReceivedate(receivedate);

					// sql 실행
					result = dao.intsrtGood(good);
					if (result > 0) {
						System.out.println("데이터 삽입 성공");
					} else {
						System.out.println("데이터 삽입 실패");
					}
				}
				// 코드에 해당하는 데이터가 있으면
				else {
					System.out.println("이미 존재하는 코드");
				}
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
