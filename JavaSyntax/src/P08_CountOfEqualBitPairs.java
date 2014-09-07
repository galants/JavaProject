import java.util.Scanner;

public class P08_CountOfEqualBitPairs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		int indexLastBit = 31 -Integer.numberOfLeadingZeros(n);

		int countEqualBit = 0;

		for (int i = 0; i < indexLastBit; i++) {
			int maskFirst = 1 << i;
			int maskSecond = 1 << (i + 1);

			Boolean cond01 = (n & maskFirst) == maskFirst;
			Boolean cond02 = (n & maskSecond) == maskSecond;
			
			Boolean cond03 = cond01 ^ cond02;

			if (!cond03) {
				countEqualBit++;
			}
		}

		System.out.println(countEqualBit);
	}

}
