package week1;

public class IsThisNumberPalindrome {

	public static void main(String[] args) {
		System.out.println(isThisNumberPalindrome(12321));
		System.out.println(isThisNumberPalindrome(12325));

	}

	static boolean isThisNumberPalindrome(int num){
		int temp = num;
		int reverse = 0;
		while(temp != 0){
			reverse*=10;
			reverse+=temp%10;
			temp/=10;
		}
		return num == reverse ;
	}
	
}
