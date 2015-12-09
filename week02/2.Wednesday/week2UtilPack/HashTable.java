package week2UtilPack;

import java.util.ArrayList;
import java.util.List;

public class HashTable<T> {
	
		List<T>[] table;
		long MOD;
		long BASE;
        
		@SuppressWarnings("unchecked")
		public HashTable(int mod, int base) {
			table = (ArrayList<T>[]) new ArrayList[mod];
			for (int i = 0; i < table.length; i++) {
				table[i] = new ArrayList<T>();
			}
			this.MOD = mod;
			this.BASE = base;
		}

		private int getKey(T item) {
			return (int) (BASE*(item.hashCode() % MOD)%MOD);
		}

		public boolean insert(T item) {
			int key = getKey(item);
			int index = table[key].indexOf(item);
			if (index >= 0) {
				return false;
			} else {
				table[key].add(item);
				return true;
			}
		}

		public boolean remove(T item) {
			int key = getKey(item);
			int index = table[key].indexOf(item);
			if (index >= 0) {
				table[key].remove(index);
				return true;
			} else {
				return false;
			}
		}

	
}
