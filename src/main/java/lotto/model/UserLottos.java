package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class UserLottos {
    private static final int LOTTO_PRICE = 1000;

    private List<UserLotto> userLottos;
    private int purchaseCount;

    public UserLottos(int purchaseAmount) {
        userLottos = new ArrayList<>();
        purchaseCount = purchaseAmount / LOTTO_PRICE;
        generateUserLotto();
    }

    private void generateUserLotto() {
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottos.add(new UserLotto(lottoNumber));
        }
    }
}
