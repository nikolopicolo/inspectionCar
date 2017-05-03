package se.kth.iv1350.inspectcar.startup;

import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.integration.*;
import se.kth.iv1350.inspectcar.view.View;

/**
 * Starts the application.
 */

public class Main {



    public static void main(String[] args) {
        GarageManager garageMgr = new GarageManager();
        CashRegisterManager cashRegisterMgr = new CashRegisterManager();
        PrinterManager printerMgr = new PrinterManager();
        VehicleDatabaseManager dbMgr = new VehicleDatabaseManager();
        Controller contr = new Controller(dbMgr, garageMgr, cashRegisterMgr, printerMgr);
        View view = new View(contr);
        view.sampleExecution();


    }
}