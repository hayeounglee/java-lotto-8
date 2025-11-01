package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.Rank;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.UserLottos;

public class LottoService {
    private UserLottos userLottos;
    private Lotto lotto;
    private Bonus bonus;
    private List<Result> results;
    private int purchaseAmount;

    public Map<Rank, Long> summarizeResults() {
        getResult();
        return results.stream()
                .collect(Collectors.groupingBy(Result::getRank, Collectors.counting()));
    }

    public void getResult() {
        results = userLottos.countMatchingLotto(lotto, bonus);
    }

    public double calculateProfitRate() {
        long totalPrize = results.stream()
                .mapToLong(result -> result.getRank().getPrize())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public void generateUserLottos(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        userLottos = new UserLottos(purchaseAmount);
    }

    public UserLottos getUserLottos() {
        return userLottos;
    }

    public void generateLotto(Lotto lottoInput) {
        lotto = lottoInput;
    }

    public void generateBonus(int bonusInput) {
        bonus = new Bonus(bonusInput, lotto);
    }

    public Lotto getLotto() {
        return lotto;
    }
}
