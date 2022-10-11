package lano.calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Plan {
	private static Map<String, ArrayList<String>> hashMap;
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

	public void saveData() {
		File store = new File("store_file");
		try {
			FileOutputStream fos = new FileOutputStream(store);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hashMap);
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("저장할 파일을 찾지 못하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 저장중 에러가 발생했습니다.");
		}
	}

	public void createPlan(String date, String todo) {
		ArrayList<String> list = hashMap.getOrDefault(date, new ArrayList<>());
		list.add(todo);
		hashMap.put(date, list);
		saveData();
	}

	public ArrayList<String> getPlansOfDate(String date) {
		if (hashMap.containsKey(date)) {
			return hashMap.get(date);
		} else {
			return null;
		}
	}

	public void updatePlan(String date, int num, String todo, ArrayList<String> plans) {
		plans.set(num - 1, todo);
		hashMap.put(date, plans);
		saveData();
	}
}
