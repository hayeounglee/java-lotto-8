package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class LottoValidator {
    public void validate(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }

        if (new HashSet<>(lotto).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }

        boolean invalidRange = lotto.stream().anyMatch(n -> n < 1 || n > 45);
        if (invalidRange) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }
    }
}
