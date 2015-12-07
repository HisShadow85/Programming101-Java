package week1;

import java.util.Scanner;

public class OddNumbe {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter number: ");
		int num = sc.nextInt();
		System.out.print("The number is ");
		System.out.println(isOdd(num)?"odd.":"even.");
		sc.close();
	}
    
	public static boolean isOdd(int num){
		if((num&1) ==1){
			return true;
		}
		else{
			return false;
		}
	}
}
