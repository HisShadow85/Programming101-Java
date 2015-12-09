package week3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class FindMin {
    
	public static void main(String[] args) {
	System.out.println(findMin(Arrays.asList(6,7,3,9,10,2,1,5)));

	}
	
	static public <T extends Comparable<T>> T findMin(Collection<T> set){
		if(set.size() < 1){return null;}
		Iterator<T> it = set.iterator();
		T min = it.next();
		for(T item : set){
			if(item.compareTo(min) < 0){
				min = item;
			}
		}
		return min;
	}

}
