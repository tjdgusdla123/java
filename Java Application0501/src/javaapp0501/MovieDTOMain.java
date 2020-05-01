package javaapp0501;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class MovieDTOMain {

	public static void main(String[] args) {
		//MovieDTO클래스의 인스턴스 2개 만들기
		MovieDTO obj1 =new MovieDTO(1,"악마를 보았다","김지운","최민식,이병헌");
		
		MovieDTO obj2 =new MovieDTO();
		obj2.setNum(2);
		obj2.setTitle("범죄도시");
		obj2.setActor("마동석");
		obj2.setDirector("강윤성");
		
		//위의 2개를 배열로 묶기
		//MovieDTO[] ar ={obj1,obj2};
		
		//ArrayList로 묶어주기
		ArrayList<MovieDTO> list =new ArrayList<>();
		
		list.add(obj1);
	
		list.add(obj2);
		
		//오늘 날짜를 문자열로 만들기
		Date date =new Date();
	//날짜를 원하는 포맷의 문자열로 만들어주는 인스턴스
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String today =sdf.format(date);
		//System.out.println(today);
		
		//파일에 기록
		//ObjectOutputStream
		//FileOutputStream인스턴스를 이용해서 생성
		//파일의 경로를 가지고 생성
		try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(today+ ".dat"))){
			
			//파일에 기록
		oos.writeObject(list);
		}catch(Exception e) {}
		
		
		
	}

}
