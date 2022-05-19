/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3_Pràctica;

import UF3A2_Exercicis.*;

/**
 *
 * @author HP
 */
public class classificacioLOL {

    private String equip;
    private int punts;

    public classificacioLOL() {
    }

    public classificacioLOL(String equip, int punts) {
        this.equip = equip;
        this.punts = punts;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    @Override
    public String toString() {
        return "classificacioLOL{" + "equip=" + equip + ", punts=" + punts + '}';
    }

}
