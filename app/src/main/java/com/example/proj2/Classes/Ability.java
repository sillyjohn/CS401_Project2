package com.example.proj2.Classes;

public class Ability {

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
    double[] coefficentAD;
    double[] coefficentAP;
    double[] coefficentArmor;
    double[] coefficentMR;
    double[] coefficentHP;
    double[] coefficentStacks;
}
