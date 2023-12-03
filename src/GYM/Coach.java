package GYM;
public class Coach{
    private final String name;
    private final int age;
    public Coach(int age,String name){
        this.name = name;
        this.age  = age;
    }
    public void getName(){
        System.out.println(name);
    }
    public void getAge(){
        System.out.println(age);
    }
}

