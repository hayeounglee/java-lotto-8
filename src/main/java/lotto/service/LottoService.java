package lotto.service;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.UserLottos;

public class LottoService {
    private UserLottos userLottos;
    private Lotto lotto;
    private Bonus bonus;
    private List<Result> result;

    public List<Result> getWinningResult() {
        result = userLottos.countMatchingLotto(lotto, bonus);
        return result;
    }

    public float getProfitRate() {

    }
}
