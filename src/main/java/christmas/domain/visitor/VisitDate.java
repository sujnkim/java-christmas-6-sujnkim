package christmas.domain;

import static christmas.utils.ErrorMessage.INVALID_VISIT_DATE;

public class VisitDate {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final int visitDate;

    public VisitDate(int visitDate) {
        validate(visitDate);
        this.visitDate = visitDate;
    }

    private void validate(int visitDate) {
        if (visitDate < MIN_DATE || visitDate > MAX_DATE) {
            throw new IllegalArgumentException(INVALID_VISIT_DATE.getMessage());
        }
    }

    public int getVisitDate() {
        return visitDate;
    }
}
