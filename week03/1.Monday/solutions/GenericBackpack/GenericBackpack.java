package week3;

public class GenericBackpack<T> {
    
	T item;
	
	GenericBackpack(T item){
		this.item = item;
	}
	
	
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

    public String toString(){
    	return item.toString();
    }


	public static void main(String[] args) {
		GenericBackpack<Integer> intBackPack = new GenericBackpack<Integer>(6);
		GenericBackpack<String> strBackPack = new GenericBackpack<String>("Hello");
        System.out.println(intBackPack + " " + strBackPack);
	}

}
