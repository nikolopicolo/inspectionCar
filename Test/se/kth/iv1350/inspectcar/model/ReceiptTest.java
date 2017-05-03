package se.kth.iv1350.inspectcar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;
import se.kth.iv1350.inspectcar.integration.*;

/**
 * Created by nikola on 2017-05-03.
 */
public class ReceiptTest {
    CashRegisterManager cashRegisterMgr = new CashRegisterManager();
    PrinterManager printerMgr = new PrinterManager();
    CostOfInspection costOfInspection = new CostOfInspection(500);
    private Receipt instance;



    @Before
    public void setUp() {
        cashRegisterMgr = new CashRegisterManager();
        printerMgr = new PrinterManager();
        costOfInspection = new CostOfInspection(500);
        instance = new Receipt(cashRegisterMgr, printerMgr, costOfInspection);
    }


    @After
    public void tearDown() {
        cashRegisterMgr = null;
        printerMgr = null;
        costOfInspection = null;
        instance = null;
    }



    @Test
    public void testShowPaymentInformationToScreen() {

        Date inspectionTime = new Date();
        String expResult = "Car inspection" + inspectionTime.toString() + costOfInspection;
        String result = instance.showPaymentInformationToScreen();
        assertEquals("Wrong printout", expResult, result);
    }



    

}