package org.example.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan {

    protected double mBillingRate;

    abstract void getRate();

    public void calculateBill(int mUnitsRecorded) {
        System.out.print("BILL : ");
        System.out.println(mUnitsRecorded * mBillingRate);
    }
}

class DomesticPlan extends Plan {
    public void getRate() {
        mBillingRate = 3.75;
    }
}

class CommercialPlan extends Plan {
    public void getRate() {
        mBillingRate = 7.52;
    }
}

class InstitutionPlan extends Plan {
    public void getRate() {
        mBillingRate = 5.56;
    }
}

class GetPlan {

    public Plan getBillPlanType(String planType) {

        if (planType == null)
            return null;
        else if (planType.equalsIgnoreCase("domestic"))
            return new DomesticPlan();
        else if (planType.equalsIgnoreCase("commercial"))
            return new CommercialPlan();
        else if (planType.equalsIgnoreCase("institution"))
            return new InstitutionPlan();
        else
            return null;
    }
}


public class FactoryMethod {

    public static void main(String args[]) throws IOException {

        GetPlan getPlan = new GetPlan();
        System.out.println("Choices - Commercial/ Domestic/ Institution");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planType = br.readLine();
        System.out.println("Enter number of units consumed");
        int units = Integer.parseInt(br.readLine());

        Plan pl = getPlan.getBillPlanType(planType);
        pl.getRate();
        pl.calculateBill(units);
    }
}
