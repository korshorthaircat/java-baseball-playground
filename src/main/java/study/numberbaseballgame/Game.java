package study.numberbaseballgame;

/**
 * study.numberbaseballgame
 * Game
 *
 * @author : USER
 */
public class Game {
    public static void main(String[] args){
      play();
    }

    private static void play() {
        Rule rule = new Rule();
        Computer computer = new Computer();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        while (!rule.gameEnd) {
            inputView.showGameProcessMessage();

            String userInput = "";
            try {
                userInput = inputView.getUserInput();
                rule.validate(userInput);
            } catch (RuntimeException e) {
                inputView.showErrorMessage(e);
                continue;
            }

            Status status = rule.compareNumbers(computer.getNumbers(), userInput);
            rule.checkGameEnd(status);

            String resultMessage = resultView.generateResultMessage(status);
            resultView.showResultMessage(resultMessage);
        }
        resultView.showGameEndMessage();
    }
}
