package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.inspectcar.integration.*;
import se.kth.iv1350.inspectcar.model.*;



import java.time.YearMonth;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller {
    private VehicleDatabaseManager dbMgr;
    private GarageManager garageMgr;
    private CashRegisterManager cashRegisterMgr;
    private PrinterManager printerMgr;

    /**
     * Creates a new instance using the specified database manager.
     *
     * @param dbMgr The database manager used for all database calls.
     * @param garageMgr Used for calling on the hardware of the GARAGE, namely to the display and the garage door.
     * @param cashRegisterMgr Used for calling on the physical cash register.
     * @param printerMgr Used for calling the printer.
     *
     */
    public Controller(VehicleDatabaseManager dbMgr, GarageManager garageMgr, CashRegisterManager cashRegisterMgr,
                      PrinterManager printerMgr) {
        this.dbMgr = dbMgr;
        this.garageMgr = garageMgr;
        this.cashRegisterMgr = cashRegisterMgr;
        this.printerMgr = printerMgr;
    }

    /**
     * Verifies that there are inspections to perform for the vehicle with the specified
     * registration number. If there are inspections, returns the total cost for the inspections.
     * Returns 0 if there are no inspections to perform. This will instead be indicated with an
     * exception in a future version.
     *
     * @param regNo The registration number of the vehicle to inspect.
     * @return The total cost for the inspections, or 0 if there are no inspections to perform.
     */
    public int enterRegNo(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getCost();
    }


    /**
     *
     * Opens the physical garage door, races the queue number on the display and thereafter closes the garage door.
     *
     */
    public void newInspection() {
        garageMgr.nextCustomer();
        garageMgr.closeDoor();

    }

    /**
     *
     * This method is used when the customer pays with the credit card. The receipt is printed as a result of a
     * successful payment and opens the register.
     *
     * @param amount The cost of the inspection i.e the amount owned by the customer.
     * @return <code>true</code> if the payment is authorized,
     *         <code>false</code> if it is not. This dummy implementation always
     *         returns <code>true</code>
     *
     */
    public boolean payWithCreditCardAndPrintReceipt(int amount) {

        CostOfInspection amountToBePaid = new CostOfInspection(amount);
        CreditCardDTO card = new CreditCardDTO(8876, "1111222233334444","Keenan Kornelius",
                YearMonth.of(2019, 12), 123);

        PaymentAuthorization authorization = new PaymentAuthorization();
        boolean result = authorization.authorizePayment(card, amount);
        Receipt receipt = new Receipt(cashRegisterMgr, printerMgr, amountToBePaid);
        receipt.showPaymentInformationToScreen();
        receipt.openRegisterAndPrintReceipt();

        return result;

    }

    /**
     * This method is used if the customer pays with cash. The receipt of the financial transaction will be
     * printed and the cash register will open.
     *
     * @param cost The cost of the inspection.
     * @param cashPaid The amount in cash that the costumer pays.
     * @return <code>change</code> is the amount that has to be return to the customer from the cash register.
     *
     */

    public int payWithCashAndPrintReceipt(int cost, int cashPaid) {

        CostOfInspection amountToBePaid = new CostOfInspection(cost);
        int change = amountToBePaid.calculateChange(cashPaid);
        Receipt receipt = new Receipt(cashRegisterMgr, printerMgr, amountToBePaid);
        receipt.showPaymentInformationToScreen();
        receipt.openRegisterAndPrintReceipt();
        return change;

    }

    /**
     * Unfinished code.
     * @param regNo The registration number of the inspected vehicle.
     * @return The name of the next inspection.
     */

    public String nextInspection(String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        return inspection.getInspection();

    }

    /**
     * Unfinished code.
     * @param result The result of an performed inspection.
     */
    public void enterResult(boolean result, String regNo) {
        Vehicle vehicle = new Vehicle(regNo);
        Inspection inspection = new Inspection(vehicle, dbMgr);
        inspection.saveResult(result);
    }
}