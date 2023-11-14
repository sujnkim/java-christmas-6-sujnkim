package christmas.controller;

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
        Visitor visitor = recieveVisitorData();
        printVisitorDataBeforeApplyEvent(visitor);

        Gift gift = provideGift(visitor);
        OutputView.printGiftMenu(gift);

        BenefitResult benefitResult = new BenefitResult(visitor, gift);
        printResultDataAfterApplyEvent(benefitResult, visitor, gift);
    }


    private Visitor recieveVisitorData() {
        OutputView.printWelcomeMessage();

        VisitDate visitDate = recieveVisitDate();
        MenuOrder menuOrder = recieveMenuOrder();
        return new Visitor(visitDate, menuOrder);
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


    private void printVisitorDataBeforeApplyEvent(Visitor visitor) {
        OutputView.printResultStartMessage(visitor);
        OutputView.printMenuOrder(visitor);
        OutputView.printTotalPrice(visitor);
    }

    private void printResultDataAfterApplyEvent(
            BenefitResult benefitResult,
            Visitor visitor,
            Gift gift
    ) {
        OutputView.printBenefitsResult(benefitResult.createBenefitHistory(gift));
        OutputView.printAllBenefitAmount(benefitResult, gift);
        OutputView.printExpectedPayment(benefitResult, visitor);
        privideBadge(benefitResult.calculateAllBenefitAmount(gift));
    }


    private Gift provideGift(Visitor visitor) {
        return new Gift(visitor.getTotalMenuPrice());
    }


    private void privideBadge(int benefitAmount) {
        OutputView.printBadge(Badge.getBadgeByBenefitPrice(benefitAmount));
    }
}
