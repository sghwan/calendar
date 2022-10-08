package lano.calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Plan {
	public static Map<String, ArrayList<String>> hashMap;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Plan() throws IOException, ClassNotFoundException {
		File file = new File("store_file");

		if (file.isFile()) {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			hashMap = (HashMap<String, ArrayList<String>>) ois.readObject();
			ois.close();
			fis.close();
		} else {
			hashMap = new HashMap<>();
		}

	}

	public void printPlans(ArrayList<String> list) {
		int count = list.size();

		System.out.println(count + "개의 일정이 있습니다.");

		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
	}

	public boolean checkPlan(String date) {
		if (hashMap.containsKey(date))
			return true;

		return false;
	}

	public void saveData() throws IOException {
		File store = new File("store_file");
		FileOutputStream fos = new FileOutputStream(store);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(hashMap);
		oos.flush();
		oos.close();
		fos.close();
	}

	public void createPlan() throws IOException {
		System.out.println("[일정 등록] 날짜를 입력하세요. 형식ex) 2022-10-08");
		System.out.print("date> ");
		String date = br.readLine();

		System.out.println("일정을 입력하세요.");
		System.out.print("todo> ");
		String todo = br.readLine();

		ArrayList<String> list = hashMap.getOrDefault(date, new ArrayList<>());
		list.add(todo);
		hashMap.put(date, list);
		saveData();

		System.out.println("일정이 등록되었습니다.");
	}

	public void getPlansOfDate() throws IOException {
		System.out.println("[일정 검색] 날짜를 입력하세요. 형식ex) 2022-10-08");
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
		System.out.println("[일정 수정] 날짜를 입력하세요. 형식ex) 2022-10-08");
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
			saveData();

			return;
		}

		System.out.println("등록된 일정이 없습니다.");
	}
}
