package GYM;
import java.util.Date;
public class InBody {
    private Date date;
    private float height;
    private float totalWeight;
    private float fatMass;
    private float minerals;
    private float bodyWater;
    private float protein;

    public InBody(
            Date date,
            float height,
            float totalWeight,
            float fatMass,
            float minerals,
            float bodyWater,
            float protein) {
        this.date = date;
        this.height = height;
        this.totalWeight = totalWeight;
        this.fatMass = fatMass;
        this.minerals = minerals;
        this.bodyWater = bodyWater;
        this.protein = protein;
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

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
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

    public void displayInformation(){
        System.out.println("date : " + date );
        System.out.println("height : " + height + " M" );
        System.out.println("totalWeight : " + totalWeight + " Kg" );
        System.out.println("fatMass : " + fatMass + " Kg" );
        System.out.println("minerals : " + minerals + " Kg" );
        System.out.println("bodyWater : " + bodyWater + " Kg" );
        System.out.println("protein : " + protein + " Kg");
    }
}