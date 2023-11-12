package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.domain.Menu.MUSHROOM_SOUP;
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
    @Test
    void findMenuByName() {;
        assertThat(Menu.findMenuByName("양송이수프")).isEqualTo(MUSHROOM_SOUP);
    }
}


