package se.kth.iv1350.inspectcar.integration;

/**
 * Represents an particular control of a vehicle, for example brakes or suspension.
 */
public class InspectionItem {
    private final String name;
    private final int cost;
    boolean result;

    /**
     * Creates new instance representing the specified control.
     *
     * @param name The name of this control.
     * @param cost The cost of this control.
     * @param result The result of the inspection. Initially it is set to false indicating that the inspection has not yet been performed
     *               or that the vehicle has not passed the inspection.
     */
    InspectionItem(String name, int cost, boolean result) {
        this.name = name;
        this.cost = cost;
        this.result = result;
    }

    /**
     * @return The cost of this control.
     */
    public int getCost() {
        return cost;
    }


    /**
     * @return The name of the control.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param result Sets a result of an inspection.
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    /**
     * @return True if the specified object is considered to represent the same inspection item as
     *         this object.
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof InspectionItem)) {
            return false;
        }
        InspectionItem otherInspItem = (InspectionItem) other;
        return otherInspItem.cost == this.cost && otherInspItem.name == this.name;
    }
}