package week1;

public class IsPalindrome {

	public static void main(String[] args) {
		System.out.println(isStringPalindrome("alabala"));
		System.out.println(isStringPalindrome("aladin"));
	}
    
	static boolean isStringPalindrome(String str){
		for (int front = 0, back = str.length()-1; front <  back; front++,back--) {
			if(str.charAt(back) != str.charAt(front)){
				return false;
			}
		}
		
		return true;
	}
	
	
}
