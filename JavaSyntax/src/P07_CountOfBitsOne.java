import java.util.Scanner;

public class P07_CountOfBitsOne {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int bitsCount = Integer.bitCount(n);

		System.out.println(bitsCount);
	}

}
