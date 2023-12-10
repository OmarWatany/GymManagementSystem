package Data;
import java.util.Date;
import java.lang.Math;
import Persons.Customer;

public class InBody {
    protected Date date;
    private float height,  totalWeight,  fatMass, minerals,
                  bodyWater,  protein,  IS, BMI,leanMass;
    private float sWeight, sBMI, sLeanMass,sFatMass;

    public InBody( Date date, float height, float fatMass,
                   float minerals, float bodyWater, float protein) {
        this.date = date;
        this.height = height;
        this.fatMass = fatMass;
        this.minerals = minerals;
        this.bodyWater = bodyWater;
        this.protein = protein;
        this.totalWeight = fatMass + bodyWater + protein + minerals;
        this.BMI =  (totalWeight / (float) Math.pow(height,2)) ;
    }

    public Date getDate() {
        return date;
    }

    public float getHeight() { return height; }

    public float getTotalWeight() { return totalWeight; }

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

    public void setProtein(float protein) { this.protein = protein; }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = fatMass + bodyWater + protein + minerals;
    }

    public void setStandards(Customer customer){
        switch (customer.gender){
            case MALE:
                this.sBMI = 22F;
                this.sWeight = this.sBMI * (float) Math.pow(this.height,2);
                this.sFatMass = this.sWeight * 0.15F ;
                break;
            case FEMALE:
                this.sBMI = 21.5F;
                this.sWeight = this.sBMI * (float) Math.pow(this.height,2);
                this.sFatMass = this.sWeight * 0.23F ;
                break;
        }
    }

   public void GetInBodyWeightControl(Customer customer) {
        setStandards(customer);
   }

    public void displayInformation(){
        System.out.println("date : " + date );
        System.out.println("height : " + height + " M" );
        System.out.println("totalWeight : " + totalWeight + " Kg" );
        System.out.println("fatMass : " + fatMass + " Kg" );
        System.out.println("minerals : " + minerals + " Kg" );
        System.out.println("bodyWater : " + bodyWater + " Kg" );
        System.out.println("protein : " + protein + " Kg");
        System.out.println();
    }
}