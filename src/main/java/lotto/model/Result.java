package lotto.model;

import lotto.constant.Rank;

public class Result {
    private final int matchCount;
    private final boolean hasBonus;
    private final Rank rank;

    public Result(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.rank = Rank.of(matchCount, hasBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
