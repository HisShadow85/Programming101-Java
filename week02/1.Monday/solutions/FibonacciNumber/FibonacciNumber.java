package week2;

public class FibonacciNumber {

	public static void main(String[] args) {
	System.out.println(fibNumConcatenate(10));

	}
    
	public static String fibNumConcatenate(int fibNum){
		if(fibNum < 1){return null;}
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		int curr = 1;
		for (int i = 0; i < fibNum; i++) {
			
			if( (i & 1) == 0){
				curr+=prev;
				sb.append(Integer.toString(curr));				
			}
			else{
				prev+=curr;
				sb.append(Integer.toString(prev));			
			}
		}
		
		return sb.toString();
	}
}
