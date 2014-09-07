import java.util.Scanner;

public class SumTwoNumbers {

	int a;
	int b;
	int sum;

	public static void main(String[] args) {
		SumTwoNumbers sumOfTowNumbers = new SumTwoNumbers();
		
		sumOfTowNumbers.readNumbers();
		
		System.out.println(sumOfTowNumbers.getSum());
	}

	protected void sum() {
		sum = a + b;
	}
	
	public int getSum() {
		
		this.sum();
		
		return sum;
	}

	public void readNumbers() {
		@SuppressWarnings("resource")
		Scanner str = new Scanner(System.in);

		a = str.nextInt();
		b = str.nextInt();
	}

}
