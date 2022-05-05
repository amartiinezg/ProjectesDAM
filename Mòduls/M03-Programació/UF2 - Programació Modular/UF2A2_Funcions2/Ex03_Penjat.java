/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_Funcions2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex03_Penjat {

    public static void main(String[] args) {
        String[] paraules = new String[]{"Paisatge", "Platja", "Hivern", "Primavera", "Muntanya", "Juliol", "Septembre",
            "Elefant"};
        Scanner teclat = new Scanner(System.in);
        int estat = 0;
        String paraula, paraulaCodificada2 = "";
        boolean finalitzat = false;
        paraula = paraulaAleatoria(paraules);
        char[] paraulaCodificada = new char[paraula.length()];
        Arrays.fill(paraulaCodificada, '*');
        char lletra;

        do {
            estatPenjat(estat);
            if (estat == 8) {
                System.out.println("OOOOOoooohhhh! Has perdut!!");
                System.out.println("La paraula secreta era: " + paraula);
                finalitzat = true;
            } else {
                System.out.print("Paraula: ");
                System.out.println(paraulaCodificada);
                System.out.println("Introdueix lletra: ");
                lletra = teclat.next().charAt(0);
                comprovaParaula(paraulaCodificada, lletra, paraula);
                if (comprovaEstat(paraulaCodificada, lletra, paraula, estat) == true) {
                    estat++;
                }
                paraulaCodificada2 = String.valueOf(paraulaCodificada);
            }

            if (paraula.equalsIgnoreCase(paraulaCodificada2)) {
                finalitzat = true;
                System.out.println("'¡¡¡Has guanyat!!! Ben fet.");
            }
        } while (finalitzat != true);
    }

    public static void estatPenjat(int estat) {
        switch (estat) {
            case 0:
                System.out.println("   ____\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 1:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 2:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 3:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |    |\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 4:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |   /|\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 5:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |   /|\\\n"
                        + "  |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 6:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |   /|\\\n"
                        + "  |    |\n"
                        + "  |\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 7:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |   /|\\\n"
                        + "  |    |\n"
                        + "  |   / \n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
            case 8:
                System.out.println("   ____\n"
                        + "  |    |\n"
                        + "  |    o\n"
                        + "  |   /|\\\n"
                        + "  |    |\n"
                        + "  |   / \\\n"
                        + " _|_\n"
                        + "|   |______\n"
                        + "|          |\n"
                        + "|__________|");
                break;
        }

    }

    public static String paraulaAleatoria(String[] paraules) {
        String paraula;
        paraula = paraules[(int) (Math.random() * paraules.length)];
        return paraula;
    }

    public static void comprovaParaula(char paraulaCodificada[], char lletra, String paraula) {
        System.out.println("Paraula: ");
        for (int i = 0; i < paraulaCodificada.length; i++) {
            if (paraula.charAt(i) == Character.toLowerCase(lletra) || paraula.charAt(i) == Character.toUpperCase(lletra)) {
                paraulaCodificada[i] = Character.toLowerCase(lletra);
            }
        }
    }

    public static boolean comprovaEstat(char paraulaCodificada[], char lletra, String paraula, int estat) {
        for (int i = 0; i < paraulaCodificada.length; i++) {
            if (paraula.charAt(i) == Character.toLowerCase(lletra) || paraula.charAt(i) == Character.toUpperCase(lletra)) {
                return false;
            }
        }
        {
            System.out.println("sand");
            estat++;
            return true;
        }
    }
}
