import java.time.LocalDateTime;

public class CurrentDateTime {

	public static void main(String... args) {
		LocalDateTime dt = LocalDateTime.now();
		String formatStr = String.format(
				"Current date and time are: %d/%d/%d %d:%d",
				dt.getDayOfMonth(), dt.getMonthValue(), dt.getYear(),
				dt.getHour(), dt.getMinute());

		System.out.println(formatStr);
	}

}
