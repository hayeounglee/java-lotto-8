package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.NumberValidator;

public class InputView {
    public int getPurchaseAmount() {
        NumberValidator numberValidator = new NumberValidator();

        System.out.println("구입금액을 입력해 주세요.");
        return numberValidator.validate(getInput());
    }

    public List<String> getLottoNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Arrays.asList(getInput().split(","));
    }

    public String getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return getInput();
    }

    private String getInput() {
        return Console.readLine();
    }

}
