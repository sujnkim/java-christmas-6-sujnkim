package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

import static christmas.utils.ErrorMessage.INVALID_MAX_QUANTITY;
import static christmas.utils.ErrorMessage.INVALID_ORDER;

public class MenuOrder {
    private final static int MAX_QUANTITY = 20;

    private final Map<Menu, Integer> menuOrder;

    public MenuOrder(Map<String, Integer> menus) {
        validateQuantityPerMenu(menus);
        validateMaxQuantitySum(menus);
        this.menuOrder = createOrder(menus);
    }

    private Map<Menu, Integer> createOrder(Map<String, Integer> menus) {
        EnumMap<Menu, Integer> menuOrder = new EnumMap<>(Menu.class);

        menus.entrySet().stream()
                .forEach(menu -> menuOrder.put(
                        Menu.findMenuByName(menu.getKey()),
                        menu.getValue()
                ));
        return menuOrder;
    }

    private void validateQuantityPerMenu(Map<String, Integer> menus){
        menus.entrySet().stream()
                .forEach(menu->validateQuantity(menu.getValue()));
    }

    private void validateQuantity(int count){
        if(count < 1){
            throw new IllegalArgumentException(
                    INVALID_ORDER.getMessage());
        }
    }

    private void validateMaxQuantitySum(Map<String, Integer> menus){
        int quantity = menus.entrySet().stream()
                .map(menu->menu.getValue())
                .mapToInt(Integer::intValue)
                .sum();

        if(quantity > MAX_QUANTITY){
            throw new IllegalArgumentException(
                    INVALID_MAX_QUANTITY.getMessage());
        }
    }

}
