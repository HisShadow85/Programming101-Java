package week1;

public class RaiseAnIntegerToAPowerOfAnother {

	public static void main(String[] args) {
		System.out.println(power(2,1));

	}

	static double power(int a, int b) {
		if (a == 0 || a == 1 || b == 1) {
			return a;
		}
		if (b == 0) {
			return 1;
		}
			
		boolean oddPower = false;
		int power = b < 0 ? -b : b;
		
		if ((power & 1) == 1) {
			oddPower = true;
			power--;
		}

		long result = a;

		for (int currPower = 1; currPower < power; currPower <<= 1) {
			result *= result;
		}

		if (oddPower) {
			result *= a;
		}
		if (b > 0) {
			return result;
		} else {
			return (double) 1 / result;
		}
	}

}
