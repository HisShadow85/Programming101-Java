package week1;

public class SumAllNumbersInString {

	public static void main(String[] args) {
		System.out.println(sum("abc123dd34"));

	}
	
	static public int sum(String str){
	    int sum = 0;
	    String[] strNums = str.replaceAll("[^-?0-9]", " ").replace("( ) +", " ").replaceAll("- ", "-").replaceAll("  ", " ").trim().split(" ");
	    for (int i = 0; i < strNums.length; i++) {
			try{
				sum+=Integer.parseInt(strNums[i]);
			}catch(Exception e){
				
			}
		}
	    return sum;
	}

}
