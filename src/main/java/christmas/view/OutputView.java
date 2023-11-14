package christmas.view;

import christmas.domain.plan.Badge;
import christmas.domain.BenefitResult;
import christmas.domain.Gift;
import christmas.domain.visitor.Visitor;

import java.text.DecimalFormat;
import java.util.Map;


public class OutputView {
    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String BENEFIT_RESULT_START_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String TITLE_FORMAT = "<%s>";
    private static final String MENU_ORDER_FORMAT = "%s %d개";
    private static final String BENEFIT_FORMAT = "%s: -%s원";
    private static final String PRICE_FORMAT = "###,###";
    private static final String PRICE_MESSAGE = "%s원";
    public static final String MINUS_SIGN = "-";
    private static final String EMPTY_MENT = "없음";
    private static final String EMPTY_LINE = "";
    private static DecimalFormat formatter = new DecimalFormat(PRICE_FORMAT);


    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printResultStartMessage(Visitor visitor) {
        System.out.println(String.format(
                BENEFIT_RESULT_START_MESSAGE,
                visitor.getVisitDate()));
        System.out.println(EMPTY_LINE);
    }


    public static void printMenuOrder(Visitor visitor) {
        printTitle(ResultTitle.MENU_ORDER);
        visitor.getMenuOrder().entrySet().stream()
                .forEach(menu -> printEachMenu(
                        menu.getKey().getMenuName(),
                        menu.getValue()
                ));
        System.out.println(EMPTY_LINE);
    }

    private static void printEachMenu(String name, int count) {
        System.out.println(String.format(MENU_ORDER_FORMAT, name, count));
    }


    public static void printTotalPrice(Visitor visitor) {
        printTitle(ResultTitle.TOTAL_PRICE);
        System.out.println(String.format(
                        PRICE_MESSAGE,
                        formatter.format(visitor.getTotalMenuPrice())
                )
        );
        System.out.println(EMPTY_LINE);
    }


    public static void printGiftMenu(Gift gift) {
        printTitle(ResultTitle.GIFT_MENU);
        System.out.println(getGiftFormatMessage(gift));
        System.out.println(EMPTY_LINE);
    }

    private static String getGiftFormatMessage(Gift gift) {
        if (gift.getGiftCount() == 0) {
            return EMPTY_MENT;
        }
        return String.format(
                MENU_ORDER_FORMAT,
                gift.getGiftName(),
                gift.getGiftCount());
    }


    public static void printBenefitsResult(Map<String, Integer> result) {
        printTitle(ResultTitle.BENEFIT_HISTORY);
        result.entrySet().stream()
                .forEach(benefit -> printEachBenefit(benefit.getKey(), benefit.getValue()));
        System.out.println(EMPTY_LINE);
    }

    private static void printEachBenefit(String name, int price) {
        System.out.println(createBenefitMessage(name, price));
    }

    private static String createBenefitMessage(String name, int price) {
        if (name == EMPTY_MENT) {
            return EMPTY_MENT;
        }
        return String.format(BENEFIT_FORMAT, name, formatter.format(price));
    }


    public static void printAllBenefitAmount(BenefitResult result, Gift gift) {
        printTitle(ResultTitle.ALL_BENEFIT_AMOUNT);

        int amount = result.calculateAllBenefitAmount(gift);
        System.out.println(String.format(
                createPriceForm(amount),
                formatter.format(amount)
        ));
        System.out.println(EMPTY_LINE);
    }

    private static String createPriceForm(int amount) {
        if (amount == 0) {
            return PRICE_MESSAGE;
        }
        return MINUS_SIGN + PRICE_MESSAGE;
    }


    public static void printExpectedPayment(BenefitResult result, Visitor visitor) {
        printTitle(ResultTitle.EXPECTED_PAYMENT);
        System.out.println(String.format(
                PRICE_MESSAGE,
                formatter.format(result.calculateExpectedPayment(visitor))
        ));
        System.out.println(EMPTY_LINE);
    }


    public static void printBadge(Badge badge) {
        printTitle(ResultTitle.EVENT_BADGE);
        System.out.println(badge.getBadgeName());
    }


    private static void printTitle(ResultTitle title) {
        System.out.println(String.format(TITLE_FORMAT, title.getTitle()));
    }


    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
