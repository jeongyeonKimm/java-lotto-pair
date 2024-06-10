package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("로또의 개수를 계산한다")
    @ParameterizedTest
    @ValueSource(ints = {5000,10000,15000,14500})
    void getLottoTryCount(final int purchasePrice) {
        // given
        LottoGame lottoGame = new LottoGame();
        // when
        int actual = lottoGame.getLottoTryCount(purchasePrice);
        int expected = purchasePrice / 1000;
        // then
        assertThat(actual).isEqualTo(expected);
    }

}
