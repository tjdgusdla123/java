package htmlparsing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaumCafeWriting {

	public static void main(String[] args) {
		try {
			//브라우저 실행
			System.setProperty(
				"webdriver.chrome.driver",
				"./chromedriver.exe");
			//브라우저 실행
			WebDriver driver = 
				new ChromeDriver();
			//다음 로그인 페이지 접속
			driver.get(
				"https://logins.daum.net/accounts/"
				+ "signinform.do?url=https%3A%2F%2F"
				+ "www.daum.net%2F");
			//아이디 입력란을 찾기
			WebElement id = 
				driver.findElement(By.xpath(
					"//*[@id=\"id\"]"));
			id.sendKeys("ggangpae3");
			//비밀번호 입력란을 찾기
			WebElement pw = 
				driver.findElement(By.xpath(
						"//*[@id=\"inputPwd\"]"));
			pw.sendKeys("cyberadam");
			
			//로그인 버튼을 찾기
			WebElement login = 
				driver.findElement(By.xpath(
					"//*[@id=\"loginBtn\"]"));
			login.click();
			
			//페이지 이동이 많을 때는 과부하를 방지하기 위해서 
			//중간중간 sleep을 추가
			Thread.sleep(3000);
			
			//카페로 이동
			driver.get("http://cafe.daum.net/samhak7");
			
			//프레임으로 이동
			driver.switchTo().frame("down");
			
			//글을 입력
			WebElement memo = 
				driver.findElement(
					By.xpath(
						"//*[@id=\"memoForm__memo\"]/div/table/tbody/tr[1]/td[1]/div/textarea"));
			memo.sendKeys("댓글을 입력합니다.");
			
			Thread.sleep(3000);
			//댓글 등록 버튼 클릭
			WebElement write = 
					driver.findElement(
						By.xpath(
							"//*[@id=\"memoForm__memo\"]/div/table/tbody/tr[1]/td[2]/a[1]/span[2]"));
			write.click();
			
			
		}catch(Exception e) {
			System.out.println("다음 카페 글 쓰기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
