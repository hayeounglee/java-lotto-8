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

    public LottoService() {
    }


    public Map<Rank, Long> summarizeResults() {
        generateResults();
        return results.stream()
                .collect(Collectors.groupingBy(Result::getRank, Collectors.counting()));
    }

    public double calculateProfitRate(int totalPurchaseAmount) {
        long totalPrize = results.stream()
                .mapToLong(result -> result.getRank().getPrize())
                .sum();
        return (double) totalPrize / totalPurchaseAmount * 100;
    }

    public void generateUserLottos(int purchaseAmount) {
        userLottos = new UserLottos(purchaseAmount);
    }

    public void generateResults() {
        results = userLottos.countMatchingLotto(lotto, bonus);
    }

    public UserLottos getUserLottos() {
        return userLottos;
    }

    public void generateLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void generateBonus(int number) {
        bonus = new Bonus(number, lotto);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public List<Result> getResults() {
        return results;
    }
}
