package week2UtilPack;


public class HashSet<T> {
	HashTable<T>[] set;
	long MOD;
	long BASE;
	int itemCount;

	@SuppressWarnings("unchecked")
	public HashSet(int mod,int base) {
		set = (HashTable<T>[]) new HashTable[mod];
		for (int i = 0; i < set.length; i++) {
			set[i] = new HashTable<T>(mod / 3,(base*7)%mod);
		}
		this.MOD = mod;
		this.BASE = base;
	}

	private int getKey(T item) {
		return (int) (BASE*(item.hashCode() % MOD)%MOD);
	}

	public boolean insert(T item) {
		int key = getKey(item);
		if (set[key].insert(item)) {
			itemCount++;
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(T item) {
		int key = getKey(item);
		boolean isRemove = set[key].remove(item);
		if (isRemove) {
			itemCount--;
		}
		return isRemove;
	}

	public int count() {
		return itemCount;
	}
}
