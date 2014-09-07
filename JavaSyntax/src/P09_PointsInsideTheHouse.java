import java.util.Locale;
import java.util.Scanner;

public class P09_PointsInsideTheHouse {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		double x = input.nextDouble();
		double y = input.nextDouble();

		Boolean condLeftSquare = (x >= 12.5) && (x <= 17.5) && (y >= 8.5)
				&& (y <= 13.5);
		Boolean condRightSquare = (x >= 20) && (x <= 22.5) && (y >= 8.5)
				&& (y <= 13.5);

		double pointLeftX = 12.5;
		double pointLeftY = 8.5;
		double pointMidleX = 17.5;
		double pointMidleY = 3.5;
		double pointRightX = 22.5;
		double pointRightY = 8.5;
		
		double invDenom = ((pointMidleY - pointRightY)*(pointLeftX-pointRightX)+(pointRightX-pointMidleX)*(y-pointRightY));
		double alpha = ((pointMidleY-pointRightY)*(x-pointRightX)+(pointRightX-pointMidleX)*(y-pointRightY))/invDenom;
		double beta = ((pointRightY - pointLeftY) * (x-pointRightX) + (pointLeftX - pointRightX)* (y - pointRightY))/invDenom;
		double gamma = 1.0 - alpha - beta;

		Boolean condInsaidTriangle = (alpha >= 0) && (beta >= 0)&&(gamma>=0);

		if (condLeftSquare || condRightSquare || condInsaidTriangle) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}


}
