package week1;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.omg.Messaging.SyncScopeHelper;

public class MaxSpan {

	public static void main(String[] args) {
		System.out.println(maxSpan(new int[]{1, 2, 1, 1, 3}));
	   System.out.println(maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}));
		  System.out.println(maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}));
	   
	}
    
	static int maxSpan(int[] arr){
		if(arr.length < 1){
			return 0;
		}
		int maxspan = 1;
		for (int front = 0; front < arr.length; front++) {
			for (int back = arr.length-1; back > front; back--) {
				if(back - front + 1 <= maxspan){
					break;
				}
				if(arr[front] == arr[back]){
					maxspan = back - front + 1;
				}
			}
		}
		
		return maxspan;
	}
}
