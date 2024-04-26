package com.example.proj2.Classes;

import android.util.Log;

import java.util.ArrayList;

/**
 *  Represents a Champion in the game or application.
 */
public class Champion {
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<Ability> abilities = new ArrayList<>();
    int id;
    public String name;
    //Stats
    int level = 18;
    double baseDamage;
    double damagePerLevel;
    double ap;
    double critChance = 0;
    double critDamage = 0.75;
    double lifeSteal = 0;
    double omniVamp = 0;
    double armorPen = 0;
    double magicPen = 0;
    double lethality = 0;
    double magicFlatPen = 0;
    double baseHP;
    double hpPerLevel;
    double baseArmor;
    double armorPerLevel;
    double baseSpellBlock;
    double spellBlockPerLevel;
    double baseMoveSpeed;
    double attackSpeed;
    double attackSpeedRatio;
    double attackSpeedPerLevel;

    //Default constructor
    public Champion() {
        this.name = "placeHolder";
        this.level =0;
        this.baseDamage = 0;
        this.damagePerLevel = 0;
        this.ap = 0;
        this.baseHP = 0;
        this.hpPerLevel = 0;
        this.baseArmor = 0;
        this.armorPerLevel = 0;
        this.baseSpellBlock = 0;
        this.spellBlockPerLevel = 0;
        this.baseMoveSpeed = 0;
        this.attackSpeed = 0;
        this.attackSpeedRatio = 0;
        this.attackSpeedPerLevel = 0;
        this.critChance = 0;
        this.critDamage = 0.75;
        this.lifeSteal = 0;
        this.omniVamp = 0;
        this.armorPen = 0;
        this.magicFlatPen = 0;
        this.magicPen = 0;
        this.lethality = 0;

    }
    //Constructor
    public Champion(String name,
                    double baseHP, double hpPerLevel,
                    double baseDamage, double damagePerLevel,
                    double baseArmor, double armorPerLevel,
                    double baseSpellBlock, double spellBlockPerLevel,
                    double baseMoveSpeed,
                    double attackSpeed, double attackSpeedRatio,
                    double attackSpeedPerLevel) {

        this.name = name;
        this.baseDamage = baseDamage;
        this.damagePerLevel = damagePerLevel;
        this.baseHP = baseHP;
        this.hpPerLevel = hpPerLevel;
        this.baseArmor = baseArmor;
        this.armorPerLevel = armorPerLevel;
        this.baseSpellBlock = baseSpellBlock;
        this.spellBlockPerLevel = spellBlockPerLevel;
        this.baseMoveSpeed = baseMoveSpeed;
        this.attackSpeed = attackSpeed;
        this.attackSpeedRatio = attackSpeedRatio;
        this.attackSpeedPerLevel = attackSpeedPerLevel;
    }
    //ToString
//    public String toString(){
//        return ;
//    }
    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        if(level <=18 && level >= 0){
            this.level = level;
        }
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setDamagePerLevel(double damagePerLevel) {
        this.damagePerLevel = damagePerLevel;
    }

    public void setAp(double ap) {
        this.ap = ap;
    }

    public void setBaseHP(double baseHP) {
        this.baseHP = baseHP;
    }

    public void setHpPerLevel(double hpPerLevel) {
        this.hpPerLevel = hpPerLevel;
    }

    public void setBaseArmor(double baseArmor) {
        this.baseArmor = baseArmor;
    }

    public void setArmorPerLevel(double armorPerLevel) {
        this.armorPerLevel = armorPerLevel;
    }

    public void setBaseSpellBlock(double baseSpellBlock) {
        this.baseSpellBlock = baseSpellBlock;
    }

    public void setSpellBlockPerLevel(double spellBlockPerLevel) {
        this.spellBlockPerLevel = spellBlockPerLevel;
    }

    public void setBaseMoveSpeed(double baseMoveSpeed) {
        this.baseMoveSpeed = baseMoveSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setAttackSpeedRatio(double attackSpeedRatio) {
        this.attackSpeedRatio = attackSpeedRatio;
    }

    public void setAttackSpeedPerLevel(double attackSpeedPerLevel) {
        this.attackSpeedPerLevel = attackSpeedPerLevel;
    }

    //Getter
//    public Ability[] getAbilities() {
//        return abilities;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public double getDamagePerLevel() {
        return damagePerLevel;
    }

    public double getAp() {
        return ap;
    }

    public double getBaseHP() {
        return baseHP;
    }

    public double getHpPerLevel() {
        return hpPerLevel;
    }

    public double getBaseArmor() {
        return baseArmor;
    }

    public double getArmorPerLevel() {
        return armorPerLevel;
    }

    public double getBaseSpellBlock() {
        return baseSpellBlock;
    }

    public double getSpellBlockPerLevel() {
        return spellBlockPerLevel;
    }

    public double getBaseMoveSpeed() {
        return baseMoveSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getAttackSpeedRatio() {
        return attackSpeedRatio;
    }

    public double getAttackSpeedPerLevel() {
        return attackSpeedPerLevel;
    }

    /**
     * returnCombineDamage
     * @return
     */
    public double returnCombineDamage(){
        double qDamage = abilities.get(0).returnDamage(this);
        double wDamage = abilities.get(1).returnDamage(this);
        double eDamage = abilities.get(2).returnDamage(this);
        double rDamage = abilities.get(3).returnDamage(this);
        //Log.d("Combine Dmg" ,String.valueOf(getBaseDamage() + qDamage + wDamage + eDamage+ rDamage));
        return getBaseDamage()+ getDamagePerLevel()* getLevel() + qDamage + wDamage + eDamage+ rDamage;
    }

    /**
     * returnADDamage
     * @return
     */
    public double returnADDamage(){
        double qDamage = abilities.get(0).returnADDamage(this);
        double wDamage = abilities.get(1).returnADDamage(this);
        double eDamage = abilities.get(2).returnADDamage(this);
        double rDamage = abilities.get(3).returnADDamage(this);
        //Log.d("AD Dmg" ,String.valueOf(getBaseDamage() + qDamage + wDamage + eDamage+ rDamage));
        return getBaseDamage()+ getDamagePerLevel()* getLevel() + qDamage + wDamage + eDamage+ rDamage;
    }
    public double returnAPDamage(){
        double qDamage = abilities.get(0).returnAPDamage(this);
        double wDamage = abilities.get(1).returnAPDamage(this);
        double eDamage = abilities.get(2).returnAPDamage(this);
        double rDamage = abilities.get(3).returnAPDamage(this);
        //Log.d("AP Dmg" ,String.valueOf(getBaseDamage() + qDamage + wDamage + eDamage+ rDamage));
        return  qDamage + wDamage + eDamage+ rDamage;
    }

    /**
     * returnTrueDamage
     * @return
     */
    public double returnTrueDamage(){
        double qDamage = abilities.get(0).returnAPDamage(this);
        double wDamage = abilities.get(1).returnAPDamage(this);
        double eDamage = abilities.get(2).returnAPDamage(this);
        double rDamage = abilities.get(3).returnAPDamage(this);
        //Log.d("TRUE Dmg" ,String.valueOf(getBaseDamage() + qDamage + wDamage + eDamage+ rDamage));
        return qDamage + wDamage + eDamage+ rDamage;
    }



}