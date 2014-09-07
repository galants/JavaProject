import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class P04_TheSmallestOf3Numbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		double min = input.nextDouble();

		for (int i = 0; i < 2; i++) {
			double num = input.nextDouble();
			
			min = Math.min(min, num);
		}
		
		DecimalFormat decimalFormat = new DecimalFormat();
		System.out.println(decimalFormat.format(min));

	}
}
