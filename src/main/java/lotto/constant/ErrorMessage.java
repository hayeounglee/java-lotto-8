package lotto.constant;

public enum ErrorMessage {
    INVALID_FORM("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    USER_LOTTO_PRICE("로또 한 장 가격은 1000원 입니다. 올바른 금액을 입력해주세요."),
    LOTTO_FORM("로또 번호 형식이 올바르지 않습니다. (예: 1,2,3,4,5,6)"),
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_OUT_OF_RANGE("로또 번호는 1~45사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE("로또 번호는 중복되면 안됩니다."),
    BONUS_OUT_OF_RANGE("보너스 번호는 1~45사이의 숫자여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 로또 번호와 중복되면 안됩니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
