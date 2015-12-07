package week1;

public class DoubleFactorial {

	public static void main(String[] args) {
		System.out.println(doubleFac(3));
	}

	static long doubleFac(int n){
		if(n < 0){return 0;}
		return fac(fac(n));
	}
	
	static long fac(long n){
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result*=i;
		}
		return result;
	}
}
