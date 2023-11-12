package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuOrderTest {
    Map<String, Integer> menus = new HashMap<String, Integer>();

    @BeforeEach
    void setUp() {
        menus.put("양송이스프", 1);
        menus.put("티본스테이크", 1);
        menus.put("바비큐립", 2);
        menus.put("초코케이크", 3);
        menus.put("아이스크림", 4);
        menus.put("제로콜라", 5);
    }

    @DisplayName("[Exception] 메뉴의 수량이 1개보다 작은 경우 예외 발생")
    @Test
    void createMenuOrderByInvalidCount() {
        menus.put("타파스", 0);

        assertThatThrownBy(() -> new MenuOrder(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


}
