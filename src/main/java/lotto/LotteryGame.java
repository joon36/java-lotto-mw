package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LotteryGame {

    private List<Lotto> lotteries;
    private List<Integer> winningNumbers;
    private Integer bonus;


    public LotteryGame(int purchase_amount, List<Lotto> lotteries, List<Integer> winningNumbers,
        Integer bonus) {
        this.lotteries = (lotteries == null) ? new ArrayList<>() : lotteries;

        IntStream.range(0, (purchase_amount / 1000) - this.lotteries.size())
            .forEach(i -> this.lotteries.add(LottoFactory.createLotto()));

        this.winningNumbers = winningNumbers;
        this.bonus = bonus;

    }

    public List<Lotto> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
