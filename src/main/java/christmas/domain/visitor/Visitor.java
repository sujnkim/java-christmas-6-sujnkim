package christmas.domain.visitor;

import christmas.domain.plan.Menu;

import java.util.EnumMap;

public class Visitor {
    private final VisitDate date;
    private final MenuOrder menuOrder;

    public Visitor(VisitDate visitDate, MenuOrder menuOrder) {
        this.date = visitDate;
        this.menuOrder = menuOrder;
    }

    public int getVisitDate() {
        return date.getVisitDate();
    }

    public EnumMap<Menu, Integer> getMenuOrder() {
        return menuOrder.getMenuOrder();
    }

    public int getTotalMenuPrice() {
        return menuOrder.calculateTotalMenuPrice();
    }
}
