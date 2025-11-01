package lotto.model;

import java.util.List;

public class UserLotto {
    private final List<Integer> userLotto;

    public UserLotto(List<Integer> userNumber) {
        userLotto = userNumber.stream().sorted().toList();
    }

    public List<Integer> getUserLotto() {
        return userLotto;
    }
}
