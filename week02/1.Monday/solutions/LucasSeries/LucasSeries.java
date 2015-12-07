package week2;

public class LucasSeries {

	public static void main(String[] args) {
		System.out.println(nthLucas(5));

	}
    
	public static int nthLucas(int n){
		if(n < 1){return 0;}
		int prev =-1;
		int curr = 3;
		for (int i = 0; i < n; i++) {
			
			if( (i & 1) == 0){
				curr+=prev;			
			}
			else{
				prev+=curr;		
			}
		}
		
		if( (n & 1) == 0){
			return prev;			
		}
		else{
			return curr;		
		}
		
	}
}
