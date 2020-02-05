package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final Random RANDOM = new Random();
    private static final Integer CRITERION = 45; //랜덤값의 기준

    public static Lotto createLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(0, 6)
            .forEach(i -> randomNumbers.add(createRandomNumber()));
        return new Lotto(randomNumbers);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static Integer createRandomNumber() {
        return RANDOM.nextInt(CRITERION) + 1;
    }
}
