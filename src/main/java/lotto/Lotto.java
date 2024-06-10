package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int START_NUMBER = 0;
    public static final int END_NUMBER = 6;
    private List<Integer> numList = new ArrayList<>();
    private List<Integer> selectedNumbers;
    private final int price;

    public Lotto() {
        for (int i = 1; i <= 45; i++) numList.add(i);
        Collections.shuffle(numList);
        selectedNumbers = numList.subList(START_NUMBER, END_NUMBER);
        this.price = 1000;
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    public int getPrice() {
        return price;
    }
}
