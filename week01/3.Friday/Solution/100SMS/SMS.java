package week1;

import java.util.ArrayList;

class CodeRep{
	public byte num;
	public byte count;
	
	CodeRep(int num, int count){
		this.num = (byte)num;
		this.count = (byte)count;
	}
}

class Decoding{
	
	static int RESET = -100;
	static int WHITESPACE = 0;
	static int CAPITAL = 1;
	static CodeRep[] codeRep = { new CodeRep(2, 1), new CodeRep(2,2), new CodeRep(2,3), 
			 new CodeRep(3, 1), new CodeRep(3,2), new CodeRep(3,3),		
			 new CodeRep(4, 1), new CodeRep(4,2), new CodeRep(4,3),
			 new CodeRep(5, 1), new CodeRep(5,2), new CodeRep(5,3),
			 new CodeRep(6, 1), new CodeRep(6,2), new CodeRep(6,3),
			 new CodeRep(7, 1), new CodeRep(7,2), new CodeRep(7,3),new CodeRep(7,4),
			 new CodeRep(8, 1), new CodeRep(8,2), new CodeRep(8,3),
			 new CodeRep(9, 1), new CodeRep(9,2), new CodeRep(9,3),new CodeRep(9,4)
   };
	
	static public ArrayList<Integer> messageToNumbers(String msg){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lastUsed = RESET;
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isUpperCase(ch)){
					result.add(CAPITAL);
					lastUsed = RESET;
					ch = Character.toLowerCase(ch);
				}
				
				int code = codeRep[ch-'a'].num;
				int count = codeRep[ch-'a'].count;
				
				if(code == lastUsed){
					result.add(-1);
				}
				
				for (int j = 0; j < count; j++) {
					result.add(code);
				}
				
				lastUsed = code;
			}
			else if(Character.isWhitespace(ch)){
				result.add(WHITESPACE);
				lastUsed = RESET;
			}
		}
		
		return result;
	}
	
}

class Encoding{
	
	static char[][] chars = { {'a','b','c'},
			  {'d','e','f'},
			  {'g','h','i'},
			  {'j','k','l'},
			  {'m','n','o'},
			  {'p','q','r','s'},
			  {'t','u','v'},
			  {'w','x','y','z'} };
	
	static private char getChar(byte num, short count, boolean isCapital) {
		assert num > 1 && num < 10 && count > 0;

		count--;// if you type one time count%length will get the zero cell

		byte firstKey = (byte) ((num % 10) - 2);
		byte secondKey = (byte) (count % chars[firstKey].length);

		if (isCapital) {
			return Character.toUpperCase(chars[firstKey][secondKey]);
		} else {
			return Character.toLowerCase(chars[firstKey][secondKey]);
		}
	}

	static private String getWitheSpaces(short count) {
		if (count == 1) {
			return " ";
		}

		if (count <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (short i = 0; i < count; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}

	static private boolean isCapital(short count) {
		if (count <= 0) {
			return false;
		}
		if ((count & 1) == 0) {
			return false;
		} else {
			return true;
		}
	}

	static private boolean isValidCommand(byte com) {
		if (com >= 0 && com < 10 || com == -1) {
			return true;
		}
		return false;
	}

	static public String numbersToMessage(int[] pressedSequence) {
		if (pressedSequence.length < 1) {
			return "";
		}

		boolean capital = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < pressedSequence.length; i++) {
			// get next command
			byte currNum = (byte)pressedSequence[i];
			// count the number of repetitions
			short count = 1;
			while ((i + 1 < pressedSequence.length) && pressedSequence[i + 1] == currNum) {
				count++;
				i++;
			}
			// validates the current command
			if (!isValidCommand(currNum)) {
				continue;
			}

			switch (currNum) {
			case -1:
				break;
			case 0:
				sb.append(getWitheSpaces(count));
				break;
			case 1:
				capital = isCapital(count);
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				sb.append(getChar(currNum, count, capital));
				capital = false;
				break;
			default:
				throw new AssertionError(currNum);
			}

		}

		return sb.toString();
	}
	
}



public class SMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2};
		System.out.println(Encoding.numbersToMessage(input));
		
		System.out.println(Decoding.messageToNumbers("Ivo e Panda"));
	}

}
