package christmas.domain.result;

import christmas.domain.Menu;

public class Gift {
    private final static int GIFT_OFFER_LEAST_PRICE = 120000;
    private final static Menu gift = Menu.CHAMPAGNE;

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
        return gift.getMenuPriceSum(this.count);
    }

    public String getGiftName(){
        return gift.getMenuName();
    }

}
