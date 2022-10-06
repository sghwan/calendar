package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt {

	private static final String PROMPT = "cal> ";

	public void runPrompt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = new Calendar();

		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print(PROMPT);
			int year = Integer.parseInt(br.readLine());

			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			int month = Integer.parseInt(br.readLine());

			if (month == -1)
				break;
			if (month > 12)
				continue;

			calendar.printCalendar(year, month);
		}

		System.out.println("END");
	}

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
