package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class DateDiscountTest {

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
}