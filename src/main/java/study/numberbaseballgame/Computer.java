package study.numberbaseballgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * study.numberbaseballgame
 * Conputer
 *
 * @author : USER
 */
public class Computer {
    public List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Computer() {
        generateNumbers();
    }

    private void generateNumbers() {
        ArrayList<Integer> oneToNineList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            oneToNineList.add(i);
        }
        Collections.shuffle(oneToNineList);

        this.numbers = oneToNineList.subList(0, 3);
    }
}
