package christmas.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputConverterTest {

    @DisplayName("[SUCCESS]사용자가 입력한 각 날짜를 Integer로 만들어 반환한다")
    @Test
    void getVisitDateConvertTest() {
        String value = "11";
        assertThat(
                InputConverter.getDate(value)
        ).isEqualTo(11);
    }

    @DisplayName("[EXCEPTION]사용자가 입력이 콤마로 끝나는 경우 예외를 반환한다")
    @Test
    void getMenuOrderSplitCommaTest() {
        String value = "티본스테이크-1,,바비큐립-1,초코케이크-2,제로콜라-1";

        assertThatThrownBy(() -> InputConverter.getMenuOrder(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("[EXCEPTION]사용자가 입력한 각 메뉴 문자열에 '-'가 없으면 예외를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크~1", "타파스!2"})
    void getMenuOrderSplitDashTest(String input) {
        assertThatThrownBy(() -> InputConverter.getMenuOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("[EXCEPTION]메뉴를 중복으로 입력하면 예외를 반환한다")
    @Test
    void getMenuOrderDuplicationTest() {
        String value = "티본스테이크-1,티본스테이크-3";

        assertThatThrownBy(() -> InputConverter.getMenuOrder(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


    @DisplayName("[SUCCESS]사용자가 입력한 각 메뉴를 split하여 Map에 담아 반환한다")
    @Test
    void getMenuOrderAndSplit() {
        String value = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> result = new HashMap<>();
        result.put("티본스테이크", 1);
        result.put("바비큐립", 1);
        result.put("초코케이크", 2);
        result.put("제로콜라", 1);

        assertThat(
                InputConverter.getMenuOrder(value)
        ).isEqualTo(result);
    }

}