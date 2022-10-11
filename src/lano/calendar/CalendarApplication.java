package lano.calendar;

import java.io.IOException;

public class CalendarApplication {

	public static void main(String[] args) {
		try {
			Prompt p = new Prompt(new Calendar(), new Plan());
			p.runPlanPrompt();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
