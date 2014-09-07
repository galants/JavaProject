import java.util.Scanner;

public class P02_TriangleArea {

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) {	
		
			int ax = input.nextInt();
			int ay = input.nextInt();		
			
			int bx = input.nextInt();
			int by = input.nextInt();
			
			int cx = input.nextInt();
			int cy = input.nextInt();
			
			double area = Math.abs((ax*(by-cy) + bx*(cy-ay) + cx*(ay-by))/2);
			int areaRound = (int)area;

			System.out.println(areaRound);
		}
	}
}