package lotto;

public class LottoGame {


    public static final int LOTTO_PRICE = 1000;

    public int getLottoTryCount(int purchasePrice){
        return purchasePrice / LOTTO_PRICE;
    }

}
