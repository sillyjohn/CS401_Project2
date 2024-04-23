package com.example.proj2.Classes;

public class Ability {
    //Eability
    //
    //Qability
    //
    //Rability
    //
    //Wability
    //Fields:
    //Name
    //damage:number
    //ratioAP
    //ratioAD
    //isDamage
    //isSummon
    //instances
    //duration

    String name;
    String spellnames;
    double cost;
    boolean isDamage;
    double damage;
    enum damageType{trueDamage,physicalDamage, magicalDamage};
    boolean isDOT;
    double dotDuration;
    boolean multipleStage;
    int stages;

    //ratio
    double[] ratioAD;
    double[] ratioAP;
    double[] coefficentArmor;
    double[] coefficentMR;
    double[] coefficentHP;
    double[] coefficentStacks;
}
