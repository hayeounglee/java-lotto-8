package lotto.constant;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        String formattedPrize = String.format("%,d", prize);
        switch (this) {
            case FIRST:
                return "6개 일치 (" + formattedPrize + "원) - ";
            case SECOND:
                return "5개 일치, 보너스 볼 일치 (" + formattedPrize + "원) - ";
            case THIRD:
                return "5개 일치 (" + formattedPrize + "원) - ";
            case FOURTH:
                return "4개 일치 (" + formattedPrize + "원) - ";
            case FIFTH:
                return "3개 일치 (" + formattedPrize + "원) - ";
            default:
                return "";
        }
    }
}
