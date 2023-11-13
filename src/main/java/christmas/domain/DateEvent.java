package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum DateEvent {

    CHRISTMAS("크리스마스 디데이", DateConstant.CHRISTMAS_DDAYS) {
        @Override
        int calculateDiscount(Visitor visitor) {
            return 1000 + (visitor.getVisitDate() - 1) * 100;
        }
    },
    WEEKDAY("평일", DateConstant.WEEKDAYS) {
        @Override
        int calculateDiscount(Visitor visitor) {
            int count = calculateCategoryMenuCount(
                    visitor,
                    MenuCategory.DESSERT);
            return count * WEEKEND_DISCOUNT_PRICE;
        }
    },
    WEEKEND("주말", DateConstant.WEEKENDS) {
        @Override
        int calculateDiscount(Visitor visitor) {
            int count = calculateCategoryMenuCount(
                    visitor,
                    MenuCategory.MAIN);
            return count * WEEKEND_DISCOUNT_PRICE;
        }
    },
    SPECIAL("특별", DateConstant.SPECIAL_DAYS) {
        @Override
        int calculateDiscount(Visitor visitor) {
            return SPECIAL_DISCOUNT_PRICE;
        }
    };

    private static final int WEEKEND_DISCOUNT_PRICE = 2023;
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;

    private final String eventType;
    private final List<Integer> days;

    DateEvent(String eventType, List<Integer> days) {
        this.eventType = eventType;
        this.days = days;
    }

    abstract int calculateDiscount(Visitor visitor);

    private static int calculateCategoryMenuCount(
            Visitor visitor,
            MenuCategory category
    ){
        return MenuCategory.calculateMenuQuantityByCategory(
                visitor.getMenuOrder(),
                category
        );
    }

    public static List<DateEvent> findApplyEventByDate(int visitDate) {
        return Arrays.stream(DateEvent.values())
                .filter(discount -> discount.days.contains(visitDate))
                .toList();
    }

    public String getEventType() {
        return eventType;
    }
}
