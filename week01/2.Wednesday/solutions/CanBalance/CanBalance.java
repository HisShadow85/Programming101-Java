package week1;

public class CanBalance {

	public static void main(String[] args) {
		System.out.println(canBalance(new int[]{1, 1, 1, 2, 1}));
		System.out.println(canBalance(new int[]{2, 1, 1, 2, 1}));
		System.out.println(canBalance(new int[]{10, 10}));

	}
	
	static boolean canBalance(int[] array){
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		if((sum&1)==1) {return false;} //odd sum can't be divided into two equal integers
		int currSum = 0;
		for (int i = 0; i < array.length; i++) {
			currSum+=array[i];
			if(currSum == (sum>>1) ){
				return true;
			}
			else if(currSum > (sum<<1)){
				break;
			}
		}
		return false;
	}

}
