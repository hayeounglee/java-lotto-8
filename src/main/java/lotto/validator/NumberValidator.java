package lotto.validator;

import lotto.constant.ErrorMessage;

public class NumberValidator {
    public int validate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORM.getMessage());
        }
    }
}
