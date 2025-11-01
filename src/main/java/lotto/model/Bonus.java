package lotto.model;

public class Bonus {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final int bonus;

    public Bonus(int num, Lotto lotto) {
        bonus = num;
    }

    public int getBonus() {
        return bonus;
    }
}
