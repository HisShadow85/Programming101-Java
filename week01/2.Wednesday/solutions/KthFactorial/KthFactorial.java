package week1;

public class KthFactorial {

	public static void main(String[] args) {
		System.out.println(kthFac(2,4));
	}
    
    static long kthFac(int k, int n){
    	if(k <= 0){return n;}
    	if(n < 0){return 0;}
    	if(n < 2){return n;} 
    	//assert( k >= 0 && n >= 0);
    	long currN = n;
    	long result = 1;
    	int i = 0;
    	do{
			result = 1;
			for (long j = 2; j <= currN; j++) {
				result*=j;
			}
			currN = result;
		}while(++i<k);
    	
    	return result;
    }
}
