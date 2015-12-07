package week1;

public class ZeroInsertion {

	public static void main(String[] args) {
		System.out.println(zero_insert(555555555));

	}
	
	public static long zero_insert(long n){
		if( (n >= 0 && n< 10) || (n < 0 && n > -10)){
			return abs(n);
		}
		
		n = abs(n);
		
		StringBuilder num = new StringBuilder(Long.toString(n));
		
		for (int i = 0; i < num.length()-1; i++) {
			if( (num.charAt(i) == num.charAt(i+1)) || //ch1 ==ch2
			  ( (num.charAt(i) + num.charAt(i+1) - ('0'<<1))%10 == 0 )){ //(digit1 + digit2) % 10 == 0
				num.insert(i+1, '0');
				i++;
			}
		}
		try{
			return Long.parseLong(num.toString());
		}catch(Exception e){ // in case of overflow
			return 0;
		}
		
	}
     
	private static long abs(long num){
		return num < 0 ? -num : num;
	}
}
