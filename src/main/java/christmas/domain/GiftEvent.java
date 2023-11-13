package christmas.domain;

public class GiftEvent {
    private static Menu gift = Menu.CHAMPAGNE;
    private static int GIFT_OFFER_LEAST_PRICE = 120000;

    private int count;

    public GiftEvent(int totalPrice) {
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

}
