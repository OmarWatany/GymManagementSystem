package Data;
import Persons.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Membership_Plan {
    public String start_date;
   public int monthly_plan;
   public int numof_months_registered;
   public int priceofplan;

    public Membership_Plan(String start_date, int monthly_plan, int numof_months_registered, int priceofplan) {
        this.start_date = start_date;
        this.monthly_plan = monthly_plan;
        this.numof_months_registered = numof_months_registered;
        this.priceofplan = priceofplan;
    }
    public void disscount(int numof_months_registered, int priceofplan) {
        if (numof_months_registered >= 3) {
            priceofplan *= 0.25;
        }
    }
}
