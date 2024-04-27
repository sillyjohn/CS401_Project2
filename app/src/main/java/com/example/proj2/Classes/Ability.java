package com.example.proj2.Classes;

import android.util.Log;

import java.util.ArrayList;

/**
 * Represents an ability in the game or application.
 */
public class Ability {
    String Name;
    int damageType;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    int rank = 5;
    ArrayList<Double> damage = null;
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
    ArrayList<Double> dotDamage = null;
    ArrayList<Double> dotRatio = null;
    ArrayList<Double> summonAA = null;
    ArrayList<Double> summonRatioAD = null;
    ArrayList<Double> summonRatioAP = null;

    int instances;

    //ratio
    ArrayList<Double> ratioBAD = null;
    ArrayList<Double> ratioAD = null;
    ArrayList<Double> ratioAP = null;

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

    /**
     * Constructor for the Ability class with parameters.
     * @param name Name of the ability.
     * @param damageType Type of damage (0: Attack Damage, 1: Ability Power, 2: True Damage).
     * @param rank Rank of the ability.
     * @param damage Damage values of the ability.
     * @param isDamage Boolean indicating if the ability deals damage.
     * @param isSummon Boolean indicating if the ability summons.
     * @param isStack Boolean indicating if the ability stacks.
     * @param isCritiable Boolean indicating if the ability is critiable.
     * @param isMaxHP Boolean indicating if the ability is based on max HP.
     * @param isMaxHPDOT Boolean indicating if the ability deals max HP based damage over time.
     * @param isDOT Boolean indicating if the ability deals damage over time.
     * @param duration Duration of the ability effect.
     * @param perSecond Damage per second of the ability.
     * @param dotDamage Damage values of the damage over time effect.
     * @param dotRatio Ratios of the damage over time effect.
     * @param summonAA Summon attack damage values.
     * @param summonRatioAD Summon ability power ratios.
     * @param summonRatioAP Summon ability power ratios.
     * @param instances Number of instances of the ability.
     * @param ratioBAD Ratios of the ability.
     * @param ratioAD Ratios of the ability.
     * @param ratioAP Ratios of the ability.
     */
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

    /**
     *
     * @param champ
     * @return
     */
    public double returnDamage(Champion champ){
        Log.d("Working on Abi", Name);
        Log.d("Working on Abi", String.valueOf(rank));
        //check if this ab does dmg
        if(isDamage == true){
            return damage.get(rank-1)*instances
                    + (ratioAD == null ? 0.0 : ratioAD.get(rank-1)*champ.getBaseDamage())
                    + (ratioBAD == null ? 0.0 : ratioBAD.get(rank-1))
                    + (ratioAP== null ? 0.0 : ratioAP.get(rank-1)* champ.getAp())
                    + returnDOT(champ)
                    + returnSummonDamage(champ);
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnADDamage(Champion champ){
        Log.d("Working on Abi", Name);
        Log.d("Working on Abi", String.valueOf(rank));
        //check if this ab does dmg
        if(isDamage == true&&damageType==0){
            return damage.get(rank-1)*instances
                    + (ratioAD == null ? 0.0 : ratioAD.get(rank-1)*champ.getBaseDamage())
                    + (ratioBAD == null ? 0.0 : ratioBAD.get(rank-1))
                    + (ratioAP== null ? 0.0 : ratioAP.get(rank-1)* champ.getAp())
                    + returnDOT(champ)
                    + returnSummonDamage(champ);
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnAPDamage(Champion champ){
        Log.d("Working on Abi", Name);
        Log.d("Working on Abi", String.valueOf(rank));
        //check if this ab does dmg
        if(isDamage == true&&damageType==1){
            return damage.get(rank-1)*instances
                    + (ratioAD == null ? 0.0 : ratioAD.get(rank-1)*champ.getBaseDamage())
                    + (ratioBAD == null ? 0.0 : ratioBAD.get(rank-1))
                    + (ratioAP== null ? 0.0 : ratioAP.get(rank-1)* champ.getAp())
                    + returnDOT(champ)
                    + returnSummonDamage(champ);
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnTrueDamage(Champion champ){
        Log.d("Working on Abi", Name);
        Log.d("Working on Abi", String.valueOf(rank));
        //check if this ab does dmg
        if(isDamage == true&&damageType==2){
            return damage.get(rank-1)*instances
                    + (ratioAD == null ? 0.0 : ratioAD.get(rank-1)*champ.getBaseDamage())
                    + (ratioBAD == null ? 0.0 : ratioBAD.get(rank-1))
                    + (ratioAP== null ? 0.0 : ratioAP.get(rank-1)* champ.getAp())
                    + returnDOT(champ)
                    + returnSummonDamage(champ);
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnDOT(Champion champ){
        if(isDOT == true){
            return dotDamage.get(rank-1)*duration/perSecond;
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnMaxHPDOT(Champion champ){
        if(isMaxHP == true){
            return dotDamage.get(rank-1)*duration/perSecond;
        }
        return 0;
    }

    /**
     *
     * @param champ
     * @return
     */
    public double returnSummonDamage(Champion champ){
        if(isSummon == true){
            return summonAA.get(rank-1);
        }
        return 0;
    }
}
