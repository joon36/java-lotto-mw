import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.LottoFactory;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @Test
    void 자동_로또_생성_테스트(){
        //given
        //when
        Lotto lotto = LottoFactory.createLotto();
        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getBonusNumber() <= 45).isTrue();
        assertThat(lotto.getBonusNumber() >= 1).isTrue();

    }

    @Test
    void 수동_로또_생성_테스트(){
        //given
        //when
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        Lotto lotto = LottoFactory.createLotto(numbers);
        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getBonusNumber()).isEqualTo(7);
    }
}
