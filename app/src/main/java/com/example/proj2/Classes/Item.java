package com.example.proj2.Classes;

public class Item {
    String Name;

    public String getPngName() {
        return pngName;
    }

    public void setPngName(String pngName) {
        this.pngName = pngName;
    }

    String pngName;
    double AD = 0;
    double AP = 0;
    double HP = 0;
    double MR = 0;
    double ARMOR = 0;
    double Haste = 0;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAD() {
        return AD;
    }

    public void setAD(double AD) {
        this.AD = AD;
    }

    public double getAP() {
        return AP;
    }

    public void setAP(double AP) {
        this.AP = AP;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getMR() {
        return MR;
    }

    public void setMR(double MR) {
        this.MR = MR;
    }

    public double getARMOR() {
        return ARMOR;
    }

    public void setARMOR(double ARMOR) {
        this.ARMOR = ARMOR;
    }
}
