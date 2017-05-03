package se.kth.iv1350.inspectcar.model;

/**
 * Represents the cost of the inspection.
 */

public final class CostOfInspection {

    private final int amountToBePaid;

    /**
     * @param amountToBePaid The cost of the inspection owned by the customer.
     */

    public CostOfInspection(int amountToBePaid) {

        this.amountToBePaid = amountToBePaid;
    }

    /**
     *
     * @param cashPaid The amount of cash paid by the customer.
     * @return The change that has to be returned to the customer.
     */

    public int calculateChange(int cashPaid) {

        return cashPaid - this.amountToBePaid;

    }

    /**
     *
     * @return returns a string of the amount.
     */
    public String toString() {
        return "" + this.amountToBePaid;
    }

}