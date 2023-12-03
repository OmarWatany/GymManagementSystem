import java.util.Date;
import GYM.*;

public class Main {
    public static void main(String[] args){
        Date date = new Date();
        InBody i = new InBody(date,1.5F,78F,15F,1F,10F,0.5F);
        i.displayInformation();
    }
}
