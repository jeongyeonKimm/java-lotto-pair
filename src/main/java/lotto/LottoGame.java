package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int WINNING_COUNT_LENGTH = 8;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] winningCount;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.winningNumbers = new ArrayList<>();
        this.bonusNumber = 0;
        this.winningCount = new int[WINNING_COUNT_LENGTH];
    }

    public void run() {
        int purchasePrice = InputView.inputPurchasePrice();
        int lottoTryCount = getLottoTryCount(purchasePrice);
        lottos = generateLottos(lottoTryCount);
        winningNumbers = InputView.inputWinningNumbers();
        bonusNumber = InputView.inputBonusNumber();
        matchLottos();
        OutputView.printStatistics(winningCount, purchasePrice);

    }

    public int getLottoTryCount(int purchasePrice){
        int tryCount = purchasePrice / LOTTO_PRICE;
        OutputView.printMessage(tryCount, "개를 구매했습니다.");
        return tryCount;
    }

    private void matchLottos() {
        boolean matchBonus = false;
        int matchCount = 0;
        for (Lotto lotto : lottos) {
            matchCount = match(lotto);
            if (matchCount == 5) {
                matchBonus = matchBonus(lotto);
            }

            makeWinningStatistics(matchBonus, matchCount);
        }
    }


    public int match(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getSelectedNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getSelectedNumbers().contains(bonusNumber);
    }

    private static List<Lotto> generateLottos(int lottoTryCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTryCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputView.printMessage(lotto.getLottoNumbers());
        }
        return lottos;
    }


    private void makeWinningStatistics(boolean matchBonus, int matchCount) {
        if ((matchCount == 5 && matchBonus) || matchCount == 6) {
            winningCount[matchCount + 1]++;
            return;
        }

        winningCount[matchCount]++;
    }
}
