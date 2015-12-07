package week1;

public class CopyEveryCharacterKTimes {

	public static void main(String[] args) {
		System.out.println(copyEveryChar("tldr", 3));

	}
    
	static String copyEveryChar(String input, int k){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < k; j++) {
				sb.append(input.charAt(i));
			}
			
		}
		return sb.toString();
	}
}
