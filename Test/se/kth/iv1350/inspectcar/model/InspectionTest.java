package se.kth.iv1350.inspectcar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import se.kth.iv1350.inspectcar.integration.VehicleDatabaseManager;
import se.kth.iv1350.inspectcar.integration.InspectionItem;
import se.kth.iv1350.inspectcar.model.Vehicle;

/**
 * Created by nikola on 2017-05-03.
 */

public class InspectionTest {
    Vehicle vehicle = new Vehicle("ABC123");
    private List<InspectionItem> inspections;
    VehicleDatabaseManager dbMgr = new VehicleDatabaseManager();




    @Before
    public void setUp() {
        vehicle = new Vehicle("ABC123");
        inspections = dbMgr.findInspectionsByVehicle(vehicle);

    }

    @After
    public void tearDown() {
        inspections = null;
        vehicle = null;
    }

    @Test
    public void testGetCost() {
        Inspection instance = new Inspection(vehicle, dbMgr);
        int result = instance.getCost();
        int expResult = 94;
        assertEquals("Cost wasn't calculated.", expResult, result);

    }



    




}