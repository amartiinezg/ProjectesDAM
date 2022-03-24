/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Practica1;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 *
 * @author HP
 */
public class Ex2 {

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner num = new Scanner(System.in);
        String figura;
        boolean sortir = false;

        do {
            figura = num.nextLine();
            if (figura.equalsIgnoreCase("Q")) {
                System.out.println("==Quadrat==");
                quadrat(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("R")) {
                System.out.println("==Rectangle==");
                rectangle(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("T")) {
                System.out.println("==Triangle isòsceles==");
                triangle(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("C")) {
                System.out.println("==Cercle==");
                cercle(num);
                num.nextLine();
            } else if (figura.equalsIgnoreCase("S")) {
                sortir = true;
            } else {
                System.out.println("Opció no vàlida, torna a intentar-ho...");
                num.nextLine();
            }
        } while (sortir != true);

    }

    public static void quadrat(Scanner num) {
        float costat;
        costat = num.nextFloat();
        System.out.println("Perímetre : " + df.format(4 * costat));
        System.out.println("Superfície: " + df.format(2 * costat));
    }

    public static void rectangle(Scanner num) {
        float costat, costatA;
        costat = num.nextFloat();
        costatA = num.nextFloat();
        System.out.println("Perímetre : " + df.format(2 * costat + 2 * costatA));
        System.out.println("Superfície: " + df.format(costat * costatA));
    }

    public static void triangle(Scanner num) {
        float base, costat, altura;
        costat = num.nextFloat();
        base = num.nextFloat();
        altura = (float) Math.sqrt(Math.pow(costat, 2) - (Math.pow(base, 2) / 4));
        System.out.println("Perímetre : " + df.format(2 * costat + base));
        System.out.println("Superfície: " + df.format(base * altura / 2));
    }

    public static void cercle(Scanner num) {
        float radi;
        radi = num.nextFloat();
        System.out.println("Perímetre : " + df.format(2 * Math.PI * radi));
        System.out.println("Superfície: " + df.format(Math.PI * Math.pow(radi, 2)));
    }

}
