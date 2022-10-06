package lano.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar {
	public static void main(String[] args) throws IOException{
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		//입력 받은 숫자(달)의 최대 일수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("달 을 입력하세요.");

		int month = Integer.parseInt(br.readLine());
		int[] day = new int[12];
		
		for(int i = 1; i <= 12; i++) {
			if(month <= 7) {
				if(i % 2 == 1) day[i - 1] = 31;
				else day[i - 1] = 30;
			} else {
				if(i % 2 == 0) day[i - 1] = 31;
				else day[i - 1] = 30;				
			}
		}
		
		day[1] = 28;

		System.out.println(month + "월은 " + day[month- 1] + "일까지 있습니다.");
	}
}
