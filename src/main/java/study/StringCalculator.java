package study;

import java.util.List;
import java.util.Scanner;

/**
 * study
 * StringCalculator
 *
 * @author : USER
 */
public class StringCalculator {
    static List<String> operationList = List.of("+", "-", "*", "/");

    public String getUserInput() {
        System.out.println("계산식을 입력하세요. (예시: 2 + 3 * 4 / 2)");
        System.out.print(">>> ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void displayResult(int result) {
        System.out.println(">>> " + result);
    }

    public int calculate(String userInput) {
        String[] split = getSplittedUserInput(userInput);

        validateUserInput(split);

        int result = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            switch (split[i]) {
                case "+":
                    result += Integer.parseInt(split[i + 1]);
                    break;
                case "-":
                    result -= Integer.parseInt(split[i + 1]);
                    break;
                case "*":
                    result *= Integer.parseInt(split[i + 1]);
                    break;
                case "/":
                    result /= Integer.parseInt(split[i + 1]);
                    break;
            }
        }

        return result;
    }

    public boolean validateUserInput(String[] userInputArr) {
        if (userInputArr.length % 2 == 0) {
            throw new RuntimeException("계산식을 다시 확인하세요.");
        }

        for (int i = 0; i < userInputArr.length; i++) {
            if (i % 2 != 0 && !operationList.contains(userInputArr[i])) {
                throw new RuntimeException("연산 기호를 바르게 입력하세요.");
            }

            if (i % 2 == 0 && isNotNumber(userInputArr[i])) {
                throw new RuntimeException("숫자를 바르게 입력하세요.");
            }
        }

        return true;
    }

    public boolean isNotNumber(String userInputArr) {
        try {
            Integer.parseInt(userInputArr);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public String[] getSplittedUserInput(String userInput) {
        return userInput.split(" ");
    }

    public static void main(String[] args){
        StringCalculator stringCalculator = new StringCalculator();
        String userInput = stringCalculator.getUserInput();
        int result = stringCalculator.calculate(userInput);
        stringCalculator.displayResult(result);
    }
}

