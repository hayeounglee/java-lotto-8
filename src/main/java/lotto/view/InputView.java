package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.FormatValidator;
import lotto.validator.NumberValidator;

public class InputView {
    public int getPurchaseAmount() {
        NumberValidator numberValidator = new NumberValidator();

        System.out.println("구입금액을 입력해 주세요.");
        return numberValidator.validate(getInput());
    }

    public List<Integer> getLottoNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        String input = getInput();

        FormatValidator formatValidator = new FormatValidator();
        formatValidator.validate(input);

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        NumberValidator numberValidator = new NumberValidator();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        return numberValidator.validate(getInput());
    }

    private String getInput() {
        return Console.readLine();
    }
}
