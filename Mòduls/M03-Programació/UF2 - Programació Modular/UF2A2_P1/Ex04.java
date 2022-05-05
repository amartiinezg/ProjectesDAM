/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_P1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] paisos = new String[in.nextInt()];
        in.nextLine();
        paisos = generaVector(paisos, in);
        ordenaBombolla(paisos);
        String busquedaPais = in.nextLine();
        //mostraVector(paisos);
        busquedaBinaria(busquedaPais, paisos);
    }

    public static String[] generaVector(String[] paisos, Scanner in) {
        for (int i = 0; i < paisos.length; i++) {
            paisos[i] = in.nextLine();
        }
        return paisos;
    }

    public static void mostraVector(String[] vector) {
        for (int i = 0; i < vector.length; i++) {
            //System.out.print("("+i+")"+vector[i] + " ");
        }
    }

    public static void ordenaBombolla(String[] paisos) {
        String temp;
        for (int j = 0; j < paisos.length; j++) {
            for (int i = j + 1; i < paisos.length; i++) {
                // Comparació de Strings
                if (paisos[i].compareTo(paisos[j]) < 0) {
                    temp = paisos[j];
                    paisos[j] = paisos[i];
                    paisos[i] = temp;
                }
            }
            //System.out.println(paisos[j]);
        }
    }

    public static void busquedaBinaria(String pais, String vector[]) {
        int low = 0, high = vector.length - 1, cont = 0, mid = -1;
        boolean trobat = false;
        String posicio;
        while (low <= high && !trobat) {
            mid = (high + low) / 2;
            if (vector[mid].equals(pais)) {
                trobat = true;
            }
            if (vector[mid].compareTo(pais) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            cont++;
        }

        System.out.println("Total passades: " + cont);
        if (trobat != true) {
            System.out.println("No trobat");
        } else {
            System.out.println("Trobat a la posició: " + mid);
        }
    }
}
