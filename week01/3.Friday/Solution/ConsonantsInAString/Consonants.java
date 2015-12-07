package week1;

public class Consonants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
	static int consonants(String str){
		 int count = 0;
		 
		 for (int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))){
				if(!isVowel(str.charAt(i))){
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
