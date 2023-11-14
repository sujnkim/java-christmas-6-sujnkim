package christmas.domain;

import christmas.domain.visitor.Visitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenefitResult {
    private static final String DISCOUNT_EMPTY = "없음";
    private static final String GIFT_EVENT = "증정 이벤트";
    private static final String DISCOUNT = " 할인";

    private final Map<String, Integer> benefits;

    public BenefitResult(Visitor visitor, Gift gift) {
        this.benefits = createDiscount(visitor, gift);
    }

    private Map<String, Integer> createDiscount(Visitor visitor, Gift gift) {
        Map<String, Integer> result = new HashMap<>();
        List<DateEvent> discounts = DateEvent
                .findApplyEventByDate(visitor.getVisitDate());

        discounts.stream()
                .filter(discount -> discount.calculateDiscount(visitor) != 0)
                .forEach(discount -> result.put(
                        createDiscountMent(discount.getEventType()),
                        discount.calculateDiscount(visitor))
                );
        return result;
    }

    private String createDiscountMent(String discountName) {
        return discountName + DISCOUNT;
    }


    public Map<String, Integer> createBenefitHistory(Gift gift) {
        Map<String, Integer> result = new HashMap<>();
        benefits.entrySet().stream()
                .forEach(discount -> result.put(discount.getKey(),discount.getValue()));

        applyGiftEventBenefit(result, gift);
        validateNoDiscount(result);
        return result;
    }

    private void applyGiftEventBenefit(Map<String, Integer> result, Gift gift) {
        if (gift.getGiftCount() != 0) {
            result.put(GIFT_EVENT, gift.getGiftBenefitPrice());
        }
    }

    private void validateNoDiscount(Map<String, Integer> result) {
        if (result.size() == 0) {
            result.put(DISCOUNT_EMPTY, 0);
        }
    }


    public int calculateAllBenefitAmount(Gift gift) {
        return calculateAllDiscounts() + gift.getGiftBenefitPrice();
    }

    private int calculateAllDiscounts() {
        return benefits.entrySet().stream()
                .map(discount -> discount.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateExpectedPayment(Visitor visitor) {
        return visitor.getTotalMenuPrice() - calculateAllDiscounts();
    }

}
