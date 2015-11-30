package ba.bitcamp.calculator;

public class Main {

	public static void main(String[] args) {

		// Calling calculator
		System.out.println(new Expression().getResult());
		
		System.out.println();

		// Testing string numbers
		System.out.println(NumbersAsString.getNumberAsString(1));
		System.out.println(NumbersAsString.getNumberAsString(10));
		System.out.println(NumbersAsString.getNumberAsString(100));
		System.out.println(NumbersAsString.getNumberAsString(2000));
		System.out.println(NumbersAsString.getNumberAsString(30000));
		System.out.println(NumbersAsString.getNumberAsString(400000));
		System.out.println(NumbersAsString.getNumberAsString(5000000));
		System.out.println(NumbersAsString.getNumberAsString(600));
		System.out.println(NumbersAsString.getNumberAsString(700));
		System.out.println(NumbersAsString.getNumberAsString(800));
		System.out.println(NumbersAsString.getNumberAsString(900));

	}

}
