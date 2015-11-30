package ba.bitcamp.calculator;

public class NumbersAsString {

	private static final String[] SINGLE = new String[] { "zero", "one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine" };
	private static final String[] DOUBLE = new String[] { "ten", "twenty",
			"thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	private static final String[] LARGE = new String[] { "hundred", "thousand",
			"million", "billion", "trillion" };

	public static String getNumberAsString(int number) {
		String num = String.valueOf(number);
		String value = "";
		if (num.length() != 1 || num.length() != 2) {
			value += getFirstNumber(num);
		}
		value += getNumberIfLarge(num);

		if (num.endsWith("0")) {

		}

		return value;
	}

	private static String getFirstNumber(String number) {
		switch (number.charAt(0)) {
		case '1':
			return SINGLE[1];
		case '2':
			return SINGLE[2];
		case '3':
			return SINGLE[3];
		case '4':
			return SINGLE[4];
		case '5':
			return SINGLE[5];
		case '6':
			return SINGLE[6];
		case '7':
			return SINGLE[7];
		case '8':
			return SINGLE[8];
		case '9':
			return SINGLE[9];
		default:
			return "";
		}
	}

	private static String getNumberIfLarge(String number) {
		int length = number.length();
		if (length == 1) {
			return getFirstNumber(number);
		} else if (length == 2) {
			return getTensNumber(number);
		} else if (length == 3) {
			return LARGE[0];
		} else if (length >= 4 && length <= 6) {
			return LARGE[1];
		} else if (length >= 7 && length <= 9) {
			return LARGE[2];
		} else if (length >= 10 && length <= 12) {
			return LARGE[3];
		} else if (length >= 13 && length <= 15) {
			return LARGE[4];
		}
		return "";
	}
	
	private static String getTensNumber(String number) {
		switch (number.charAt(0)) {
		case '1':
			return DOUBLE[0];
		case '2':
			return DOUBLE[1];
		case '3':
			return DOUBLE[2];
		case '4':
			return DOUBLE[3];
		case '5':
			return DOUBLE[4];
		case '6':
			return DOUBLE[5];
		case '7':
			return DOUBLE[6];
		case '8':
			return DOUBLE[7];
		case '9':
			return DOUBLE[8];
		default:
			return "";
		}
	}

}
