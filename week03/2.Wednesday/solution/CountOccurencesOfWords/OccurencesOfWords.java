package week3;

import java.util.Map;
import java.util.*;
public class OccurencesOfWords {

	public static void main(String[] args) {
		System.out.println(getOccurencesOfWords("Ninjas are all over the place! We are all going to die!"));

	}
	
	public static Map<String, Integer> getOccurencesOfWords(String text){
		text = text.replaceAll("[^0-9] \\W", " ").replaceAll("( ) +" , " ").trim();
		String[] words = text.split(" ");
		
		Map<String, Integer> result = new LinkedHashMap<String,Integer>(words.length);
		
		for (int i = 0; i < words.length; i++) {
			if(result.containsKey(words[i])){
				result.replace(words[i], result.get(words[i])+1);
			}
			else{
				result.put(words[i], 1);
			}
		}
		
		return result;
	}

}
