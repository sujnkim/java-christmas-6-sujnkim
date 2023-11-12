package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

import static christmas.utils.ErrorMessage.INVALID_ORDER;

public class MenuOrder {

    private final Map<Menu, Integer> menuOrder;

    public MenuOrder(Map<String, Integer> menus) {
        validateOrder(menus);
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

    private void validateOrder(Map<String, Integer> menus){
        menus.entrySet().stream()
                .forEach(menu->validateQuantity(menu.getValue()));
    }

    private void validateQuantity(int count){
        if(count < 1){
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}
