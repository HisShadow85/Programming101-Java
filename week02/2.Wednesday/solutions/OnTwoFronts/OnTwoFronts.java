package week2;

import week2UtilPack.DoubleLinkList;
import week2UtilPack.List;

public class OnTwoFronts {

	public static void main(String[] args) {
		List<Integer> list = new DoubleLinkList<Integer>();
        for (int i = 0; i < 100; i++) {
			list.add(i);
		}
        System.out.println("add done");
        for (int i = 0; i < 100; i++) {
			System.out.println(list.get(i));
		}
        System.out.println("show content done");
        for (int i = 0; i < 50; i++) {
			list.remove(i);
		}
        for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
