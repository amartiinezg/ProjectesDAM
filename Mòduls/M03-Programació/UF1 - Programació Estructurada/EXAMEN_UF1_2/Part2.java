/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXAMEN_UF1_2;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Part2 {

    public static void main(String[] args) {
        /*Som aficionats a la meteorologia i recollim informació de 10 estacions meteorològiques d'arreu del món a la mateixa hora. 
    (Pots introduir directament la informació per codi). 
    Emmagatzemem Pais (String), Regió (String), temperatura (int) i pressió atmosfèrica(float). 
    Una vegada introduïda la informació volem:
    Saber la ubicació amb la temperatura més alta (regió i país al que pertany) (1,5 punt)
    Quants  estacions tenim a cada país (3,0 punt)
    Introduint les 4 informacions per teclat,  comprovar si aquesta estació ( pais i regió) ja està introduïda. 
    Si ho està, actualitzar temperatura i pressió atmosfèrica, Si no ho està indicar-ho
    NOTA: A cada pais i regió només hi ha una estació*/
        Scanner teclat = new Scanner(System.in);

        meteoClass[] meteoInfo = new meteoClass[10];
        meteoInfo[0] = new meteoClass("Estats Units", "Oklahoma", 23, 83.23);
        meteoInfo[1] = new meteoClass("España", "Madrid", 17, 123.54);
        meteoInfo[2] = new meteoClass("Australia", "Sydney", 13, 67.76);
        meteoInfo[3] = new meteoClass("Canada", "Quebec", 10, 43.34);
        meteoInfo[4] = new meteoClass("Suïssa", "Berna", 16, 33.98);
        meteoInfo[5] = new meteoClass("Colombia", "Medellin", 36, 113.41);
        meteoInfo[6] = new meteoClass("China", "Singapur", 27, 143.87);
        meteoInfo[7] = new meteoClass("Italia", "Turin", 23, 98.83);
        meteoInfo[8] = new meteoClass("Alemania", "Munich", 18, 64.24);
        meteoInfo[9] = new meteoClass("Rusia", "Sant Petersburg", 5, 43.84);

        tempMesAlta(meteoInfo);
        System.out.println("Introdueix pais: ");
        String pais = teclat.nextLine();
        cercarDades(meteoInfo, pais);
    }

    public static void tempMesAlta(meteoClass meteoInfo[]) {
        int MaxTemp = meteoInfo[0].getTemperatura();
        String pais = meteoInfo[0].getPais();
        for (int i = 1; i < meteoInfo.length; i++) {
            if (meteoInfo[i].getTemperatura() > MaxTemp) {
                MaxTemp = meteoInfo[i].getTemperatura();
                pais = meteoInfo[i].getPais();
            }
        }
        System.out.println("La temperatura més alta es de " + pais + " amb "
                + MaxTemp + " Cº");
    }

    public static void cercarDades(meteoClass meteoInfo[], String pais) {
        Scanner temp = new Scanner(System.in);
        for (int i = 0; i < meteoInfo.length; i++) {
            if (meteoInfo[i].getPais().equals(pais)) {
                if (meteoInfo[i].getTemperatura() != 0) {
                    System.out.println("Introdueix nova temperatura: ");
                    meteoInfo[i].setTemperatura(temp.nextInt());
                    System.out.println("La nova temperatura de " + pais + " s'ha establit en "
                            + meteoInfo[i].getTemperatura() + " Cº");
                    // ----------
                    System.out.println("Introdueix nova pressió atmosfèrica: ");
                    meteoInfo[i].setPressioAtmosferica(temp.nextDouble());
                    System.out.println("La nova pressió atmosfèrica de " + pais + " s'ha establit en "
                            + meteoInfo[i].getPressioAtmosferica());
                    break;
                } else {
                    System.out.println("No hi ha cap temperatura");
                    break;
                }
            }
        }
        System.out.println("No s'ha trobat cap pais amb aquest nom.");
    }
}
