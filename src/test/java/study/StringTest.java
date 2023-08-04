package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * String 클래스에 대한 학습 테스트
 * - 목표
 *  - 단위테스트 도구 사용법 학습
 *  - 사용하는 API에 대한 학습 효과
 */
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*
    요구사항 1
    "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    힌트
    배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */
    @Test
    void split() {
        String[] splitA = "1,2".split(",");
        String[] splitB = "1".split(",");

        assertThat(splitA).containsExactly("1", "2");
        assertThat(splitB).contains("1");
    }

    /*
    요구사항 2
    "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void substring() {
        String actual = "(1,2)";
        String substringA = actual.substring(0);
        String substringB = actual.substring(1, 4);

        assertThat(substringA).isEqualTo("(1,2)");
        assertThat(substringB).isEqualTo("1,2");
        assertThatThrownBy(() -> {actual.substring(1, 10);})
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("begin 1, end 10, length 5");
    }

    /*
    요구사항 3
    "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("charAt() - 특정 위치의 문자를 가져온다.")
    void charAt() {
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() - 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtOutOfBoundsException() {
        String actual = "abc";

        assertThatThrownBy(() -> {actual.charAt(10);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 10");
    }
}
