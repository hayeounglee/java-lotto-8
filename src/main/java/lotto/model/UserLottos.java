package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.validator.PurchaseAmountValidator;

public class UserLottos {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private List<UserLotto> userLottos;
    private int purchaseCount;

    public UserLottos(int purchaseAmount) {
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        purchaseAmountValidator.validate(purchaseAmount);

        userLottos = new ArrayList<>();
        purchaseCount = purchaseAmount / LOTTO_PRICE;
        generateUserLotto();
    }

    private void generateUserLotto() {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_NUMBER_COUNT);
            userLottos.add(new UserLotto(lottoNumber));
        }
    }

    public List<Result> countMatchingLotto(Lotto lotto, Bonus bonus) {
        List<Result> results = new ArrayList<>();
        for (UserLotto userLotto : userLottos) {
            int matchingCount = countMatchingNumbers(userLotto.getUserLotto(), lotto);
            boolean hasBonusNumber = containsBonusNumber(userLotto.getUserLotto(), bonus);
            results.add(new Result(matchingCount, hasBonusNumber));
        }
        return results;
    }

    private int countMatchingNumbers(List<Integer> userLotto, Lotto lotto) {
        return (int) userLotto.stream()
                .filter(lotto.getLotto()::contains)
                .count();
    }

    private boolean containsBonusNumber(List<Integer> userNumbers, Bonus bonus) {
        return userNumbers.contains(bonus.getBonus());
    }

    public List<UserLotto> getUserLottos() {
        return userLottos;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
