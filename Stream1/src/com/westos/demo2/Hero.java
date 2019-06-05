package com.westos.demo2;

public class Hero {
    private int id;
    private String name;
    private String loc;//location
    private String sex;
    private int bir;
    private int death;
    private int power;

    private int age;
    public Hero() {
    }

    public Hero(int id, String name, String loc, String sex, int bir, int death, int power) {
        this.id = id;
        this.name = name;
        this.loc = loc;
        this.sex = sex;
        this.bir = bir;
        this.death = death;
        this.power = power;
        this.age=death-bir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBir() {
        return bir;
    }

    public void setBir(int bir) {
        this.bir = bir;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public String ageRange(){
        if(age>0&&age<=20){
            return "0~20";
        }else if(age>=21&&age<=40){
            return "21~40";
        }else if(age>=41&&age<=60){
            return "41~60";
        }else{
            return "60以上";
        }
    }
}