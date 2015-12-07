package week1;



public class CountNumberOfOccurencesNOL {

	public static void main(String[] args) {
		System.out.println(countOcurrences("da", "daaadaadada"));
	}

	static int countOcurrences(String needle, String haystack) {
		if(haystack.length() < needle.length()){ return 0;}
		int count = 0;
		int end = haystack.length()-needle.length()+1;
		char firstChar = needle.charAt(0);
		for (int i = 0; i < end; i++) {
			if(haystack.charAt(i) == firstChar){
				int k = 1;
				for (int j = i+1; k < needle.length(); j++,k++) {
					if(haystack.charAt(j) != needle.charAt(k)){
						break;
					}
				}
				if(k == needle.length()){
					count++;
					i+=k-1;
				}				
			}
		}
		return count;
	}
}
