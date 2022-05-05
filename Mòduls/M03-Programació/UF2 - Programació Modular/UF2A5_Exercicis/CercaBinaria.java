/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A5_Exercicis;

import static UF2A4_Exercicis.Ordenació.mostraVector;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class CercaBinaria {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int n;

        System.out.println("Llargada d'array: ");
        n = num.nextInt();
        int[] vector = generaVector(n);

        sort(vector);

        busquedaSequencial(num.nextInt(), vector);
        busquedaBinaria(num.nextInt(), vector);
    }

    public static void busquedaSequencial(int num, int vector[]) {
        int cont = 0;
        for (int i = 0; vector[i] != num; i++) {
            if (num == vector[i]) {
                System.out.println("Número " + num + " esta en la posició " + i);
            }
            cont++;
        }
        System.out.println("Steps: " + cont);
    }

    public static void busquedaBinaria(int num, int vector[]) {
        int low = 0, high = vector.length - 1, cont = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (vector[mid] == num) {
                System.out.println("Número " + num + " esta en la posició " + mid);
            }
            if (vector[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            cont++;
        }
        System.out.println("Steps: " + cont);
    }

    public static int[] generaVector(int numElements) {
        int[] vector = new int[numElements];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 5000);
            if (i == 35) {
                System.out.println("");
            }
        }
        return vector;

    }

    public static void sort(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < vector[i]) {
                    n = j;
                }
            }
            int numPetit = vector[n];
            vector[n] = vector[i];
            vector[i] = numPetit;
        }
        mostraVector(vector);
        System.out.println("");
    }
}
