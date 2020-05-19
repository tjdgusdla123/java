package javaapp0518;

import java.util.List;
import java.util.Scanner;

public class CovidMain {

	public static void main(String[] args) {
		// 데이터베이스 사용 객체를 생성
		CovidDAO dao = CovidDAO.sharedInstance();
		// 키보드 입력 객체를 생성
		Scanner sc = new Scanner(System.in);

		// 여러 개의 데이터를 저장하기 위한 변수
		List<Covid> list = null;
		// 하나의 데이터를 저장하기 위한 변수
		Covid covid = null;
		// 삽입, 삭제, 갱신의 결과를 저장하기 위한 변수
		int result = -1;

		// Covid 각각을 위한 변수
		int num = -1;
		String region = null;
		String nation = null;
		int pop = -1;
		int confirmcount = -1;
		int deathcount = -1;

		// 입력을 받기 위한 임시변수
		String temp = null;

		// mainloop 라고 이름을 붙인 이유는
		// 내부에서 switch 를 사용할 것이고
		// 7번을 누를 때 반복문을 한번에 빠져나오기 위해서입니다.
		mainloop: while (true) {
			System.out
					.println("1.전체보기  2.2개씩 보기 3.상세보기 " + "4.대륙이나 국가로 검색\n" + "5.데이터삽입 6.데이터수정 7.데이터삭제 " + "8.프로그램 종료");
			System.out.print("메뉴 입력:");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				// 전체 가져오기를 호출
				list = dao.allCovid();
				// 데이터 출력
				System.out.printf("%5s%15s%10s\n", "번호", "국가", "사망자수");
				for (Covid imsi : list) {
					System.out.printf("%5d\t%15s\t%10d\n", imsi.getNum(), imsi.getNation(), imsi.getConfirmcount());
				}

				break;
			case "2":
			//전체 데이터 개수 가져오기 
				int cnt =dao.getCount();
				System.out.println("데이터개수:"+cnt);
				//페이지 수 만들기 - 페이지당 데이터 개수는2
				int pagesu =(int)((double)cnt/2+(double)(2-1)/2);
				//System.out.println("페이지 개수:"+pagesu);
				
				//첫번째 데이터 가져오기
				list = dao.pageCovid(1, 2);
				for(Covid imsi : list) {
					System.out.println(imsi);
				}
				
				while(true) {
					//조회할 페이지 번호 입력받기
					System.out.print(
						"페이지 번호(1-" + pagesu + ") 종료는 0:");
					temp = sc.nextLine();
					try {
						int pageno = Integer.parseInt(temp);
						if(pageno == 0) {
							break;
						}else if(pageno >= 1 && pageno <= pagesu) {
							//pageno 페이지의 데이터 가져와서 출력
							list = dao.pageCovid(pageno, 2);
							for(Covid imsi : list) {
								System.out.println(imsi);
							}
						}else {
							System.out.println("잘못된 페이지 번호");
						}
					}catch(Exception e) {
						System.out.println(
							"페이지 번호는 숫자로 입력하세요!!!");
					}
				}
				
				break;
			case "3":
				// 조회할 번호를 입력받기
				System.out.print("조회할 번호:");
				temp = sc.nextLine();
				try {
					num = Integer.parseInt(temp);
					// 데이터 가져오기
					covid = dao.getCovid(num);
					if (covid == null) {
						System.out.println("해당하는 번호의 데이터가 없습니다.");
					} else {
						System.out.println(covid);
						//System.out.printf("%5d\t%15s\n", covid.getNum(), covid.getNation());
					}
				} catch (Exception e) {
					System.out.println("정수를 입력하세요!!");
					break;
				}

				break;
			case "4":
				System.out.print("조회할 대륙이나 국가:");
				temp = sc.nextLine();
				list = dao.searchCovid(temp);
				if(list.size() == 0) {
					System.out.println("조회된 데이터가 없습니다.");
				}else {
					for(Covid imsi : list) {
						System.out.printf("%5d\t%10s\t%10s\t%10d\n", 
								imsi.getNum(), imsi.getRegion(),
								imsi.getNation(), imsi.getConfirmcount());
					}
				}
				
				break;
			case "5":
				// 대륙과 국가를 입력받기
				System.out.print("대륙:");
				region = sc.nextLine();
				System.out.print("국가:");
				nation = sc.nextLine();

				// 인구수, 확진자수, 사망자수 입력받기
				System.out.print("인구 수:");
				temp = sc.nextLine();
				pop = Integer.parseInt(temp);

				System.out.print("확진자 수:");
				temp = sc.nextLine();
				confirmcount = Integer.parseInt(temp);

				System.out.print("사망자 수:");
				temp = sc.nextLine();
				deathcount = Integer.parseInt(temp);

				// 데이터베이스 메소드에 넘겨주기 위해서 입력받은 데이터를
				// 1개로 만들기
				covid = new Covid();
				covid.setNum(num);
				covid.setRegion(region);
				covid.setNation(nation);
				covid.setConfirmcount(confirmcount);
				covid.setPop(pop);
				covid.setDeathcount(deathcount);

				// 데이터베이스 메소드 호출
				result = dao.insertCovid(covid);
				// 결과 사용
				if (result > 0) {
					System.out.println("데이터 삽입 성공");
				} else {
					System.out.println("데이터 삽입 실패");
				}

				break;
			case "6":
				//기본키 값 입력받기
				System.out.print("수정할 번호:");
				num = sc.nextInt();
				sc.nextLine(); //Enter를 가져가기 위해서 추가
				//데이터 찾아오기
				covid = dao.getCovid(num);
				if(covid == null) {
					System.out.println("없는 번호입니다.");
				}else {
					//대륙입력받기
					System.out.println("수정하지 않으려면 Enter");
					System.out.print("대륙 입력(이전-" + 
						covid.getRegion() + "):");
					region = sc.nextLine();
					//글자 수가 0이면 이전 값 갖기
					if(region.trim().length() == 0) {
						region = covid.getRegion();
					}
					//국가 입력받기
					System.out.println("수정하지 않으려면 Enter");
					System.out.print("국가 입력(이전-" + 
						covid.getNation() + "):");
					nation = sc.nextLine();
					//글자 수가 0이면 이전 값 갖기
					if(nation.trim().length() == 0) {
						nation = covid.getNation();
					}
					//인구 입력받기
					System.out.println("수정하지 않으려면 Enter");
					System.out.print("인구 입력(이전-" + 
						covid.getPop() + "):");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						pop = covid.getPop();
					}else {
						pop = Integer.parseInt(temp);
					}
					//확진자 수 입력받기
					System.out.println("수정하지 않으려면 Enter");
					System.out.print("확진자 수 입력(이전-" + 
						covid.getConfirmcount() + "):");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						confirmcount = covid.getConfirmcount();
					}else {
						confirmcount = Integer.parseInt(temp);
					}
					//사망자 수 입력받기
					System.out.println("수정하지 않으려면 Enter");
					System.out.print("사망자 수 입력(이전-" + 
						covid.getDeathcount() + "):");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						deathcount = covid.getDeathcount();
					}else {
						deathcount = Integer.parseInt(temp);
					}
					//입력받은 데이터를 하나로 만들기
					covid.setRegion(region);
					covid.setNation(nation);
					covid.setPop(pop);
					covid.setConfirmcount(confirmcount);
					covid.setDeathcount(deathcount);
					
