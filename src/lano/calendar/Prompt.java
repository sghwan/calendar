package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {
	
	public int parseDay(String weekday) {
		switch (weekday) {
		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		default:
			return -1;
		}
	}

	public void runPrompt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = new Calendar();

		while (true) {
			System.out.println("년도를 입력하세요. (-1: 프로그램 종료)");
			System.out.print("YEAR> ");
			int year = Integer.parseInt(br.readLine());
			if(year == - 1) break;

			System.out.println("월을 입력하세요. (1 ~ 12)");
			System.out.print("MONTH> ");
			int month = Integer.parseInt(br.readLine());
			if (month > 12 || month < 1) {
				System.out.println("잘못 입력 하셨습니다. 월은 1 ~ 12사이 숫자를 입력해 주세요");
				continue;
			}
			
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("WEEKDAY> ");
			String str_weekday = br.readLine();
			int weekday = parseDay(str_weekday);
			if (weekday == -1) {
				System.out.println("잘못 입력 하셨습니다. 요일은 SU, MO, TU, WE, TH, FR, SA 중 하나를 입력해 주세요");
				continue;
			}

			calendar.printCalendar(year, month, weekday);
		}

		System.out.println("END");
	}

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
