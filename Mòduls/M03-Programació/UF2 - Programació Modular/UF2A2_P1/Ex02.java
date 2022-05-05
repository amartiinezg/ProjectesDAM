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
public class Ex02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] temperatura = new double[in.nextInt()];
        temperatura = generaVector(temperatura, in);
        ordenaSeleccio(temperatura);

    }

    public static void mostraVector(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public static double[] generaVector(double[] temperatura, Scanner in) {
        for (int i = 0; i < temperatura.length; i++) {
            temperatura[i] = in.nextDouble();
        }
        return temperatura;
    }

    public static void ordenaSeleccio(double[] vector) {
        int passades = 0;
        for (int i = 0; i < vector.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < vector[i]) {
                    n = j;
                }
                passades++;
            }
            double numPetit = vector[n];
            vector[n] = vector[i];
            vector[i] = numPetit;
        }
        mostraVector(vector);
        System.out.println("");
        System.out.println("Total passades: " + passades);
    }
}
