import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.LotteryGame;
import lotto.Lotto;
import lotto.LottoFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LotteryGameTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "13000:13", "1000:1"}, delimiter = ':')
    void 금액에_알맞은_개수의_로또를_발급하는_테스트1_전액자동구매(int purchase_amount, int result) {
        //given
        //when
        LotteryGame lotteryGame1 = new LotteryGame(purchase_amount, null, null, 0);
        //then
        assertThat(lotteryGame1.getLotteries().size()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:3:10", "13000:3:13", "1000:1:1"}, delimiter = ':')
    void 금액에_알맞은_개수의_로또를_발급하는_테스트2_일부자동구매(int purchase_amount, int count, int result) {
        //given
        //when
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteries.add(LottoFactory.createLotto());
        }
        LotteryGame lotteryGame = new LotteryGame(purchase_amount, lotteries, null, 0);
        //then
        assertThat(lotteryGame.getLotteries().size()).isEqualTo(result);
        for (Lotto lotto : lotteries) {
            assertThat(lotteryGame.getLotteries().contains(lotto)).isTrue();
        }
    }
}
