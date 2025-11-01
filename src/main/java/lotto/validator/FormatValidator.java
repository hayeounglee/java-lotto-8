package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class FormatValidator {
    private static final String LOTTO_NUMBER_REGEX = "^\\d{1,2}(,\\d{1,2}){5}$";

    public void validate(String input) {
        if (!input.matches(LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_FORM.getMessage());
        }

        List<Integer> lotto = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
