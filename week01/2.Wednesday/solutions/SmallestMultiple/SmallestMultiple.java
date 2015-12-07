package week1;

public class SmallestMultiple {

	public static void main(String[] args) {
		System.out.println(getSmallestMultiple(5));

	}

	static long getSmallestMultiple(int upperBound){
		if(upperBound < 1){return 0;}
		long lcm = 1;
		
		for (int num = 2; num <= upperBound; num++) {
			lcm = (lcm*num)/GCD(lcm,num);
		}
		
		return lcm;
			
	}
	
	static long GCD(long a, long b){
		
		while(a != 0){
			long temp = a;
			a = b%a;
			b = temp;
		}
		
		return b;
	}
	
}
