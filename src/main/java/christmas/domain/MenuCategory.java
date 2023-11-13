package christmas.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum MenuCategory {

    APPETIZER("애피타이저", Arrays.asList(Menu.MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(Menu.T_BONE_STEAK, Menu.BARBECUE_RIB, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK("음료", Arrays.asList(Menu.ZERO_COKE, Menu.RED_WINE, Menu.CHAMPAGNE));

    private final String category;
    private final List<Menu> menus;

    MenuCategory(String category, List<Menu> menus) {
        this.category = category;
        this.menus = menus;
    }


    public static MenuCategory findCategoryByMenu(Menu menu) {
        return Arrays.stream(MenuCategory.values())
                .filter(category -> category.menus.contains(menu))
                .findFirst().get();
    }


    public static int calculateMenuQuantityByCategory(
            EnumMap<Menu, Integer> orders,
            MenuCategory category
    ) {
        return orders.entrySet().stream()
                .filter(order -> findCategoryByMenu(order.getKey()) == category)
                .map(order -> order.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }


    public static boolean hasOrderOnlyDrinkTypeMenu(Map<String, Integer> menus) {

        if (menus.size() == countDrinkTypeMenu(menus)) {
            return true;
        }
        return false;
    }

    private static int countDrinkTypeMenu(Map<String, Integer> menus) {
        return menus.entrySet().stream()
                .filter(menu -> findCategoryByName(menu.getKey()) == DRINK)
                .mapToInt(n -> 1)
                .sum();
    }

    private static MenuCategory findCategoryByName(String menuName) {
        return findCategoryByMenu(Menu.findMenuByName(menuName));
    }

}
