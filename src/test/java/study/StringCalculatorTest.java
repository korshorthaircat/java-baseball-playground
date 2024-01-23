package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 단위 테스트 실습 - 문자열 계산기
 */
public class StringCalculatorTest {
    @Test
    void 사용자입력_분할() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String userinPut = "2 + 3 * 4 / 2";

        // when
        String[] splittedUserInput = stringCalculator.getSplittedUserInput(userinPut);

        // then
        assertThat(splittedUserInput).isEqualTo(new String[]{"2", "+", "3", "*", "4", "/", "2"});
    }

    @Test
    void 사용자입력_분할_유효성체크_성공() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String[] splittedUserInput = {"2", "+", "3", "*", "4", "/", "2"};

        // when
        boolean result = stringCalculator.validateUserInput(splittedUserInput);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 사용자입력_분할_유효성체크_완성된식이아닐때_실패() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String[] splittedUserInput = {"2", "+", "3", "*", "4", "/"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.validateUserInput(splittedUserInput)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 사용자입력_분할_유효성체크_수가연속으로나올때_실패() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String[] splittedUserInput = {"2", "3", "+", "3", "*", "4", "/"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.validateUserInput(splittedUserInput)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력값_숫자여부_확인() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String str = "5";

        // when
        boolean notNumber = stringCalculator.isNotNumber(str);

        assertThat(notNumber).isFalse();
    }

    @Test
    void 계산() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        String userInput = "2 + 3 * 4 / 2";

        // when
        int answer = stringCalculator.calculate(userInput);

        // then
        assertThat(answer).isEqualTo(10);
    }
}
