package week2;

public class LongestSubsequenceOfEqualConsecutiveElements {

	public static void main(String[] args) {
		System.out.println(maxEqualConsecutive(new int[] {1, 2, 3, 3, 3, 3, 4, 3, 3}));
        System.out.println(maxEqualConsecutive(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}));
	}
    
	public static int maxEqualConsecutive(int[] items){
	      if(items.length < 1){
	    	  return 0;
	      }
	      int maxCount = 1;
	      int count = 1;
	      
	      for (int i = 1; i < items.length; i++) {
			   if(items[i] == items[i-1]){
				   count++;
			   }
			   else{
				   if(maxCount < count){
					   maxCount = count;
				   }
				   count = 1;
			   }
		}
	    
	    if(maxCount < count){
			   maxCount = count;
		}
	    
	    return maxCount;
	}
}
