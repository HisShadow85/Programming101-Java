package week1;

import java.util.ArrayList;
import java.util.List;

public class IsAnAnagramOfStringASUBSEQUENCEInB {

	public static void main(String[] args) {
		System.out.println(hasAnagramOf("Mary", "The big Army"));

	}
    
	static boolean hasAnagramOf(String A, String B){
		CharHashSet chs = new CharHashSet(127,27);
		
		for (int i = 0; i < A.length(); i++) {
			if (!Character.isWhitespace(A.charAt(i))) {
				chs.insert(Character.toLowerCase(A.charAt(i)));
			}
		}
		
		for (int i = 0; i < B.length(); i++) {
			if (!Character.isWhitespace(B.charAt(i))) {
				chs.remove(Character.toLowerCase(B.charAt(i)));
				if(chs.chars_Left() == 0){
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}

class Char {
	public char ch;
	public short count;

	public Char() {
		ch = 0;
		count = 0;
	}

	public Char(char ch) {
		this.ch = ch;
		this.count = 1;
	}
    
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Char))return false;
	    Char otherMyClass = (Char)other;
	    if (this.ch == otherMyClass.ch) {
			return true;
		}
		return false;
	}
	
}

class CharHashTable {
	List<Char>[] table;
	int MOD;
	int BASE;

	@SuppressWarnings("unchecked")
	public CharHashTable(int base, int mod) {
		table = (ArrayList<Char>[]) new ArrayList[mod];
		for (int i = 0; i < table.length; i++) {
			table[i] = new ArrayList<Char>();
		}
		this.MOD = mod;
		this.BASE = base;
	}

	private int getKey(char ch) {
		return (ch*BASE) % MOD;
	}

	public void insert(char ch) {
		int key = getKey(ch);
		Char chh = new Char(ch);
		int index = table[key].indexOf(chh);
		if (index >= 0) {
			table[key].get(index).count++;
		} else {
			table[key].add(chh);
		}
	}

	public boolean remove(char ch) {
		int key = getKey(ch);
		Char chh = new Char(ch);
		int index = table[key].indexOf(chh);
		if (index >= 0 && table[key].get(index).count > 0) {
			table[key].get(index).count--;
			if (table[key].get(index).count == 0) {
				table[key].remove(index);
			}
			return true;
		} else {
			return false;
		}
	}
}

class CharHashSet {
	CharHashTable[] set;
	int MOD;
	int BASE;
	int charsLeft;

	public CharHashSet(int base, int mod) {
		set = new CharHashTable[mod];
		for (int i = 0; i < set.length; i++) {
			set[i] = new CharHashTable(base, mod/3);
		}
		this.MOD = mod;
		this.BASE = base;
	}

	private int getKey(char ch) {
		return ch % MOD;
	}

	public void insert(char ch) {
		int key = getKey(ch);
		set[key].insert(ch);
		charsLeft++;
	}

	public boolean remove(char ch) {
		int key = getKey(ch);
		boolean isRemove = set[key].remove(ch);
		if (isRemove) {
			charsLeft--;
		}
		return isRemove;
	}

	public int chars_Left() {
		return charsLeft;
	}
}
