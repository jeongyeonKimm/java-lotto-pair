package lotto;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchasePrice = InputView.inputPurchasePrice();
        int lottoTryCount = getLottoTryCount(purchasePrice);
        for (int i = 0; i < lottoTryCount; i++) {
            Lotto lotto = new Lotto();
            OutputView.printMessage(lotto.getLottoNumbers());
        }
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
    }

    public int getLottoTryCount(int purchasePrice){
        int tryCount = purchasePrice / LOTTO_PRICE;
        OutputView.printMessage(tryCount, "개를 구매했습니다.");
        return tryCount;
    }

}
