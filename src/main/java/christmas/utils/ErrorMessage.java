package christmas.utils;

public enum ErrorMessage {
    INVALID_VISIT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MAX_QUANTITY("메뉴는 한 번에 총 20개까지만 주문할 수 있습니다. 개수를 조정하여 다시 입력해주세요."),
    ONLY_DRINK_ORDER("음료만 주문 시, 주문할 수 없습니다. 음료 이외의 메뉴도 포함해서 다시 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return PREFIX + message;
    }
}
