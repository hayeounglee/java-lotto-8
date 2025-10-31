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

    public void generateResults() {
        results = userLottos.countMatchingLotto(lotto, bonus);
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
}
