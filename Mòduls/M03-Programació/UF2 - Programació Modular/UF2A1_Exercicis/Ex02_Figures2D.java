/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Exercicis;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author HP "Que demani el tipus de figura 2D (quadrat, rectangle, triangle
 * isòsceles o cercle) i a continuació demani les dades necessàries per a
 * cadascun i en mostri el perímetre i la superfície"
 */
public class Ex02_Figures2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String figura;
        do {
            System.out.println("- Quadrat ");
            System.out.println("- Rectangle ");
            System.out.println("- Triangle ");
            System.out.println("- Cercle ");
            System.out.println("Tipus de figura 2D: ");
            figura = in.nextLine();
        } while (comprova(figura) == false);
        figures(figura);
    }

    public static boolean comprova(String figura) {
        if (figura.equals("Quadrat") || figura.equals("Rectangle") || figura.equals("Triangle")
                || figura.equals("Cercle")) {
            System.out.println("Has seleccionat: " + figura);
            return true;
        } else {
            System.out.println("Aquesta figura no existeix...");
            return false;
        }
    }

    public static void figures(String figura) {
        Scanner in2 = new Scanner(System.in);
        double costat, costatA, base, altura, radi;
        switch (figura) {
            case "Quadrat":
                System.out.println("Costat: ");
                costat = in2.nextFloat();
                System.out.println("El perímetre del quadrat es de " + (4 * costat)
                        + " i la superfície de " + (costat * 2) + " m2");
                break;
            case "Rectangle":
                System.out.println("Costat A: ");
                costat = in2.nextFloat();
                System.out.println("Costat B: ");
                costatA = in2.nextFloat();
                System.out.println("El perímetre del rectangle es de " + (2 * costat + 2 * costatA)
                        + " i la superfície de " + (costat * costatA) + " m2");
                break;
            case "Triangle":
                System.out.println("Base: ");
                base = in2.nextFloat();
                System.out.println("Costat Igual: ");
                costat = in2.nextFloat();
                altura = Math.sqrt(Math.pow(costat, 2) - (Math.pow(base, 2) / 4));
                System.out.println("El perímetre del rectangle es de " + (2 * costat + base)
                        + " i la superfície de " + (double) (base * altura / 2) + " m2");
                break;
            default:
                System.out.println("Radi: ");
                radi = in2.nextFloat();
                System.out.println("El perímetre del cercle es de " + (2 * Math.PI * radi)
                        + " i la superfície de " + (double) (Math.PI * Math.pow(radi, 2)) + " m2");
                break;

        }
    }

}
