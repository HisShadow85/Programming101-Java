package week1;

 class Num{
	public int number;
	public int reverseNum;
	public boolean isPAlindrome;
	public Num() {
	}
}

public class PalindromeScore {
    
	
	
	public static void main(String[] args) {
		System.out.println(palindromeScore(48));

	}
    
	static int palindromeScore(int n){
		if(n < 1){return 0;}
		int score = 0;
		Num num = new Num();
		num.isPAlindrome = false;
		num.number = n;
		while(true){
			getReverse(num);
			if(num.isPAlindrome){				
				return score + 1;
			}
			else{
				num.number+=num.reverseNum;
			}
			score++;
		}
	}
	
	static void getReverse(Num num){
		int n = num.number;
		assert n > 0;
		int rev = 0;
		do{
			rev*=10;
			rev+=n%10;
			n/=10;
		}while(n != 0);
		
		if(rev == num.number){
			num.isPAlindrome=true;
		}else{
			num.isPAlindrome=false;
		}
		
		num.reverseNum = rev;
	}
}
