package week1;

public class ReverseEachWordInString {

	public static void main(String[] args) {
		System.out.println(reverseAllWorlds("We are going to test- this solution"));

	}
	
	static String reverseAllWorlds(String str){
		StringBuilder sb = new StringBuilder();
		for (int front = 0; front < str.length()-1; front++) {
			if(!Character.isWhitespace(str.charAt(front))){
				int back;
				for (back = front; back < str.length() && !Character.isWhitespace(str.charAt(back)); back++);
				back--;
				int tempBack = back;
				while(back >= front){
					sb.append(str.charAt(back));
					back--;
				}
				front = tempBack;
			}
			else{
				sb.append(str.charAt(front));
			}
		}
		return sb.toString();
	}

}
