package christmas.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {

    @DisplayName("[EXCEPTION]Menu에 없는 이름으로 메뉴를 찾으려고 할 때 예외가 발생")
    @Test
    void findMenuByInvalidName() {
        assertThatThrownBy(() -> Menu.findMenuByName("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("[SUCCESS]Menu에 해당 이름을 가진 메뉴가 있으면 Menu를 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "양송이수프,MUSHROOM_SOUP",
            "티본스테이크,T_BONE_STEAK"
    })
    void findMenuByName(String input, Menu expected) {
        assertThat(Menu.findMenuByName(input)).isEqualTo(expected);
    }

    @DisplayName("[SUCCESS]한 메뉴의 여러개 가격합을 반환")
    @ParameterizedTest
    @CsvSource(value = {
            "MUSHROOM_SOUP,1,6000",
            "SEAFOOD_PASTA,2,70000",
            "CHAMPAGNE,1,25000"
    })
    void checkGetMenuPriceByMenuName(Menu input, int count, int expected) {
        assertThat(input.getMenuPriceSum(count)).isEqualTo(expected);
    }
}


