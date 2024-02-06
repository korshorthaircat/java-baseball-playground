package study.numberbaseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * study.numberbaseballgame
 * Rule
 *
 * @author : USER
 */
public class Rule {
    boolean gameEnd;

    /**
     * validate
     * <pre>
     * 사용자의 입력값의 유효성 검사
     * 1. 입력 값이 세 자리인지 확인한다.
     * 2. 입력 값에 중복이 있는지 확인한다.
     * 3. 입력 값이 모두 숫자인지 확인한다.
     * </pre>
     * @param userInput 사용자입력
     * @return
     */
    public boolean validate(String userInput) {
        char[] chars = userInput.toCharArray();

        if (0 == chars.length || chars.length > 3) {
            throw new RuntimeException("세 자리를 입력하세요.");
        }

        Set<Character> uniqueSet = new HashSet<>();
        for (char c : chars) {
            if (!uniqueSet.add(c)) {
                throw  new RuntimeException("중복 없이 입력하세요.");
            }

            if (c == '0' || !Character.isDigit(c)) {
                throw new RuntimeException("0을 제외한 숫자만 입력하세요.");
            }
        }

        return true;
    }

    /**
     * compareNumbers
     * <pre>
     * 컴퓨터가 선택한 임의의 수와 사용자 입력값을 비교한다.
     * </pre>
     * @param computerNumbers 컴퓨터가 선택한 임의의 수 list
     * @param userInput 사용자입력
     * @return 상태(스트라이크카운트, 볼카운트, 노볼카운트)
     */
    public Status compareNumbers(List<Integer> computerNumbers, String userInput) {
        char[] userInputArr = userInput.toCharArray();
        List<Integer> userNumbers = new ArrayList<>();
        for (char c : userInputArr) {
            userNumbers.add(Character.getNumericValue(c));
        }

        int strikeCount = 0, ballCount = 0, noBallCount = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            Integer computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
            }

            if (userNumber != computerNumber && computerNumbers.contains(userNumber)) {
                ballCount++;
            }

            if (!computerNumbers.contains(userNumber)) {
                noBallCount++;
            }
        }

        return new Status(strikeCount, ballCount, noBallCount);
    }

    /**
     * checkGameEnd
     * <pre>
     * 게임 종료 여부를 변경한다.
     * </pre>
     * @param status
     */
    public void checkGameEnd(Status status) {
        this.gameEnd = status.getStrikeCount() == 3;
    }
}
