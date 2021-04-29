package com.praticals.projectAss;

public class vipUser extends User {

    vipUser(String vipName){
        super(vipName);
        this.setScore(10);
    }

    @Override
    public String getName(){return "*" + super.getName();}

    @Override
    public void greet(){
        System.out.printf("Welcome! %s the VIP! Please choose a game to start. %n", this.getName());
    }
}
