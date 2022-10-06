package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar {
	private static final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDayofMonth(int month) {
		return maxDays[month - 1];
	}

	public void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) throws IOException {

		// 입력 받은 숫자(달)의 최대 일수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = new Calendar();
		
		System.out.println("반복횟수를 입력하세요.");
		int repeat = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < repeat; i++) {
			System.out.println("달 을 입력하세요.");
			int month = Integer.parseInt(br.readLine());
			System.out.println(month + "월은 " + calendar.getMaxDayofMonth(month) + "일까지 있습니다.");
		}
		System.out.println("반복 끝");
	}
}
