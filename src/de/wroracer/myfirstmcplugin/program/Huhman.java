package de.wroracer.myfirstmcplugin.program;

public class Huhman extends Creature{

    private static int humanCounter = 0;

    private String name;
    private int age;
    private String job;
    private String hobby;
    private Gender gender;

    public Huhman(String name, int age,String job, String hobby, Gender gender){
        this.name = name;
        this.age = age;
        this.job = job;
        this.hobby = hobby;
        this.gender = gender;

        humanCounter++;
    }
    public void printInformation(){
        System.out.println("Name der Person: "+name);
        System.out.println("Alter der Person: "+age);
        System.out.println("Beruf der Person: "+job);
        System.out.println("Hobby der Person: "+hobby);
    }

    @Override
    public String breed(String test) {
        return null;
    }

    public static int getHumanCounter() {return humanCounter;}

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age; }
    public void setAge(int age) {this.age = age;}

    public String getJob() {return job;}
    public void setJob(String job) {this.job = job;}

    public String getHobby() {return hobby;}
    public void setHobby(String hobby) {this.hobby = hobby;}

    public Gender getGender() {return gender;}

}
