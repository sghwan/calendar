package lano.calendar;

public class Calendar {
	private static final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDayofMonth(int month) {
		return maxDays[month - 1];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("   <<%d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		for(int i = 1; i <= getMaxDayofMonth(month); i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0) System.out.println();
		}
		System.out.println();
	}

}
