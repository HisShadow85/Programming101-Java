package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ReverseGenericCollection {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>(Arrays.asList("a","b","c"));
		reverse(a);
		System.out.println(a);

	}
     
	static <T> void  reverse (Collection<T> collection){
        List<T> temp = new ArrayList<>(collection);
        try{
        	collection.clear();
        }catch(Exception e){
        	for(T item : collection){
        		collection.remove(item);
        	}
		}
		
        for (int i = temp.size() -1 ; i>= 0; i--) {
			collection.add(temp.get(i));
		}
		
		
		/*T[] temp = (T[]) collection.toArray();
		collection.clear();
		for (int i = temp.length; i >= 0 ; i--) {
			collection.add(temp[i]);
		}*/
		
		
		/*int size = collection.size();	
		int index = 0;
		for(T first : collection){
			
			int currIndex = 0;
			for(T last : collection){
				if(size - 1 - index == currIndex){
					T temp = first;
					first = last;
					last = temp;
					break;
				}
				currIndex++;
			}
			
			index++;
			if(index >= (size>>1)){
				break;
			}
		}*/
		
	}
}
