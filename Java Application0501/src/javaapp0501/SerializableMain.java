package javaapp0501;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializableMain {

	public static void main(String[] args) {
		// 파일에 인스턴스 단위로 기록
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./oo.dat"))) {
       DTO dto =(DTO)ois.readObject();    
       System.out.println(dto);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
