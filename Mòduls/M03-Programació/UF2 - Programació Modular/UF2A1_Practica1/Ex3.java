/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Practica1;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex3 {
    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner num = new Scanner(System.in);
        String figura;
        boolean sortir = false;

        do {
            figura = num.nextLine();
            if (figura.equalsIgnoreCase("C")) {
                System.out.println("==Cilindre==");
                cilindre(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("H")) {
                System.out.println("==Hexaedre==");
                hexaedre(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("T")) {
                System.out.println("==Tetraedre==");
                tetraedre(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("E")) {
                System.out.println("==Esfera==");
                esfera(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("S")) {
                sortir = true;
            }
        } while (sortir != true);

    }

    public static void cilindre(Scanner num) {
        float radi, alçada;
        radi = num.nextFloat();
        alçada = num.nextFloat();
        System.out.println("Superfície: " + df.format(2 * Math.PI * (radi * alçada)));
        System.out.println("Volum: " + df.format(Math.PI * Math.pow(radi, 2) * alçada));
    }

    public static void hexaedre(Scanner num) {
        float radi, alçada;
        alçada = num.nextFloat();
        System.out.println("Superfície: " + df.format(6 * Math.pow(alçada, 2)));
        System.out.println("Volum: " + df.format(Math.pow(alçada, 3)));
    }

    public static void tetraedre(Scanner num) {
        float costat;
        costat = num.nextFloat();
        System.out.println("Superfície: " + df.format(Math.pow(costat, 2) * Math.sqrt(3)));
        System.out.println("Volum: " + df.format(Math.pow(costat, 3) * (Math.sqrt(2) / 12)));
    }

    public static void esfera(Scanner num) {
        float radi;
        radi = num.nextFloat();
        System.out.println("Superfície: " + df.format(4 * Math.PI * Math.pow(radi, 2)));
        System.out.println("Volum: " + df.format((4 * Math.PI * Math.pow(radi, 3) / 3)));
    }
}
