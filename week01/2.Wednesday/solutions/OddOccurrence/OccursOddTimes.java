package week1;

public class OccursOddTimes {

	public static void main(String[] args) {
		int[] input = {1,2,2,1,3,4,3,4,4,6,5,6,5};
		System.out.println(getOddOccurrence(input));

	}
    
	static public int getOddOccurrence(int[] array){
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result^=array[i];
		}
		return result;
	}
	
	
}
