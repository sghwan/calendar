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

	private void printPlans(ArrayList<String> list) {
		int count = list.size();

		System.out.println(count + "개의 일정이 있습니다.");

		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
	}

	public void createPlan() throws IOException {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print("date> ");
		String date = br.readLine();

		System.out.println("일정을 입력하세요.");
		System.out.print("todo> ");
		String todo = br.readLine();

		ArrayList<String> list = hashMap.getOrDefault(date, new ArrayList<>());
		list.add(todo);
		hashMap.put(date, list);

		System.out.println("일정이 등록되었습니다.");
	}

	public void getPlans() throws IOException {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.print("date> ");
		String date = br.readLine();

		if (hashMap.containsKey(date)) {
			ArrayList<String> list = hashMap.get(date);
			printPlans(list);

			return;
		}

		System.out.println("등록된 일정이 없습니다.");
	}

	public void updatePlan() throws IOException {
		System.out.println("[일정 수정] 날짜를 입력하세요.");
		System.out.print("date> ");
		String date = br.readLine();

		if (hashMap.containsKey(date)) {
			ArrayList<String> list = hashMap.get(date);
			printPlans(list);

			System.out.println("원하는 일정 번호를 선택해 주세요.");
			System.out.print("num> ");
			int num = Integer.parseInt(br.readLine());

			System.out.println("일정을 수정하세요.");
			System.out.print("todo> ");
			String todo = br.readLine();

			list.set(num - 1, todo);
			hashMap.put(date, list);

			return;
		}

		System.out.println("등록된 일정이 없습니다.");
	}
}
