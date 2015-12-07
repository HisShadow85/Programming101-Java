package week1;

public class CreditCardValidation {

	public static void main(String[] args) {
		System.out.println(is_credit_card_valid("79927398713"));
		System.out.println(is_credit_card_valid("79927398715"));

	}

	static public boolean is_credit_card_valid(String number) {
		if (number.length() <= 0 || (number.length() & 1) == 0 || !isValidNumber(number)) {
			return false;
		}

		int sum = getSumOfTheOddElements(number);
		sum += getSumOfTheEvenElements(number);

		if ((sum % 10) == 0) {
			return true;
		} else {
			return false;
		}
	}

	static private boolean isValidNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	static private int getSumOfTheOddElements(String number) {
		int sum = 0;
		for (int i = number.length() - 2; i >= 0; i -= 2) {

			sum += (number.charAt(i) - '0') << 1;

		}
		return sum;
	}

	static private int getSumOfTheEvenElements(String number) {
		int sum = 0;
		for (int i = number.length() - 1; i >= 0; i -= 2) {

			sum += number.charAt(i) - '0';

		}
		return sum;
	}
}
