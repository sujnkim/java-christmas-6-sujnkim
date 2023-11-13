package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @DisplayName("[SUCCESS] 혜택 금액에 알맞은 배지를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {
            "0,NOTHING",
            "4900,NOTHING",
            "5000,STAR",
            "9900,STAR",
            "10000,TREE",
            "19999,TREE",
            "20000,SANTA",
            "20001,SANTA"
    })
    void getProperBadgeByBenefitAmout(int benefitPrice, Badge expected) {
        assertThat(
                Badge.getBadgeByBenefitPrice(benefitPrice)
        ).isEqualTo(expected);
    }
}