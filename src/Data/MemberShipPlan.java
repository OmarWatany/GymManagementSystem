package Data;

import java.util.Date;
import java.text.SimpleDateFormat;


public class MemberShipPlan {
    public Date startDate;
    public int planId;
    public int monthlyPlan;
    public int numOfMonthsRegistered;
    public float price;

    public MemberShipPlan(int planId, Date startDate, int monthlyPlan, int numOfMonthsRegistered, float priceOfPlan) {
        this.planId = planId;
        this.startDate = startDate;
        this.monthlyPlan = monthlyPlan;
        this.numOfMonthsRegistered = numOfMonthsRegistered;
        this.price = priceOfPlan;
    }

    public String getAllAttributes() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String attributes = "," + String.valueOf(planId) + "," + dateFormat.format(startDate) + ","+ String.valueOf(monthlyPlan) + ","+ String.valueOf(numOfMonthsRegistered) +","+ String.valueOf(price);

        return attributes;
    }

    public void discount(int numOfMonthsRegistered) {
        if (numOfMonthsRegistered >= 3)
            price *= 0.75F;
    }
}
