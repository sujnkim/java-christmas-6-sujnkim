package christmas.view;

public enum ResultTitle {
    MENU_ORDER("주문 메뉴"),
    TOTAL_PRICE("할인 전 총주문 금액"),
    GIFT_MENU("증정 메뉴"),
    BENEFIT_HISTORY("혜택 내역"),
    ALL_BENEFIT_AMOUNT("총혜택 금액"),
    EXPECTED_PAYMENT("할인 후 예상 결제 금액"),
    EVENT_BADGE("12월 이벤트 배지");

    private final String title;

    ResultTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
