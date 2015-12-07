package week2;

public class IncreasingAndDecreasingSequences {

	public static void main(String[] args) {
		System.out.println(isIncreasing(new int[]{1,2,3,4,5,6,7,8,9}));
		System.out.println(isIncreasing(new int[]{1,2,3,5,5,6,7,8,9}));
		System.out.println(IsDecreasing(new int[]{9,8,7,6,5,4,3,2,1}));
		System.out.println(IsDecreasing(new int[]{9,8,7,6,5,3,3,2,1}));
	}
    
	static public boolean isIncreasing(int[] sequence){
		if(sequence.length == 1){
			return true;
		}
		else if(sequence.length < 1){
			return false;
		}
		for (int i = 1; i < sequence.length; i++) {
			if(sequence[i] <= sequence[i-1]){
				return false;
			}
		}
		return true;
	}
	
	static public boolean IsDecreasing(int[] sequence){
		if(sequence.length == 1){
			return true;
		}
		else if(sequence.length < 1){
			return false;
		}
		for (int i = 1; i < sequence.length; i++) {
			if(sequence[i] >= sequence[i-1]){
				return false;
			}
		}
		return true;
	}
}
