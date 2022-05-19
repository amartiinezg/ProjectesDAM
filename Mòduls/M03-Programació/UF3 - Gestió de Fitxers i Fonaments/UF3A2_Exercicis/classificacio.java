/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A2_Exercicis;

/**
 *
 * @author HP
 */
public class classificacio {

    private String equip;
    private int perdut;
    private int empat;
    private int guanyat;

    public classificacio() {
    }

    public classificacio(String equip, int perdut, int empat, int guanyat) {
        this.equip = equip;
        this.perdut = perdut;
        this.empat = empat;
        this.guanyat = guanyat;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public int getPerdut() {
        return perdut;
    }

    public void setPerdut(int perdut) {
        this.perdut = perdut;
    }

    public int getEmpat() {
        return empat;
    }

    public void setEmpat(int empat) {
        this.empat = empat;
    }

    public int getGuanyat() {
        return guanyat;
    }

    public void setGuanyat(int guanyat) {
        this.guanyat = guanyat;
    }

    @Override
    public String toString() {
        return "classificacio{" + "Equip : " + equip + ", P=" + perdut + ", E=" + empat + ", G=" + guanyat + '}';
    }
}
