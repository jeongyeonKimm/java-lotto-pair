package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 6;
    private List<Integer> numList = new ArrayList<>();
    private List<Integer> selectedNumbers;
    private final int price;

    public Lotto() {
        IntStream.rangeClosed(1, 45)
                .forEach(i -> numList.add(i));

        Collections.shuffle(numList);

        selectedNumbers = numList.subList(START_NUMBER, END_NUMBER);
        Collections.sort(selectedNumbers);
        this.price = 1000;
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    public int getPrice() {
        return price;
    }

    public String getLottoNumbers() {
        String numbers = selectedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + numbers + "]";
    }
}
