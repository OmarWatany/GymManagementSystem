package GYM;
public class Customer extends Person{
  public int last_InBody[]= new int[3];
  public String last_InBody_date;
  public Boolean is_Subscribed;
  public InBody[] inBodies;
  public Subscription subscription;

  public Customer(int id,String name,String gender,String address,String number,String email,Subscription subscription){
    super(id,name,gender,address,number,email);
    is_Subscribed=true;
    this.subscription=subscription;
  }


  public void set_subscription(bool f){
    is_Subscribed=f;
  }
  
  public InBody get_InBody_info(String date){
    for (InBody inbody : inBodies){
      if(date.equal(inbody.date)){
        return inbody;
      }
    }
  } 
}