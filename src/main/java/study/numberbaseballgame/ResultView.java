package study.numberbaseballgame;

/**
 * study.numberbaseballgame
 * ResultView
 *
 * @author : USER
 */
public class ResultView {
    public String generateResultMessage(Status status) {
        int strikeCount = status.getStrikeCount();
        int ballCount = status.getBallCount();
        int noBallCount = status.getNoBallCount();

        if (noBallCount == 3) {
            return "낫싱";
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (strikeCount != 0) {
            stringBuilder.append(strikeCount + "스트라이크 ");
        }

        if (ballCount != 0) {
            stringBuilder.append(ballCount + "볼 ");
        }

        return stringBuilder.toString();
    }

    public void showResultMessage(String gameResult) {
        System.out.println(gameResult);
    }

    public void showGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
