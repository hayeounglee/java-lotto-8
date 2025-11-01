package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator();
        lottoValidator.validate(numbers);
        lotto = numbers;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
