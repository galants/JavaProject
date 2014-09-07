import java.util.Locale;
import java.util.Scanner;

public class P03_PointsInsideFigure {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		double x = input.nextDouble();
		double y = input.nextDouble();

		Boolean cond01 = (x >= 12.5) && (x <= 17.5) && (y >= 8.5)
				&& (y <= 13.5);
		Boolean cond02 = (x >= 20) && (x <= 22.5) && (y >= 8.5) && (y <= 13.5);
		Boolean cond03 = (x >= 12.5) && (x <= 22.5) && (y >= 6) && (y <= 8.5);

		if (cond01 || cond02 || cond03) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}
}