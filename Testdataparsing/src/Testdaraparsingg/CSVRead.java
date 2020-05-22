package Testdaraparsingg;

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
		try(
			
			CsvBeanReader reader = new CsvBeanReader(
					new BufferedReader(new InputStreamReader(
							new FileInputStream("C:\\Users\\30410\\Desktop\\2018년 관서별 청소년 5대범죄 현황.csv"))),
					CsvPreference.STANDARD_PREFERENCE)) {
			
			reader.getHeader(true);
			
			String [] headers = 
				{"classfication","salin","gangdo",
				 "ganggan","juldo","pokhang"};
			
			CellProcessor [] processors = 
					new CellProcessor[] {
						new Optional(),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional()),
						new ParseInt(new Optional())
			};
			
			List<Dataparsing> list = new ArrayList<Dataparsing>();
			
			//데이터를 읽어서 저장
			while(true) {
				//데이터를 1개 읽음
				Dataparsing dataparsing = reader.read(
						Dataparsing.class, headers,processors);
				//더 이상 읽지 못하면 종료
				if(dataparsing == null) {
					break;
				}
				//읽은 경우에는 list에 추가
				list.add(dataparsing);
			}
			for(Dataparsing dataparsing : list) {
				System.out.println(
						dataparsing.getClassfication() + ":"
					+ dataparsing.getJuldo());
			}
			
		}catch(Exception e) {
			System.out.println("데이터 읽기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
