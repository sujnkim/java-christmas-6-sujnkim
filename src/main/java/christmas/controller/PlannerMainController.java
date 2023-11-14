package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.BenefitResult;
import christmas.domain.Gift;
import christmas.domain.plan.Badge;
import christmas.domain.visitor.MenuOrder;
import christmas.domain.visitor.VisitDate;
import christmas.domain.visitor.Visitor;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerMainController {


    public void start() {
        OutputView.printWelcomeMessage();

        VisitDate visitDate = recieveVisitDate();
        MenuOrder menuOrder = recieveMenuOrder();
        Visitor visitor = new Visitor(visitDate, menuOrder);

        OutputView.printResultStartMessage(visitor);
        OutputView.printMenuOrder(visitor);
        OutputView.printTotalPrice(visitor);

        Gift gift = provideGift(visitor);
        OutputView.printGiftMenu(gift);

        BenefitResult benefitResult = new BenefitResult(visitor, gift);
        OutputView.printBenefitsResult(benefitResult.createBenefitHistory(gift));
        OutputView.printAllBenefitAmount(benefitResult, gift);
        OutputView.printExpectedPayment(benefitResult, visitor);

        privideBadge(benefitResult.calculateAllBenefitAmount(gift));

        Console.close();
    }


    private VisitDate recieveVisitDate() {
        while (true) {
            try {
                return new VisitDate(InputView.inputVisitDate());
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }

    private MenuOrder recieveMenuOrder() {
        while (true) {
            try {
                return new MenuOrder(InputView.inputMenuOrder());
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }


    private Gift provideGift(Visitor visitor) {
        return new Gift(visitor.getTotalMenuPrice());
    }


    private void privideBadge(int benefitAmount) {
        OutputView.printBadge(Badge.getBadgeByBenefitPrice(benefitAmount));
    }
}
