import java.util.Date;

import Data.*;
import Persons.*;

public class Main {
    public static void main(String[] args){
        // for testing
        Date date = new Date();
        Subscription sub = new Subscription();
        Customer omar = new Customer(234,"omar","male",
                "234 st as","012351235","omar@email.com",sub);
        omar.inBodies[0] = new InBody(date,1.5F,78F,15F,1F,10F,0.5F);
        omar.inBodies[1] = new InBody(date,1.2F,73F,16F,1F,8F,0.8F);
        Coach ahmed = new Coach(23,"Ahmed","Male","23 Ahmed st",
                "012345678901","Ahmed@email.com",9);
        ahmed.customers[0] = omar;
        ahmed.getCustomerInBodyHistory("omar");
    }
}
