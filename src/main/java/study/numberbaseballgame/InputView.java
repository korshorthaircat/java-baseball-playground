package study.numberbaseballgame;

import java.util.Scanner;

/**
 * study.numberbaseballgame
 * InputView
 *
 * @author : USER
 */
public class InputView {
    public void showGameProcessMessage() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showErrorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
