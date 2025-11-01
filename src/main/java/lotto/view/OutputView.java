package lotto.view;

import java.util.Map;
import lotto.constant.Rank;
import lotto.model.UserLotto;
import lotto.model.UserLottos;

public class OutputView {
    public void printUserLotto(UserLottos userLottos) {
        System.out.println("\n" + userLottos.getPurchaseCount() + "개를 구매했습니다.");
        for (UserLotto userLotto : userLottos.getUserLottos()) {
            System.out.println(userLotto.getUserLotto());
        }
    }

    public void printResult(Map<Rank, Long> summary, double profitRate) {
        System.out.println("\n당첨 통계\n" + "---");

        for (Rank rank : Rank.values()) {
            long count = summary.getOrDefault(rank, 0L);
            System.out.println(rank.getDescription() + count + "개");
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
