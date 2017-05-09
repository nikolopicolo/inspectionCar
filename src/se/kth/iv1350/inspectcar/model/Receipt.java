package se.kth.iv1350.inspectcar.model;

import se.kth.iv1350.inspectcar.integration.CashRegisterManager;
import se.kth.iv1350.inspectcar.integration.PrinterManager;
import java.util.Date;

/**
 * The Receipt proves that the payment has been done.
 */

public class Receipt {

    private CashRegisterManager cashRegisterMgr;
    private PrinterManager printerMgr;
    private CostOfInspection amountPaid;


    /**
     * Creates an instance of an receipt and connects to the cash register and the printer.
     * @param cashRegisterMgr The connection to the cash register.
     * @param printerMgr The connection to the physical printer.
     * @param amountPaid The cost of the inspection.
     */
    public Receipt (CashRegisterManager cashRegisterMgr, PrinterManager printerMgr, CostOfInspection amountPaid) {
        this.cashRegisterMgr = cashRegisterMgr;
        this.printerMgr = printerMgr;
        this.amountPaid = amountPaid;

    }

    /**
     * The register opens and the receipt for the payment is printed out.
     */
    public void openRegisterAndPrintReceipt() {
        cashRegisterMgr.openRegister();
        printerMgr.printReceipt(amountPaid);

    }

    /**
     * Shows the specifics of a payment to the UI-user.
     * @return A formatted receipt string.
     */
    public String showPaymentInformationToScreen() {
        StringBuilder builder = new StringBuilder();
        Date inspectionTime = new Date();

        builder.append("Car inspection ");
        builder.append(inspectionTime.toString());
        builder.append("\n\n\t\t The cost is: " + amountPaid.toString() + "\n");

        return builder.toString();
    }

}