package ba.bitcamp.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Expression implements Calculate {

	private static final String OPERATORS = "/*+-";
	private List<String> parts;

	public Expression() {
		parts = new ArrayList<>();
	}

	@Override
	public String calculate(String operator, String firstNumber,
			String secondNumber) {

		Double first = Double.parseDouble(firstNumber);
		Double second = Double.parseDouble(secondNumber);
		Double res = 0.0;

		switch (operator) {
		case "/":
			if (!second.equals(0.0)) {
				res = first / second;
				return String.valueOf(res);
			}
			throw new UnsupportedOperationException("Cant divide by zero");
		case "*":
			return String.valueOf(res = first * second);
		case "+":
			return String.valueOf(res = first + second);
		case "-":
			return String.valueOf(res = first - second);
		default:
			return "NO RESULT";
		}

	}
	
	private void getMathExpressionFromUser() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter math expression for calculation");
		String expression = input.nextLine();

		int start = 0;
		int end = 0;

		for (int i = 0; i < expression.length(); i++) {
			if ('+' == expression.charAt(i) || '-' == expression.charAt(i)
					|| '*' == expression.charAt(i)
					|| '/' == expression.charAt(i)) {
				end = i;
				String temp = expression.substring(start, end);
				parts.add(temp);
				parts.add(String.valueOf(expression.charAt(i)));
				start = i + 1;
			}
			if (!expression.substring(start, expression.length()).contains("+")
					&& !expression.substring(start, expression.length())
							.contains("-")
					&& !expression.substring(start, expression.length())
							.contains("*")
					&& !expression.substring(start, expression.length())
							.contains("/")) {

				String finalPart = expression.substring(start,
						expression.length());
				parts.add(finalPart);
				break;
			}

		}
		input.close();
	}
	
	public void removeCalculatedParts(int iteratorIndex, String result) {
		parts.remove(iteratorIndex - 1);
		parts.remove(iteratorIndex);
		parts.set(iteratorIndex - 1, result);
	}

	public String getResult() {
		
		getMathExpressionFromUser();		

		for (int i = 0; i < OPERATORS.length(); i++) {
			while (parts.contains("/") || parts.contains("*")) {
				for (int j = 0; j < parts.size(); j++) {
					if ("/".equals(parts.get(j))) {
						String result = calculate("/", parts.get(j - 1),
								parts.get(j + 1));
						removeCalculatedParts(j, result);
					} else if ("*".equals(parts.get(j))) {
						String result = calculate("*", parts.get(j - 1),
								parts.get(j + 1));
						removeCalculatedParts(j, result);
					}
				}
			}

			for (int j = 0; j < parts.size(); j++) {
				if ("+".equals(parts.get(j))) {
					String result = calculate("+", parts.get(j - 1),
							parts.get(j + 1));
					removeCalculatedParts(j, result);
				} else if ("-".equals(parts.get(j))) {
					String result = calculate("-", parts.get(j - 1),
							parts.get(j + 1));
					removeCalculatedParts(j, result);
				}
			}

		}
		return parts.toString();
	}

}
