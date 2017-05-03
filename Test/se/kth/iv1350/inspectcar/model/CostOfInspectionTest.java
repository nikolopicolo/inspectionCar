package se.kth.iv1350.inspectcar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by nikola on 2017-05-03.
 */
public class CostOfInspectionTest {
    private CostOfInspection costOfInspection;


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {}


    @Test
    public void testCalculateChange() {
        CostOfInspection costOfInspection = new CostOfInspection(500);
        int expResult = 100;
        int amountPaid = 600;
        int result = costOfInspection.calculateChange(amountPaid);
        assertEquals("Incorrect amount of change.", expResult, result);
    }


}