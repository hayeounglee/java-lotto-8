package lotto.model;

public class Bonus {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    private final int bonus;

    public Bonus(int num, Lotto lotto) {
        bonus = num;
    }

    public int getBonus() {
        return bonus;
    }
}
