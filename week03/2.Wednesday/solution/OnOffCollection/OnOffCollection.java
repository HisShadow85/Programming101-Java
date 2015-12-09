package week3;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class OnOffCollection {

	public static void main(String[] args) {
	

	}
	
    static public <T> void onOff(Collection<T> list){
    	HashSet<T> set = new HashSet<>();
    	for(T item : list){
    		if(set.contains(item)){
    			set.remove(item);
    		}
    		else{
    			set.add(item);
    		}
    	}
    	
    	list.clear();
    	
    	for(T item : set){
    		list.add(item);
    	}
    }

}
