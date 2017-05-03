package se.kth.iv1350.inspectcar.integration;

import java.util.ArrayList;
import java.util.List;


import se.kth.iv1350.inspectcar.model.Vehicle;


/**
 * This class is responsible for database calls. This is the only place the database is called.
 */
public class VehicleDatabaseManager {
    private List<InspectionItem> dummyInspectionList;


    /**
     * Creates a new instance, which uses a hard coded list of inspections instead of calling a
     * database.
     */
    public VehicleDatabaseManager() {
        createDummyInspections();
    }

    /**
     * Searches the database for inspections to be performed on the specified vehicle. This dummy
     * implementation returns hard coded inspections for some vehicles.
     *
     * @param vehicle The vehicle to inspect.
     * @return A list of <code>InspectionItem</code>s, where each element describes one particular
     *         control.
     */
    public List<InspectionItem> findInspectionsByVehicle(Vehicle vehicle) {
        if (vehicle.getRegNo().equals("ABC123")) {
            return dummyInspectionList;
        }
        return null;
    }

    private void createDummyInspections() {
        dummyInspectionList = new ArrayList<>();
        dummyInspectionList.add(new InspectionItem("brakes", 10, false));
        dummyInspectionList.add(new InspectionItem("suspension", 20, false));
        dummyInspectionList.add(new InspectionItem("steering", 30, false));
        dummyInspectionList.add(new InspectionItem("wind shield", 5, false));
        dummyInspectionList.add(new InspectionItem("servo system", 17, false));
        dummyInspectionList.add(new InspectionItem("lights and blinkers", 12, false));
    }





}