package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PRINT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchasePrice(){
        OutputView.printMessage(PRINT_PURCHASE_PRICE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbers(){
        OutputView.printMessage(PRINT_WINNING_NUMBERS);
        String numbers = scanner.nextLine();

        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber(){
        OutputView.printMessage(PRINT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }


}
