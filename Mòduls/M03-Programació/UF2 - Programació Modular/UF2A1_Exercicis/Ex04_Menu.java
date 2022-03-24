/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Exercicis;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex04_Menu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner teclat = new Scanner(System.in);
        int seleccio;
        String figura;
        do {
            System.out.println("--- MENU ---");
            System.out.println("1 - Figures 2D");
            System.out.println("2 - Figures 3D");
            System.out.println("3 - Sortir");
            System.out.println("Selecciona: ");
            seleccio = in.nextInt();
            if (seleccio == 1) {
                System.out.println("- Quadrat ");
                System.out.println("- Rectangle ");
                System.out.println("- Triangle ");
                System.out.println("- Cercle ");
                System.out.println("Tipus de figura 2D: ");
                figura = teclat.nextLine();
                figures2D(figura);
            } else if (seleccio == 2) {
                System.out.println("- Cilindre ");
                System.out.println("- Hexaedre ");
                System.out.println("- Tetraedre ");
                System.out.println("- Esfera ");
                System.out.println("Tipus de figura 3D: ");
                figura = teclat.nextLine();
                figures3D(figura);
            }
        } while (comprova(seleccio) != 3);
        System.out.println("Has sortit amb éxit.");
    }

    public static int comprova(int seleccio) {
        if (seleccio == 1) {
            return 1;
        } else if (seleccio == 2) {
            return 2;
        } else if (seleccio == 3) {
            return 3;
        } else {
            System.out.println("Opció no vàlida torna a intentar-ho...");
        }
        return seleccio;
    }

    public static void figures2D(String figura) {
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

    public static void figures3D(String figura) {
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
