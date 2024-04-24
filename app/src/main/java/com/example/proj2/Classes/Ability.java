package com.example.proj2.Classes;

import java.util.ArrayList;

public class Ability {
    String name;
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

    public ArrayList<Double> getDamage() {
        return damage;
    }

    public void setDamage(ArrayList<Double> damage) {
        this.damage = damage;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }


    public boolean isDamage() {
        return isDamage;
    }

    public void setDamage(boolean damage) {
        isDamage = damage;
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
