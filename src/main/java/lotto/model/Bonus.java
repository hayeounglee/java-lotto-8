package lotto.model;

import lotto.validator.BonusValidator;

public class Bonus {
    
    private final int bonus;

    public Bonus(int num, Lotto lotto) {
        BonusValidator bonusValidator = new BonusValidator();
        bonusValidator.validate(num, lotto);
        bonus = num;
    }

    public int getBonus() {
        return bonus;
    }
}
