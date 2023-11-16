package christmas.domain;

import christmas.domain.plan.Menu;

public class Gift {
    private final static int GIFT_OFFER_LEAST_PRICE = 120000;
    private final static Menu GIFT_MENU = Menu.CHAMPAGNE;

    private final int count;

    public Gift(int totalPrice) {
        this.count = createGift(totalPrice);
    }

    private int createGift(int totalPrice) {
        if (totalPrice >= GIFT_OFFER_LEAST_PRICE) {
            return 1;
        }
        return 0;
    }

    public int getGiftCount() {
        return count;
    }

    public int getGiftBenefitPrice() {
        return GIFT_MENU.getMenuPriceSum(this.count);
    }

    public String getGiftName(){
        return GIFT_MENU.getMenuName();
    }

}
