package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NOTHING("없음", 0);

    private final String badgeName;
    private final int standardPrice;

    Badge(String badgeName, int standardPrice) {
        this.badgeName = badgeName;
        this.standardPrice = standardPrice;
    }

    public static Badge getBadgeByBenefitPrice(int benefitAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.standardPrice <= benefitAmount)
                .sorted()
                .toList().get(0);
    }
}
