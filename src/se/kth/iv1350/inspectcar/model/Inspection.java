package se.kth.iv1350.inspectcar.model;

import java.util.List;
import se.kth.iv1350.inspectcar.integration.VehicleDatabaseManager;
import se.kth.iv1350.inspectcar.integration.InspectionItem;

/**
 * Represents an inspection of a vehicle.
 */

public class Inspection {
    private final Vehicle vehicle;
    private List<InspectionItem> inspections;
    private static int count = -1;
    private static int count2 = -1;
    /**
     * Creates a new instance, representing an inspection of the specified vehicle.
     *
     * @param vehicle The vehicle that is inspected.
     * @param dbMgr   The database manager to use when searching for inspections for the specified
     *                vehicle.
     */
    public Inspection(Vehicle vehicle, VehicleDatabaseManager dbMgr) {
        this.vehicle = vehicle;
        this.inspections = dbMgr.findInspectionsByVehicle(vehicle);
    }

    /**
     * @return The cost of this inspection.
     */
    public int getCost() {
        int totalCost = 0;
        if (inspections == null) {
            return 0;
        }
        for (InspectionItem inspItem : inspections) {
            totalCost = totalCost + inspItem.getCost();
        }
        return totalCost;
    }

    /**
     * Unfinished code.
     * @return The number of inspections in the inspection list.
     */
    private int countItems() {
        return inspections.size();
    }

    /**
     * Counts from 0 to 5 and then resets to 0 again.
     * @return Returns the current number it is on.
     */
    public static int counter() {

        count = (count + 1) % 5;
        return count;
    }

    /**
     * Counts from 0 to 5 and then resets to 0 again.
     * @return Returns the current number it is on.
     */
    public static int counter2() {

        count2 = (count2 + 1) % 5;
        return count2;
    }


    /**
     * Get the next inspection from the vehicle database.
     * @return Returns the name of an specific inspection.
     */
    public String getInspection() {
        return inspections.get(counter()).getName();

    }

    /**
     * Save the result of an inspection to the vehicle database.
     * @param result The result of an isnection that can either pass or fail.
     */
    public void saveResult(boolean result) {
        inspections.get(counter2()).setResult(result);
    }



}