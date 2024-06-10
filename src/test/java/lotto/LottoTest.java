package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    @DisplayName("로또 번호는 무작위로 6개 생성한다.")
    @Test
    void generateLottoNums() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getSelectedNumbers()).hasSize(6);
    }

    @DisplayName("로또의 번호는 1~45 사이의 숫자이다.")
    @Test
    void lottoNumberRange() {
        Lotto lotto = new Lotto();
        List<Integer> lottoNumbers = lotto.getSelectedNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            assertTrue(lottoNumber > 0 && lottoNumber <= 45);
        }
    }

    @DisplayName("로또 1장의 가격은 1000원이다.")
    @Test
    void getLottoPrice() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

}
