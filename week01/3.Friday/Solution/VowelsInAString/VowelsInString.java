package week1;

public class VowelsInString {

	public static void main(String[] args) {
	int year = 46;
	boolean isLeap = (year & 3) == 0 && (year%400 == 0 || year%100 != 0);
       System.out.println(isLeap);
	}
    
	static int countVowels(String str){
		 int count = 0;
		 
		 for (int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))){
				if(isVowel(str.charAt(i))){
					count++;
				}
			}
		 }
		return count;
	}
	
	public static boolean isVowel(char c) {
		  return "AEIOUaeiou".indexOf(c) != -1;
	}
	
}
