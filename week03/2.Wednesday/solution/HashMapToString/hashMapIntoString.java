package week3;

import java.util.HashMap;
import java.util.Map;

public class hashMapIntoString {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("Kafe", 3);
		map.put("Chorap", 7);
		map.put("Bekon", 6);
		System.out.println(getStringOfMap(map));

	}
	
	public static String getStringOfMap(HashMap<? extends Object, ? extends Object> map){
		StringBuilder sb = new StringBuilder("{");
		for(Map.Entry<? extends Object, ? extends Object> entry : map.entrySet() ){
			sb.append(" "+entry.getKey().toString()+":"+ entry.getValue().toString()+",");
		}
		sb.append(" }");
		return sb.toString();
	}

}
