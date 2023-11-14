package christmas.domain.visitor;

import christmas.domain.visitor.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class VisitDateTest {

    @DisplayName("[EXCEPTION] 날짜 범위가 1부터 31까지에 속하지 않는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32})
    void createVisitDateByInvalidRangeDate(int input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}
