package com.example.proj2.Classes;

public class Item {
    String Name;

    /**
     * Returns the filename of the item's associated image.
     *
     * @return The filename of the item's associated image
     */
    public String getPngName() {
        return pngName;
    }

    /**
     * Sets the filename of the item's associated image.
     *
     * @param pngName The filename to set for the item's associated image
     */
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

    /**
     * Returns the name of the item.
     *
     * @return The name of the item
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name The name to set for the item
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Returns the Attack Damage (AD) attribute of the item.
     *
     * @return The Attack Damage (AD) attribute of the item
     */
    public double getAD() {
        return AD;
    }

    /**
     * Sets the Attack Damage (AD) attribute of the item.
     *
     * @param AD The value to set for the Attack Damage (AD) attribute of the item
     */
    public void setAD(double AD) {
        this.AD = AD;
    }

    /**
     * Returns the Ability Power (AP) attribute of the item.
     *
     * @return The Ability Power (AP) attribute of the item
     */
    public double getAP() {
        return AP;
    }

    /**
     * Sets the Ability Power (AP) attribute of the item.
     *
     * @param AP The value to set for the Ability Power (AP) attribute of the item
     */
    public void setAP(double AP) {
        this.AP = AP;
    }

    /**
     * Returns the Health Points (HP) attribute of the item.
     *
     * @return The Health Points (HP) attribute of the item
     */
    public double getHP() {
        return HP;
    }

    /**
     * Sets the Health Points (HP) attribute of the item.
     *
     * @param HP The value to set for the Health Points (HP) attribute of the item
     */
    public void setHP(double HP) {
        this.HP = HP;
    }

    /**
     * Returns the Magic Resistance (MR) attribute of the item.
     *
     * @return The Magic Resistance (MR) attribute of the item
     */
    public double getMR() {
        return MR;
    }

    /**
     * Sets the Magic Resistance (MR) attribute of the item.
     *
     * @param MR The value to set for the Magic Resistance (MR) attribute of the item
     */
    public void setMR(double MR) {
        this.MR = MR;
    }

    /**
     * Returns the Armor (ARMOR) attribute of the item.
     *
     * @return The Armor (ARMOR) attribute of the item
     */
    public double getARMOR() {
        return ARMOR;
    }

    /**
     * Sets the Armor (ARMOR) attribute of the item.
     *
     * @param ARMOR The value to set for the Armor (ARMOR) attribute of the item
     */
    public void setARMOR(double ARMOR) {
        this.ARMOR = ARMOR;
    }
}
