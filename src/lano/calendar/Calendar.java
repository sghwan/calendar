package lano.calendar;

import java.io.IOException;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;

		return false;
	}

	public int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LEAP_MAX_DAYS[month - 1];

		return MAX_DAYS[month - 1];
	}

	public int getWeekday(int year, int month) {
		int lastYear = year - 1;
		int day = lastYear * 365 + ((lastYear / 4) - (lastYear / 100) + (lastYear / 400));
		boolean flag = isLeapYear(year);

		for (int i = 0; i < month - 1; i++) {
			if (flag)
				day += LEAP_MAX_DAYS[i];
			else
				day += MAX_DAYS[i];
		}

		return day % 7 + 1;
	}

	public String getDate(int year, int month, int day) {
		String str_month = month > 9 ? Integer.toString(month) : "0" + month;
		String str_day = day > 9 ? Integer.toString(day) : "0" + day;
		String date = year + "-" + str_month + "-" + str_day;

		return date;
	}

	public void markPlan(int year, int month, int day, int line, int weekday) throws ClassNotFoundException, IOException {
		Plan plan = new Plan();
		int start = line == 0 ? 1 : day - 6;

		if (line == 0) {
			for (int i = 0; i < weekday; i++) {
				System.out.print("   ");
			}
		}

		for (int i = start; i <= day; i++) {
			String date = getDate(year, month, i);
			boolean flag = plan.checkPlan(date);
			if (flag)
				System.out.print("  ·");
			else
				System.out.print("   ");
		}
	}

	public void printCalendar(int year, int month) throws ClassNotFoundException, IOException {
		int weekday = getWeekday(year, month);
		int line = 0;

		System.out.printf("    <<%d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		for (int i = 0; i < weekday; i++) {
			System.out.printf("   ");
		}

		for (int i = 1; i <= getMaxDayOfMonth(year, month); i++) {
			System.out.printf("%3d", i);

			if ((i + weekday) % 7 == 0) {
				System.out.println();
				markPlan(year, month, i, line, weekday);
				System.out.println();
				line++;
			}
		}

		System.out.println();
		System.out.println();
	}

}
