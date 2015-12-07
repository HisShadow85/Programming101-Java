package week1;

public class WordFrom_anbn {

	public static void main(String[] args) {
		System.out.println(is_an_bn("bbbaaa"));

	}
    
	static public boolean is_an_bn(String word){
		if(word.length()==0){
			return true;
		}
		if( (word.length() & 1) == 1){
			return false;
		}
		char front = word.charAt(0);
		char back = word.charAt(word.length()-1);
		
		if(front == back){
			return false;
		}
		
		for (int i = (word.length()>>1)-1; i >= 0; i-- ) {
			if(word.charAt(i) != front || word.charAt(word.length()-1-i)!= back){
				return false;
			}
		}
		
		return true;
		
	}
}
