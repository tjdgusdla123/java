package javaapp0521;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoMain {

	public static void main(String[] args) {
		// MongoDB 접속
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		// MongoDB 안의 mymongo 데이터베이스 접속
		MongoDatabase mymongo = mongoClient.getDatabase("mymongo");
		// mymongo 안의 users라는 컬렉션 가져오기
		MongoCollection<Document> users = mymongo.getCollection("users");
		// System.out.println(users);

		/*
		 * //1.전체 데이터 가져오기
		 * 
		 * //전체 데이터를 저장할 List를 생성 List<Document> list = new ArrayList<>();
		 * 
		 * //전체 데이터를 커서로 리턴해주는 메소드를 수행 //커서: 데이터의 모임을 순서대로 순회할 수 있도록 해주는 포인터
		 * MongoCursor<Document> cursor = users.find().iterator(); //데이터를 순회하면서 list에
		 * 하나씩 추가 while(cursor.hasNext()) { list.add(cursor.next()); } //전부 사용했으므로 사용 종료
		 * cursor.close();
		 * 
		 * //데이터 출력 for(Document document : list) { System.out.println(
		 * document.get("id") + ":" + document.get("password")); }
		 */

		// 2.조건에 의한 검색
		// 조건에 맞는 데이터를 저장할 List를 생성
		/*List<Document> list = new ArrayList<>();

		//조회할 조건을 저장할 Map 생성
		Map<String, Object> map = 
				new HashMap<>();
		map.put("id", "user03");
		// 전체 데이터를 커서로 리턴해주는 메소드를 수행
		// 커서: 데이터의 모임을 순서대로 순회할 수 있도록 해주는 포인터
		//조건에 맞는 데이터를 찾을 때는 find에 조건을 추가
		MongoCursor<Document> cursor = 
				users.find(new BasicDBObject(map)).iterator();
		// 데이터를 순회하면서 list에 하나씩 추가
		while (cursor.hasNext()) {
			list.add(cursor.next());
		}
		// 전부 사용했으므로 사용 종료
		cursor.close();

		// 데이터 출력
		for (Document document : list) {
			System.out.println(document.get("id") + ":" + document.get("password"));
		}
		*/
		//3.데이터 삽입
		//삽입할 데이터 생성
		
 		//Document document =new Document();
		//document.put("id", "tjdgusdla123");
		//document.put("password", "dkxkgh98");
		
		//users.insertOne(document);

		//4.데이터삭제 Document객체를 만들어서 deleteOne메소드를 호출하고Document를 매개변수로 대입
		//Document document =new Document();
		//document.put("id", "tjdgusdla123");
		//document.put("password", "dkxkgh98");
		
		//users.deleteOne(document);

		
		//조건에 해당하는 Document 생성
		Document  where =new Document ();
		where.put("id","user03");

		Document  set =new Document ();
		set.put("$set",new Document ("password","1111"));

		users.updateOne(where,set);
	}
}
