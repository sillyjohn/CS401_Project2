package com.example.proj2.Classes;

import java.util.ArrayList;

public class Ability {
    String Name;
    int damageType;

    int rank = 5;
    ArrayList<Double> damage;
    //Bools
    boolean isDamage;
    boolean isSummon;
    boolean isStack;
    boolean isCritiable;
    boolean isMaxHP;
    boolean isMaxHPDOT;
    boolean isDOT;
    double duration;
    double perSecond;
    ArrayList<Double> dotDamage;
    ArrayList<Double> dotRatio;
    ArrayList<Double> summonAA;
    ArrayList<Double> summonRatioAD;
    ArrayList<Double> summonRatioAP;

    int instances;

    //ratio
    ArrayList<Double> ratioBAD;
    ArrayList<Double> ratioAD;
    ArrayList<Double> ratioAP;
    public Ability(){
        Name = "PlaceHolder";
        this.damageType = 0;
        this.rank = 5;
        this.damage = damage;
        this.isDamage = isDamage;
        this.isSummon = isSummon;
        this.isStack = isStack;
        this.isCritiable = isCritiable;
        this.isMaxHP = isMaxHP;
        this.isMaxHPDOT = isMaxHPDOT;
        this.isDOT = isDOT;
        this.duration = duration;
        this.perSecond = perSecond;
        this.dotDamage = dotDamage;
        this.dotRatio = dotRatio;
        this.summonAA = summonAA;
        this.summonRatioAD = summonRatioAD;
        this.summonRatioAP = summonRatioAP;
        this.instances = instances;
        this.ratioBAD = ratioBAD;
        this.ratioAD = ratioAD;
        this.ratioAP = ratioAP;
    }
    public Ability(String name, int damageType, int rank, ArrayList<Double> damage, boolean isDamage, boolean isSummon, boolean isStack, boolean isCritiable, boolean isMaxHP, boolean isMaxHPDOT, boolean isDOT, double duration, double perSecond, ArrayList<Double> dotDamage, ArrayList<Double> dotRatio, ArrayList<Double> summonAA, ArrayList<Double> summonRatioAD, ArrayList<Double> summonRatioAP, int instances, ArrayList<Double> ratioBAD, ArrayList<Double> ratioAD, ArrayList<Double> ratioAP) {
        Name = name;
        this.damageType = damageType;
        this.rank = rank;
        this.damage = damage;
        this.isDamage = isDamage;
        this.isSummon = isSummon;
        this.isStack = isStack;
        this.isCritiable = isCritiable;
        this.isMaxHP = isMaxHP;
        this.isMaxHPDOT = isMaxHPDOT;
        this.isDOT = isDOT;
        this.duration = duration;
        this.perSecond = perSecond;
        this.dotDamage = dotDamage;
        this.dotRatio = dotRatio;
        this.summonAA = summonAA;
        this.summonRatioAD = summonRatioAD;
        this.summonRatioAP = summonRatioAP;
        this.instances = instances;
        this.ratioBAD = ratioBAD;
        this.ratioAD = ratioAD;
        this.ratioAP = ratioAP;
    }

    public ArrayList<Double> getDamage() {
        return damage;
    }

    public void setDamage(ArrayList<Double> damage) {
        this.damage = damage;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }


    public boolean getisDamage() {
        return isDamage;
    }

    public void setisDamage(boolean bool) {
        isDamage = bool;
    }

    public boolean isSummon() {
        return isSummon;
    }

    public void setSummon(boolean summon) {
        isSummon = summon;
    }

    public boolean isStack() {
        return isStack;
    }

    public void setStack(boolean stack) {
        isStack = stack;
    }

    public boolean isCritiable() {
        return isCritiable;
    }

    public void setCritiable(boolean critiable) {
        isCritiable = critiable;
    }

    public boolean isMaxHP() {
        return isMaxHP;
    }

    public void setMaxHP(boolean maxHP) {
        isMaxHP = maxHP;
    }

    public boolean isMaxHPDOT() {
        return isMaxHPDOT;
    }

    public void setMaxHPDOT(boolean maxHPDOT) {
        isMaxHPDOT = maxHPDOT;
    }

    public boolean isDOT() {
        return isDOT;
    }

    public void setDOT(boolean DOT) {
        isDOT = DOT;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPerSecond() {
        return perSecond;
    }

    public void setPerSecond(double perSecond) {
        this.perSecond = perSecond;
    }

    public ArrayList<Double> getDotDamage() {
        return dotDamage;
    }

    public void setDotDamage(ArrayList<Double> dotDamage) {
        this.dotDamage = dotDamage;
    }

    public ArrayList<Double> getDotRatio() {
        return dotRatio;
    }

    public void setDotRatio(ArrayList<Double> dotRatio) {
        this.dotRatio = dotRatio;
    }

    public ArrayList<Double> getSummonAA() {
        return summonAA;
    }

    public void setSummonAA(ArrayList<Double> summonAA) {
        this.summonAA = summonAA;
    }

    public ArrayList<Double> getSummonRatioAD() {
        return summonRatioAD;
    }

    public void setSummonRatioAD(ArrayList<Double> summonRatioAD) {
        this.summonRatioAD = summonRatioAD;
    }

    public ArrayList<Double> getSummonRatioAP() {
        return summonRatioAP;
    }

    public void setSummonRatioAP(ArrayList<Double> summonRatioAP) {
        this.summonRatioAP = summonRatioAP;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    public ArrayList<Double> getRatioBAD() {
        return ratioBAD;
    }

    public void setRatioBAD(ArrayList<Double> ratioBAD) {
        this.ratioBAD = ratioBAD;
    }

    public ArrayList<Double> getRatioAD() {
        return ratioAD;
    }

    public void setRatioAD(ArrayList<Double> ratioAD) {
        this.ratioAD = ratioAD;
    }

    public ArrayList<Double> getRatioAP() {
        return ratioAP;
    }

    public void setRatioAP(ArrayList<Double> ratioAP) {
        this.ratioAP = ratioAP;
    }

    public void setRankToThree(){
        rank = 3;
    }
}
