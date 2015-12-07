package week2;

public class LongestSubsequenceOfIncreasingConsecutiveElements {

	public static void main(String[] args) {
		System.out.println(maxIncreasingConsecutive(new int[]{1, 2, 3, 3, 3, 3, 4, 3, 3}));
		System.out.println(maxIncreasingConsecutive(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}));
	}
	
	static int maxIncreasingConsecutive(int[] items){
		 if(items.length < 1){
	    	  return 0;
	      }
	      int maxCount = 1;
	      int count = 1;
	      
	      for (int i = 1; i < items.length; i++) {
			   if(items[i] >= items[i-1]){
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
