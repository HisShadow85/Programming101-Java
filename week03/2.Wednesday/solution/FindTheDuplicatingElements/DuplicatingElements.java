package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class DuplicatingElements {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4,5,6));
		ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(5,6,7,8));

		System.out.println(getDuplicatingElements(A,B,C));

	}
	
  @SafeVarargs
public static <T> Collection<T> getDuplicatingElements(Collection<T> ... lists){
	  if(lists.length < 1){ return null;}
	      HashSet<T> hs = new HashSet<>();
	      for(T item : lists[0]){
	    	  hs.add(item);
	      }
	      
	      HashSet<T> aux = new HashSet<>();
	      
	      for (int i = 1; i < lists.length; i++) {
			  aux.clear();
			  for(T item : lists[i]){
				  if(hs.contains(item)){
					  aux.add(item);
				  }
			  }
			  HashSet<T> temp = hs;
			  hs = aux;
			  aux = temp; 
		  }
	  
	      ArrayList<T> common = new ArrayList<>();
	      for(T item : hs){
	    	  common.add(item);
	      }
	      return common;
	      
  }

}
