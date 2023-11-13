package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class DateEventTest {

    @DisplayName("[SUCCESS] 해당 날짜에 적용되는 이벤트의 리스트를 반환한다")
    @Test
    void getApplyEventByDate() {
        assertThat(
                DateEvent.findApplyEventByDate(25)
        ).isEqualTo(Arrays.asList(
                DateEvent.CHRISTMAS,
                DateEvent.WEEKDAY,
                DateEvent.SPECIAL));
    }

    @DisplayName("[SUCCESS] 해당 날짜에 적용되는 디데이 할인 금액을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {
            "1,1000",
            "2,1100",
            "25,3400",
            "30,0"
    })
    void getChristmasDDayDiscountPrice(int input, int expected) {
        assertThat(
                DateEvent.getDDayDiscountPrice(input)
        ).isEqualTo(expected);
    }
}