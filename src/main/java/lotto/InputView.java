package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPurchasePrice(){
        return scanner.nextInt();
    }

    public List<Integer> inputWinningNumbers(){
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i = 0; i < 6; ++i){
            winningNumbers.add(scanner.nextInt());
        }
        return winningNumbers;
    }

    public int inputBonusNumber(){
        return scanner.nextInt();
    }


}
