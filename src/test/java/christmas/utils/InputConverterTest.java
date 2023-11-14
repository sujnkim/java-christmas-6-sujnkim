package christmas.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputConverterTest {

    @DisplayName("[SUCCESS]사용자가 입력한 각 날짜를 Integer로 만들어 반환한다")
    @Test
    void getVisitDateConvertTest(){
        String value = "11";
        assertThat(
                InputConverter.getDate(value)
        ).isEqualTo(11);
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