					result = dao.updateCovid(covid);
					
					if(result > 0) {
						System.out.println("수정 성공");
					}else {
						System.out.println("수정 실패");
					}
				}
				
				break;
			case "7":
				//삭제할 번호 입력
				System.out.print("삭제할 번호:");
				temp = sc.nextLine();
				num = Integer.parseInt(temp);
				//데이터의 존재 여부를 확인
				covid = dao.getCovid(num);
				if(covid == null) {
					System.out.println("삭제할 수 없는 번호입니다.");
				}else {
					//정말로 삭제할 것인지 확인
					System.out.print("정말로 삭제(Y):");
					temp = sc.nextLine();
					//영문을 입력받아서 비교
					//trim은 좌우 공백 제거
					//toUpperCase는 모두 대문자로 변경
					if(temp.trim().toUpperCase().equals("Y")) {
						//삭제
						result = dao.deleteCovid(num);
						//삭제 결과 사용
						if(result > 0) {
							System.out.println("삭제 성공");
						}else {
							System.out.println("삭제 실패");
						}
					}
				}
				
				break;
			case "8":
				System.out.println("프로그램 종료");
				break mainloop;
			default:
				System.out.println("잘못된 메뉴 선택 !!!");
				break;
			}
		}
		// 키보드 입력 객체 닫기
		sc.close();
	}
}
