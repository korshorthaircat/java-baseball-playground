package study.numberbaseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * study.numberbaseballgame
 * RuleTest
 *
 * @author : USER
 */
class RuleTest {
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "943", "463", "578"})
    @DisplayName("사용자입력 문자열 유효성 검사 통과 케이스")
    void validateSuccessTest(String userInput) {
        // given & when
        Rule rule = new Rule();
        boolean result = rule.validate(userInput);

        // then
        assertThat(result).isTrue();
    }

    @Nested
    @DisplayName("사용자입력 문자열 유효성 검사 실패 케이스")
    class ValidateFailCase {
        @ParameterizedTest
        @ValueSource(strings = {"122", "433", "999", "771", "575"})
        @DisplayName("중복 숫자가 포함된 경우")
        void ValidateFailCase1(String userInput) {
            // given
            Rule rule = new Rule();

            // then
            Throwable exception = assertThrows(RuntimeException.class, () -> {
                rule.validate(userInput);
            });
            assertThat("중복 없이 입력하세요.").isEqualTo(exception.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"012", "a34", "54d", "390", "0f8", "kfc"})
        @DisplayName("문자 또는 0이 포함된 경우")
        void ValidateFailCase2(String userInput) {
            // given
            Rule rule = new Rule();

            // then
            Throwable exception = assertThrows(RuntimeException.class, () -> {
                rule.validate(userInput);
            });
            assertThat("0을 제외한 숫자만 입력하세요.").isEqualTo(exception.getMessage());
        }
    }


    @Nested
    @DisplayName("사용자입력 문자열과 컴퓨터 숫자값을 비교한다.")
    class CompareSuccessCase {
        @Test
        void CompareSuccessCase0() {
            // given
            Rule rule = new Rule();
            List<Integer> computerNumbers = List.of(4, 2, 5);
            String userInput = "789";

            // when
            Status status = rule.compareNumbers(computerNumbers, userInput);

            // then
            assertThat(status.getNoBallCount()).isEqualTo(3);
        }

        @Test
        void CompareSuccessCase1() {
            // given
            Rule rule = new Rule();
            List<Integer> computerNumbers = List.of(4, 2, 5);
            String userInput = "123";

            // when
            Status status = rule.compareNumbers(computerNumbers, userInput);

            // then
            assertThat(status.getStrikeCount()).isEqualTo(1);
        }

        @Test
        void CompareSuccessCase2() {
            // given
            Rule rule = new Rule();
            List<Integer> computerNumbers = List.of(4, 2, 5);
            String userInput = "456";

            // when
            Status status = rule.compareNumbers(computerNumbers, userInput);

            // then
            assertThat(status.getStrikeCount()).isEqualTo(1);
            assertThat(status.getBallCount()).isEqualTo(1);
        }

        @Test
        void CompareSuccessCase3() {
            // given
            Rule rule = new Rule();
            List<Integer> computerNumbers = List.of(4, 2, 5);
            String userInput = "425";

            // when
            Status status = rule.compareNumbers(computerNumbers, userInput);

            // then
            assertThat(status.getStrikeCount()).isEqualTo( 3);
        }
    }

    @Test
    @DisplayName("게임 종료 여부 확인")
    void checkGameEndTest() {
        // given
        Rule rule = new Rule();
        Status status = new Status(3, 0, 0);

        // when
        rule.checkGameEnd(status);

        assertThat(rule.gameEnd).isTrue();
    }
}