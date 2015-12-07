package week1;

public class MinimumElement  {

	public static void main(String[] args) {
		int[] arr = {5,1,3,8,3,1,6,7,8,13,62,8,12};
		System.out.println(findMin(arr));

	}
    
	static int findMin(int[] arr){
		assert(arr.length != 0);
		
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < min){
				min = arr[i];
			}
		}
        
		return min;
		
	}
}
