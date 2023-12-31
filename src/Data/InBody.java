package Data;

import java.text.DecimalFormat;
import java.util.Date;
import java.lang.Math;
import Persons.Customer;
import java.text.SimpleDateFormat;

public class InBody {
    private int customerId;
    protected Date date;

    private float height, totalWeight, fatMass, minerals,
            bodyWater, protein, BMI, PBF;
    private float sWeight, sBMI, sLeanMass, sFatMass;

    /**
     * creates inbody object
     * @param customerID
     * @param date
     * @param height
     * @param fatMass
     * @param minerals
     * @param bodyWater
     * @param protein
     */
    public InBody(int customerID, Date date, float height, float fatMass,
            float minerals, float bodyWater, float protein) {
        this.customerId = customerID;
        this.date = date;
        this.height = height;
        this.fatMass = fatMass;
        this.minerals = minerals;
        this.bodyWater = bodyWater;
        this.protein = protein;
        this.totalWeight = fatMass + bodyWater + protein + minerals;
        this.BMI = (float) (totalWeight / (Math.pow(height, 2)));
        this.PBF = fatMass / totalWeight;
    }

    /**
     * return the inbody information in csv line form
     * @return attrinbutes
     */
    public String getAllAttributes() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String attributes = "," + String.valueOf(customerId) + "," + dateFormat.format(date) + ","
                + String.valueOf(height) + "," + String.valueOf(fatMass) + "," + String.valueOf(minerals) + ","
                + String.valueOf(bodyWater) + "," + String.valueOf(protein);
        return attributes;
    }

    public Date getDate() {
        return date;
    }

    public float getHeight() {
        return height;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public float getFatMass() {
        return fatMass;
    }

    public float getMinerals() {
        return minerals;
    }

    public float getBodyWater() {
        return bodyWater;
    }

    public float getProtein() {
        return protein;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setFatMass(float fatMass) {
        this.fatMass = fatMass;
    }

    public void setMinerals(float minerals) {
        this.minerals = minerals;
    }

    public void setBodyWater(float bodyWater) {
        this.bodyWater = bodyWater;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = fatMass + bodyWater + protein + minerals;
    }


    /**
     * set the standard information based on customer gender
     * @param customer
     */
    public void setStandards(Customer customer) {
        if (customer.gender.toLowerCase().equals("male")) {
            this.sBMI = 22F;
            this.sWeight = this.sBMI * (float) Math.pow(this.height, 2);
            this.sFatMass = this.sWeight * 0.15F;
        } else {
            this.sBMI = 21.5F;
            this.sWeight = this.sBMI * (float) Math.pow(this.height, 2);
            this.sFatMass = this.sWeight * 0.23F;
        }
    }

    /**
     *  print the target weight and muscle loss or gain
     *  based on the inbody information
     * @param customer
     */
    public void getWeightControl(Customer customer) {
        setStandards(customer);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        float weightControl = sWeight - totalWeight;
        float fatControl = sFatMass - fatMass;
        float muscleControl = weightControl - fatControl;

        System.out.println("Target weight : " + df.format(sWeight) + " Kg");
        System.out.println("Weight control: " + df.format(weightControl) + " Kg");
        System.out.println("Fat control: " + df.format(fatControl) + " Kg");
        System.out.println("Muscle control: " + df.format(muscleControl) + " Kg");
    }

    /**
     * print the customer information
     */
    public void displayInformation() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println("date : " + date);
        System.out.println("height : " + height + " M");
        System.out.println("totalWeight : " + df.format(totalWeight) + " Kg");
        System.out.println("fatMass : " + df.format(fatMass) + " Kg");
        System.out.println("minerals : " + minerals + " Kg");
        System.out.println("bodyWater : " + bodyWater + " Kg");
        System.out.println("protein : " + protein + " Kg");
        System.out.println("BMI : " + df.format(BMI));
        System.out.println();
    }
}