package week2;

import week2UtilPack.UniqueStack;

public class StackNoDuplicate<T> extends UniqueStack<T> {

	public static void main(String[] args) {
		StackNoDuplicate<Integer> snd = new StackNoDuplicate<Integer>();
		try{
			snd.push(6);snd.push(5);snd.push(4);snd.push(3);snd.push(2);snd.push(2);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		while(snd.size() != 0) {
			System.out.println(snd.pop());
		}
	}
	
}
