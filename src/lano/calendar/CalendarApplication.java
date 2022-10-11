package lano.calendar;

import java.io.IOException;
import java.text.ParseException;

public class CalendarApplication {

	public static void main(String[] args) {
		try {
			Prompt p = new Prompt(new Calendar(), new Plan());
			p.runPlanPrompt();
		} catch (ClassNotFoundException | IOException | ParseException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
