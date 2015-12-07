package week1;

public class IsNprime{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean isPrime(int num) {
		if (num == 2) {
			return true;
		}
		if (num < 3 || (num & 1) == 0) {
			return false;
		}
		
		int bound = (int)sqrt(num);
		
		for (int i = 3; i <= bound; i++) {
			if(num % i == 0){
				return false;
			}			
		}
		return true;
	}

	static double sqrt(int num) {
		double left = 1.0;
		double right = num;
		double mid;

		while (right - left > 0.000000001) {
			mid = left + (right - left) / 2;
			if (mid * mid > num) {
				right = mid;
			} else if (mid * mid < num) {
				left = mid;
			} else {
				return mid;
			}
		}
		return left;
	}
}
