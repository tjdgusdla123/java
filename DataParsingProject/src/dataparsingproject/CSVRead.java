package dataparsingproject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVRead {

	public static void main(String[] args) {
		try (
				// CSV 파일 읽기 객체 만들기
				CsvBeanReader reader = new CsvBeanReader(
						new BufferedReader(new InputStreamReader(
								new FileInputStream("C:\\Users\\30410\\Desktop\\2018년 관서별 청소년 5대범죄 현황.csv"))),
						CsvPreference.STANDARD_PREFERENCE)) {

			// 파일 읽기 객체가 생성되었는지 확인
			// System.out.println(reader);

			// 첫번째 줄이 헤더인지 여부를 설정
			// 첫번째 줄은 읽지 않음
			reader.getHeader(true);
			// DTO클래스의 변수들은 순서대로 문자열 배열로 생성
			// 이부분을 가직 한 줄의 데이터를 읽었을때
			// 변수에 대입
			String[] headers = { "classfication", "salin", "gangdo", "ganggan", "juldo","pokhang" };
			// 제약조건 생성
			CellProcessor [] processors = 
					new CellProcessor[] {
						new Optional(),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional())
					};
				
			// 읽은 데이터를 저장할 DTO의 List를 생성
			List<Crime> list = new ArrayList<Crime>();

			// 데이터를 읽어서 저장
			while (true) {
				Crime crime = reader.read(Crime.class, headers, processors);

				// 더 이상 읽지 못하면 종료
				if (crime == null) {
					break;
				}
				// 읽는 경우에는 list에 추가
				list.add(crime);
			}
			// 데이터 사용
			for (Crime crime : list) {
				System.out.println(crime.getClassfication() + "범죄절도:"+ crime.getJuldo()+ "\t"+"명강간:" + crime.getGanggan()+"명");
			}
		} catch (Exception e) {
			System.out.println("csv 읽기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
