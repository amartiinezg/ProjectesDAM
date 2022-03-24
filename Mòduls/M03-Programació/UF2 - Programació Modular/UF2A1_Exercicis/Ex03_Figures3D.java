/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Exercicis;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author HP "Que demani el tipus de figura 3D (cilindre, hexaedre, tetraedre o
 * esfera) i a continuació demani les dades necessàries per a cadascun i en
 * mostri la superfície i el volum".
 */
public class Ex03_Figures3D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String figura;
        do {
            System.out.println("- Cilindre ");
            System.out.println("- Hexaedre ");
            System.out.println("- Tetraedre ");
            System.out.println("- Esfera ");
            System.out.println("Tipus de figura 3D: ");
            figura = in.nextLine();
        } while (comprova(figura) == false);
        figures(figura);
    }

    public static boolean comprova(String figura) {
        if (figura.equals("Cilindre") || figura.equals("Hexaedre") || figura.equals("Tetraedre")
                || figura.equals("Esfera")) {
            System.out.println("Has seleccionat: " + figura);
            return true;
        } else {
            System.out.println("Aquesta figura no existeix...");
            return false;
        }
    }

    public static void figures(String figura) {
        Scanner in2 = new Scanner(System.in);
        double superficie, volum, altura, radi, costat;
        switch (figura) {
            case "Cilindre":
                System.out.println("Radi: ");
                radi = in2.nextFloat();
                System.out.println("Altura: ");
                altura = in2.nextFloat();
                superficie = 2 * Math.PI * (radi * altura) + 2 * Math.PI * Math.pow(radi, 2);
                volum = Math.PI * Math.pow(radi, 2) * altura;
                System.out.println("La superfície del cilindre es de " + superficie
                        + " y el volum de " + volum + " m3");
                break;
            case "Hexaedre":
                System.out.println("Altura: ");
                altura = in2.nextFloat();
                superficie = 6 * Math.pow(altura, 2);
                volum = Math.pow(altura, 3);
                System.out.println("La superfície del Hexaedre es de " + superficie
                        + " i el volum de  " + volum + " m3");
                break;
            case "Tetraedre":
                System.out.println("Costat: ");
                costat = in2.nextFloat();
                superficie = Math.pow(costat, 2) * Math.sqrt(3);
                volum = Math.pow(costat, 3) * (Math.sqrt(2) / 12);
                System.out.println("La superfície del Tetraedre es de " + superficie
                        + " i el volum de " + volum + " m3");
                break;
            default:
                System.out.println("Radi: ");
                radi = in2.nextFloat();
                superficie = 4 * Math.PI * Math.pow(radi, 2);
                volum = 4 / 3 * Math.PI * Math.pow(radi, 3);
                System.out.println("La superfície de l'esfera es de " + superficie
                        + " i el volum de " + volum + " m3");
                break;

        }
    }
}
