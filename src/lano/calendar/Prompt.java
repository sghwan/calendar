package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {

	public void runPrompt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = new Calendar();

		while (true) {
			System.out.println("년도를 입력하세요. (-1: 프로그램 종료)");
			System.out.print("YEAR> ");
			int year = Integer.parseInt(br.readLine());
			if (year == -1)
				break;

			System.out.println("월을 입력하세요. (1 ~ 12)");
			System.out.print("MONTH> ");
			int month = Integer.parseInt(br.readLine());
			if (month > 12 || month < 1) {
				System.out.println("잘못 입력 하셨습니다. 월은 1 ~ 12사이 숫자를 입력해 주세요");
				System.out.println();
				continue;
			}

			calendar.printCalendar(year, month);
		}

		System.out.println("END");
	}

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
