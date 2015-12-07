package week1;

public class PalindromeLength {

	public static void main(String[] args) {
		System.out.println(getPalindromeLength("taz*zad"));

	}

	static int getPalindromeLength(String input) {
		int middle = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '*') {
                  middle = i;
                  break;
			}
		}
		int count = 0;
		for (int i = middle-1,j= middle + 1; i >= 0 && j<input.length(); i--,j++) {
			if(input.charAt(i)==input.charAt(j)){
				count++;
			}
			else{
				break;
			}
		}
		return count;
	}
}
