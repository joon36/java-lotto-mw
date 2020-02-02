package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    //입력 받은 number List 의 마지막 숫자는 보너스
    Lotto(List<Integer> numbers){
        this.numbers = numbers.subList(0,numbers.size()-1);
        this.bonusNumber = numbers.get(numbers.size()-1);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
