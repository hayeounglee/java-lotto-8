package lotto.validator;

import lotto.constant.ErrorMessage;

public class PurchaseAmountValidator {
    private static final int LOTTO_PRICE = 1000;

    public void validate(int input) {
        if (input % LOTTO_PRICE != 0 || input <= 0) {
            throw new IllegalArgumentException(ErrorMessage.USER_LOTTO_PRICE.getMessage());
        }
    }
}
