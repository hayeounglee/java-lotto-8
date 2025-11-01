package lotto.validator;

import java.util.HashSet;
import lotto.constant.ErrorMessage;
import lotto.model.Lotto;

public class BonusValidator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    public void validate(int num, Lotto lotto) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_OF_RANGE.getMessage());
        }

        if (isDuplicateWithLotto(num, lotto)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }

    private boolean isDuplicateWithLotto(int bonusNumber, Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }
}
