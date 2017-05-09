package se.kth.iv1350.inspectcar.view;

import se.kth.iv1350.inspectcar.controller.Controller;

/**
 * This class is a placeholder for the view.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance that will use the specified controller for all system operations.
     *
     * @param contr The controller to use for system operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Calls all system operations and prints the result to <code>System.out</code>.
     */
    public void sampleExecution() {

        contr.newInspection();
        String regNoOfVehicleToInspect = "ABC123";
        int cost = contr.enterRegNo(regNoOfVehicleToInspect);
        System.out.println("The cost is: " + cost);
        System.out.println(contr.showPaymentOnScreen(cost));
        System.out.println("The payment is with 100.\n");
        System.out.println("The change is: "+  contr.payWithCashAndPrintReceipt(cost,100));

        System.out.println("Next car inspection: " + contr.nextInspection(regNoOfVehicleToInspect));
        contr.enterResult(true, regNoOfVehicleToInspect);
        System.out.println("Next car inspection: " + contr.nextInspection(regNoOfVehicleToInspect));
        contr.enterResult(true, regNoOfVehicleToInspect);
        System.out.println("Next car inspection: " + contr.nextInspection(regNoOfVehicleToInspect));
        contr.enterResult(true, regNoOfVehicleToInspect);
        System.out.println("Next car inspection: " + contr.nextInspection(regNoOfVehicleToInspect));
        contr.enterResult(true, regNoOfVehicleToInspect);



    }
}