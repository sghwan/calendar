package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prompt {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Calendar calendar;
	private Plan plan;

	public Prompt(Calendar c, Plan p) {
		this.calendar = c;
		this.plan = p;
	}

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 일정 수정");
		System.out.println("| 4. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void cmdRegister(Plan plan) throws IOException {
		System.out.println("[일정 등록] 날짜를 입력하세요. 형식ex) 2022-10-08");
		System.out.print("date> ");
		String date = br.readLine();

		System.out.println("일정을 입력하세요.");
		System.out.print("todo> ");
		String todo = br.readLine();

		plan.createPlan(date, todo);

		System.out.println("일정이 등록되었습니다.");
	}

	public void cmdRead(Plan plan) throws IOException {
		System.out.println("[일정 검색] 날짜를 입력하세요. 형식ex) 2022-10-08");
		System.out.print("date> ");
		String date = br.readLine();

		ArrayList<String> plans = plan.getPlansOfDate(date);

		if (plans != null) {
			plan.printPlans(plans);
		} else {
			System.out.println("등록된 일정이 없습니다.");
		}
	}

	public void cmdUpdate(Plan plan) throws IOException {
		System.out.println("[일정 수정] 날짜를 입력하세요. 형식ex) 2022-10-08");
		System.out.print("date> ");
		String date = br.readLine();

		ArrayList<String> plans = plan.getPlansOfDate(date);

		if (plans != null) {
			plan.printPlans(plans);

			System.out.println("원하는 일정 번호를 선택해 주세요.");
			System.out.print("num> ");
			int num = Integer.parseInt(br.readLine());

			System.out.println("일정을 수정하세요.");
			System.out.print("todo> ");
			String todo = br.readLine();

			plan.updatePlan(date, num, todo, plans);
		} else {
			System.out.println("등록된 일정이 없습니다.");
		}
	}

	public void runCalendarPrompt() throws IOException {
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

			calendar.printCalendar(year, month, plan);
		}

		System.out.println("END");
	}

	public void runPlanPrompt() throws IOException {
		printMenu();

		while (true) {
			System.out.println("명령 (1, 2, 3, 4, h, q)");
			System.out.print("command> ");
			String command = br.readLine();

			if (command.equals("1"))
				cmdRegister(plan);
			else if (command.equals("2"))
				cmdRead(plan);
			else if (command.equals("3"))
				cmdUpdate(plan);
			else if (command.equals("4")) {
				LocalDate now = LocalDate.now();
				calendar.printCalendar(now.getYear(), now.getMonthValue(), plan);
			} else if (command.equals("h"))
				printMenu();
			else if (command.equals("q"))
				break;
			else
				System.out.println("(1, 2, 3, h, q) 중 하나를 입력해 주세요.");

			System.out.println();
		}

		System.out.println("END");
	}
}
