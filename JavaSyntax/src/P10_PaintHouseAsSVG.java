import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Scanner;

public class P10_PaintHouseAsSVG {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		double data[][] = new double[n][2];

		input.nextLine();
		for (int i = 0; i < data.length; i++) {
			data[i][0] = input.nextDouble();
			data[i][1] = input.nextDouble();
		}

		String content = "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<body>\n"
				+ "<svg width=\"1000\" height=\"1000\">\n"
				+ "  <text x=\"60\" y=\"20\" FONT FACE=\"century gothic\" font-size=\"27\">10</text>\n"
				+ "  <text x=\"120\" y=\"20\" font-size=\"27\">12.5</text>\n"
				+ "  <text x=\"200\" y=\"20\" font-size=\"27\">15</text>\n"
				+ "  <text x=\"260\" y=\"20\" font-size=\"27\">17.5</text>\n"
				+ "  <text x=\"340\" y=\"20\" font-size=\"27\">20</text>\n"
				+ "  <text x=\"400\" y=\"20\" font-size=\"27\">22.5</text>\n"
				+ "  <text x=\"13\" y=\"70\" font-size=\"27\">3.5</text>\n"
				+ "  <text x=\"33\" y=\"140\" font-size=\"27\">6</text>\n"
				+ "  <text x=\"13\" y=\"210\" font-size=\"27\">8.5</text>\n"
				+ "  <text x=\"20\" y=\"280\" font-size=\"27\">11</text>\n"
				+ "  <text x=\"0\" y=\"350\" font-size=\"27\">13.5</text>\n"
				+ "  <text x=\"20\" y=\"420\" font-size=\"27\">16</text>\n"

				+ "  <line x1=\"53\" y1=\"60\" x2=\"440\" y2=\"60\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"53\" y1=\"130\" x2=\"440\" y2=\"130\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"53\" y1=\"200\" x2=\"440\" y2=\"200\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"53\" y1=\"270\" x2=\"440\" y2=\"270\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"53\" y1=\"340\" x2=\"440\" y2=\"340\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"53\" y1=\"410\" x2=\"440\" y2=\"410\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"

				+ "  <line x1=\"70\" y1=\"30\" x2=\"70\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"140\" y1=\"30\" x2=\"140\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"210\" y1=\"30\" x2=\"210\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"280\" y1=\"30\" x2=\"280\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"350\" y1=\"30\" x2=\"350\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n"
				+ "  <line x1=\"420\" y1=\"30\" x2=\"420\" y2=\"440\" stroke-dasharray=\"2, 2\" style=\"stroke:rgb(211,228,244);stroke-width:2\" />\n";

		for (int i = 0; i < data.length; i++) {
			double x = data[i][0];
			double y = data[i][1];
			content += "<circle cx=\"" + (70 + (70 * ((x - 10) / 2.5))) + "\" cy=\"" + (60 + (70 * ((y - 3.5) / 2.5)))
					+ "\" r=\"4\" stroke=\"black\" ";
			if (isPointInide(x, y)) {
				content += " fill=\"black\" />\n";
			} else {
				content += " fill=\"grey\" />\n";
			}
		}
		content += "<polygon points=\"280,60 420,200 140,200\" style=\"fill:#848482;stroke:black;stroke-width:4;fill-opacity:0.3;stroke-opacity:0.8\" />\n"
				+ "<rect x=\"140\" y=\"200\" width=\"140\" height=\"140\" style=\"fill:#848482;stroke:black;stroke-width:4;fill-opacity:0.3;stroke-opacity:0.8\" />\n"
				+ "<rect x=\"350\" y=\"200\" width=\"70\" height=\"140\" style=\"fill:#848482;stroke:black;stroke-width:4;fill-opacity:0.3;stroke-opacity:0.8\" />\n"
				+ "</svg>\n</body>\n</html>";
	
			PrintWriter writer = new PrintWriter("house.html", "UTF-8");
			writer.println(content);
			writer.close();

	}

	public static boolean isPointInide(double x, double y) {
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

		return (condLeftSquare || condRightSquare || condInsaidTriangle);
	}
}