package christmas.domain.plan;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MenuCategoryTest {
    EnumMap<Menu, Integer> orders = new EnumMap<>(Menu.class);

    @BeforeEach
    void setUp() {
        orders.put(Menu.MUSHROOM_SOUP, 1);
        orders.put(Menu.T_BONE_STEAK, 1);
        orders.put(Menu.BARBECUE_RIB, 2);
        orders.put(Menu.CHOCOLATE_CAKE, 3);
        orders.put(Menu.ICE_CREAM, 4);
        orders.put(Menu.ZERO_COKE, 5);
    }

    @DisplayName("[SUCCESS] 특정 메뉴가 포함되는 카테고리를 반환한다")
    @Test
    void findCategoryByMenuTest() {
        assertThat(MenuCategory.findCategoryByMenu(Menu.CHAMPAGNE))
                .isEqualTo(MenuCategory.DRINK);
    }

    @DisplayName("[SUCCESS]주문 메뉴들이 주어졌을 때 특정 카테고리에 포함되는 메뉴의 수량합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {
            "MAIN,3",
            "DESSERT,7"
    })
    void calculateMainMenuCount(MenuCategory input, int expected) {
        assertThat(MenuCategory
                .calculateMenuQuantityByCategory(orders, input)
        ).isEqualTo(expected);
    }


    @DisplayName("[SUCCESS]주문 메뉴들이 주어졌을 때 음료 카테고리에 속하는 메뉴가 없으면 false를 반환한다")
    @Test
    void checkIsThereDrinkTypeMenu() {
        Map<String, Integer> menus = new HashMap<String, Integer>();
        menus.put("양송이수프", 1);
        menus.put("티본스테이크", 1);

        assertThat(
                MenuCategory.hasOrderOnlyDrinkTypeMenu(menus)
        ).isEqualTo(false);
    }

}
