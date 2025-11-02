package lotto.model;

import lotto.constant.Rank;

public class Result {
    private final Rank rank;

    public Result(int matchCount, boolean hasBonus) {
        rank = Rank.of(matchCount, hasBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
