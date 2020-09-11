package de.wroracer.myfirstmcplugin.program;

public class Thief  extends Huhman{

    private int robbtPeople;

    public Thief(String name, int age, String hobby, int robbtPeople, Gender gender) {
        super(name, age, "Dieb", hobby, gender);
        this.robbtPeople = robbtPeople;
    }

    @Override
    public void printInformation(){
        System.out.println(getName()+" ist ein Dieb. Deshalb sind keine Informationen Bekannt.");
        System.out.println("...außer, dass er bereits "+robbtPeople+" Menschen ausgeraubt hat.");
    }

    public int getRobbtPeople() {return robbtPeople;}
}
