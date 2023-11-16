package christmas.domain;

import christmas.domain.visitor.MenuOrder;
import christmas.domain.visitor.VisitDate;
import christmas.domain.visitor.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class DateEventTest {
    Visitor visitor;

    @BeforeEach
    void setUp() {
        VisitDate visitDate = new VisitDate(25);
        Map<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("양송이수프", 1);
        menus.put("티본스테이크", 2);
        menus.put("초코케이크", 3);
        visitor = new Visitor(visitDate, new MenuOrder(menus));
    }

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

    @DisplayName("[SUCCESS]해당 고객에게 적용되는 크리스마스 디데이 할인가를 반환")
    @Test
    void calculateChristmasDDAyDiscount() {
        assertThat(DateEvent.CHRISTMAS.calculateDiscount(visitor))
                .isEqualTo(3400);
    }

    @DisplayName("[SUCCESS]해당 고객에게 적용되는 주중 할인가를 반환")
    @Test
    void calculateWeekDayDiscount() {
        assertThat(DateEvent.WEEKDAY.calculateDiscount(visitor))
                .isEqualTo(3 * 2023);
    }

    @DisplayName("[SUCCESS]해당 고객에게 적용되는 주중 할인가를 반환")
    @Test
    void calculateWeekendDiscount() {
        assertThat(DateEvent.WEEKEND.calculateDiscount(visitor))
                .isEqualTo(2 * 2023);
    }
}
