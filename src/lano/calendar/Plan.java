package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Plan {
	public static final Map<String, ArrayList<String>> hashMap = new HashMap<>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void createPlan() throws IOException {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print("> ");
		String date = br.readLine();
		
		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		String todo = br.readLine();
		
		ArrayList<String> list = hashMap.getOrDefault(date, new ArrayList<>());
		list.add(todo);
		hashMap.put(date, list);
		
		System.out.println("일정이 등록되었습니다.");
	}
}
