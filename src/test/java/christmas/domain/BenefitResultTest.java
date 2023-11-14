package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class BenefitResultTest {
    Visitor visitor;
    BenefitResult benefitResult;
    Gift gift;

    @BeforeEach
    void setUp() {
        VisitDate visitDate = new VisitDate(3);
        Map<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("티본스테이크", 1);
        menus.put("바비큐립", 1);
        menus.put("초코케이크", 2);
        menus.put("제로콜라", 1);
        visitor = new Visitor(visitDate, new MenuOrder(menus));
        gift = new Gift(visitor.getTotalMenuPrice());
        benefitResult = new BenefitResult(visitor, gift);
    }

    @DisplayName("[SUCCESS] 혜택 내역을 담은 결과물을 반환한다")
    @Test
    void successCreateBenefitHistory() {
        Map<String, Integer> result = new HashMap<>();
        result.put("크리스마스 디데이 할인", 1200);
        result.put("평일 할인", 4046);
        result.put("특별 할인", 1000);
        result.put("증정 이벤트", 25000);

        assertThat(
                benefitResult.createBenefitHistory(gift)
        ).isEqualTo(result);
    }

    @DisplayName("[SUCCESS] 혜택 내역이 없는 경우 없음과 0을 반환한다")
    @Test
    void createBenefitHistoryWhenNoBenefit() {
        VisitDate visitDate = new VisitDate(28);
        Map<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("티본스테이크", 1);
        Visitor visitor = new Visitor(visitDate, new MenuOrder(menus));
        gift = new Gift(visitor.getTotalMenuPrice());
        benefitResult = new BenefitResult(visitor, gift);

        Map<String, Integer> result = new HashMap<>();
        result.put("없음", 0);

        assertThat(
                benefitResult.createBenefitHistory(gift)
        ).isEqualTo(result);
    }


    @DisplayName("[SUCCESS] 총혜택 금액을 반환한다")
    @Test
    void successToCalculateAllBenefitsAmount() {
        assertThat(
                benefitResult.calculateAllBenefitAmount(gift)
        ).isEqualTo(31246);
    }

    @DisplayName("[SUCCESS] 할인 후 예상 결제 금액을 계산한다")
    @Test
    void successToCalculateExpectedPayment() {
        assertThat(
                benefitResult.calculateExpectedPayment(visitor)
        ).isEqualTo(135754);
    }
}
