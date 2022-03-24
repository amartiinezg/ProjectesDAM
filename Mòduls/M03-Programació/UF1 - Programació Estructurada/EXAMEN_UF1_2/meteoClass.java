/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXAMEN_UF1_2;

/**
 *
 * @author HP
 */
public class meteoClass {
//Emmagatzemem Pais (String), Regió (String), temperatura (int) i pressió atmosfèrica(float).     

    private String pais;
    private String regio;
    private int temperatura;
    private double pressioAtmosferica;
    
    public meteoClass() {
    }

    public meteoClass(String pais, String regio, int temperatura, double pressioAtmosferica) {
        this.pais = pais;
        this.regio = regio;
        this.temperatura = temperatura;
        this.pressioAtmosferica = pressioAtmosferica;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegio() {
        return regio;
    }

    public void setRegio(String regio) {
        this.regio = regio;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public double getPressioAtmosferica() {
        return pressioAtmosferica;
    }

    public void setPressioAtmosferica(double pressioAtmosferica) {
        this.pressioAtmosferica = pressioAtmosferica;
    }

    @Override
    public String toString() {
        return "meteoClass{" + "pais=" + pais + ", regio=" + regio + ", temperatura=" + temperatura + ", pressioAtmosferica=" + pressioAtmosferica + '}';
    }

}
