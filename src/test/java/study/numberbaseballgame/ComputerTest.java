package study.numberbaseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * study.numberbaseballgame
 * NumbersTest
 *
 * @author : USER
 */
public class ComputerTest {

    @Test
    @DisplayName("컴퓨터 생성시 길이 3의 숫자 목록이 생성되어야 한다.")
    void createComputerTest() {
        // given & when
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.numbers;

        // then
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("컴퓨터가 가진 목록의 숫자는 모두 달라야 한다.")
    void checkDuplicateNumberOfComputers() {
        // given & when
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.numbers;

        // then
        assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(1));
        assertThat(computerNumbers.get(1)).isNotEqualTo(computerNumbers.get(2));
        assertThat(computerNumbers.get(0)).isNotEqualTo(computerNumbers.get(2));
    }
}
