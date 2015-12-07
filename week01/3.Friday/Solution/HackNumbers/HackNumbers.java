package week1;

public class HackNumbers {

	public static void main(String[] args) {
		System.out.println(nextHack(3));
		System.out.println(isHack(8191));
	}

	static boolean isHack(int num) {
		assert num >= 0;
		String binNum = decInBin(num);
		byte onesCount = 0;
		for (int front = 0, back = binNum.length() - 1; front < back; front++, back--) {
			if (binNum.charAt(front) != binNum.charAt(back)) {
				return false;
			}

			if (binNum.charAt(front) == '1') {
				onesCount += 2;
			}
		}
		if ((binNum.length() & 1) == 1 && binNum.charAt(binNum.length() >> 1) == '1') {
			onesCount++;
		}

		if ((onesCount & 1) == 0) {
			return false;
		}

		return true;

	}
	
	static int nextHack(int n) {
		int nextNum;
		do {
			String num = decInBin(n);
			num = getNextBinPalindrome(num);
			nextNum = binToDec(num);
		} while (nextNum < n);
		return nextNum;
	}

	static String decInBin(int num) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			if ((num & 1) == 1) {
				sb.append('1');
			} else {
				sb.append('0');
			}
			num >>= 1;
			if (num == 0)
				break;

		}

		sb.reverse();
		return sb.toString();
	}

	static String getNextBinPalindrome(String str) {
		assert str.length() > 0;
		StringBuilder sb = new StringBuilder(str);
		if ((str.length() & 1) == 0) {
			sb.setCharAt(0, '1');
			sb.setCharAt(sb.length() - 1, '1');
			for (int i = 1, j = str.length() - 2; i < j; i++, j--) {
				sb.setCharAt(i, '0');
				sb.setCharAt(j, '0');
			}
			sb.insert(sb.length() >> 1, '1');
			return sb.toString();
		} else {
			boolean carry = false;
			sb.setCharAt(sb.length() >> 1, '1');

			for (int i = (str.length() >> 1) - 1, j = (str.length() >> 1) + 1; i >= 0; i--, j++) {
				if (sb.charAt(i) == '1' && sb.charAt(j) == '1') {
					sb.setCharAt(i, '0');
					sb.setCharAt(j, '0');
					carry = true;
				} else {
					sb.setCharAt(i, '1');
					sb.setCharAt(j, '1');
					carry = false;
				}
				if(carry == false){
					break;
				}
			}
			if (carry) {
				sb.insert(0, '1');
				sb.append('1');
			}
			return sb.toString();
		}
	}

	static int binToDec(String str) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			num<<=1;
			if(str.charAt(i) == '1'){
				num++;
			}			
		}
		return num;
	}
}
