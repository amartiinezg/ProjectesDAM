/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC2;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC2_Extra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int anyn, mesn, dian, any, mes, dia, edat;
        /**
         * Data Naixement*
         */
        System.out.println("Escriu el dia de naixement: ");
        dian = in.nextInt();
        System.out.println("Escriu el mes de naixement: ");
        mesn = in.nextInt();
        System.out.println("Escriu l'any de naixement: ");
        anyn = in.nextInt();
        /**
         * Data Actual*
         */
        System.out.println("Escriu el dia actual: ");
        dia = in.nextInt();
        System.out.println("Escriu el mes actual: ");
        mes = in.nextInt();
        System.out.println("Escriu l'any actual: ");
        any = in.nextInt();

        edat = any - anyn;
        if (mes == mesn) {
            if (dia == dian) {
                System.out.println("Avui farás " + edat + " anys");
            } else if (dia > dian) {
                System.out.println("Tens " + edat + " anys");
            } else {
                edat = edat + -1;
                System.out.println("Tens " + edat + " anys");
            }
        } else if (mes < mesn) {
            edat = edat + -1;
            System.out.println("Tens " + edat + " anys");
        } else {
            System.out.println("Tens " + edat + " anys");
        }
    }
}
