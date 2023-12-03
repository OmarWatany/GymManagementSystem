package GYM;
public class Coach{
    private final String name;
    private final int age;
    private int workingHours;
    public Coach(int age,String name,int workingHours){
        this.name = name;
        this.age  = age;
        this.workingHours = Math.min(workingHours, 10);
    }
    public void getName(){
        System.out.println(name);
    }
    public void getAge(){
        System.out.println(age);
    }
    public void getWorkingHours(){
        System.out.println(workingHours);
    }
    public void listCustomers(){
    }
    public void gitCustomInBody(){
    }
}

