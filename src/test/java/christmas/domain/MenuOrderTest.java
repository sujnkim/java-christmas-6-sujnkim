package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuOrderTest {
    Map<String, Integer> menus = new HashMap<String, Integer>();

    @BeforeEach
    void setUp() {
        menus.put("양송이수프", 1);
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

    @DisplayName("[Exception] 판매하는 메뉴가 아닌 경우 예외 발생")
    @Test
    void createMenuOrderByInvalidMenu() {
        menus.put("a", 1);
        assertThatThrownBy(() -> new MenuOrder(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("[Exception] 주문 메뉴 총수량이 20개를 넘어가는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {20, 5})
    void validateMenuQuantityStandard(int input) {
        menus.put("타파스", input);
        assertThatThrownBy(() -> new MenuOrder(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 한 번에 총 20개까지만 주문할 수 있습니다. 개수를 조정하여 다시 입력해주세요.");
    }

    @DisplayName("[Exception] 음료에 해당하는 메뉴만 주문하는 경우 예외 발생")
    @Test
    void validateMenuTypeConditionHasOnlyDrink() {
        Map<String, Integer> onlyDrink = new HashMap<String, Integer>();
        menus.put("제로콜라", 1);

        assertThatThrownBy(() -> new MenuOrder(onlyDrink))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 음료 이외의 메뉴도 포함해서 다시 입력해주세요.");
    }

    @DisplayName("[SUCCESS] 주문한 메뉴의 총주문 금액을 반환한다")
    @Test
    void getSumOfMenusOrdered(){
        Map<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("양송이수프", 1);
        menus.put("시저샐러드", 1);

        MenuOrder order = new MenuOrder(menus);
        assertThat(order.calculateTotalMenuPrice()).isEqualTo(14000);
    }

}
