package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.PlannerMainController;

public class Application {
    public static void main(String[] args) {
        PlannerMainController planner = new PlannerMainController();
        planner.start();
        Console.close();
    }
}
