package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GiftTest {

    @DisplayName("[SUCCESS]총금액이 기준 이상이면 1, 미만이면 0을 반환 ")
    @ParameterizedTest
    @CsvSource(value = {
            "0,0",
            "119000,0",
            "120000,1",
            "200000,1",
    })
    void countGiftByPriceAmount(int input, int expected) {
        Gift gift = new Gift(input);
        assertThat(gift.getGiftCount()).isEqualTo(expected);
    }

    @DisplayName("[SUCCESS] 증정메뉴 개수를 반환한다")
    @Test
    void getGiftMenuCountTest(){
        Gift gift = new Gift(120000);
        assertThat(gift.getGiftCount()).isEqualTo(1);
    }

    @DisplayName("[SUCCESS] 증정품을 받을 수 있을 때 증정 혜택 금액을 반환한다")
    @Test
    void getGiftBenefitPriceWhenAvailableGift(){
        Gift gift = new Gift(120000);
        assertThat(gift.getGiftBenefitPrice()).isEqualTo(25000);
    }

    @DisplayName("[SUCCESS] 증정 메뉴의 이름을 반환한다")
    @Test
    void getGiftMenuNameTest(){
        Gift gift = new Gift(120000);
        assertThat(gift.getGiftName()).isEqualTo("샴페인");
    }
}
