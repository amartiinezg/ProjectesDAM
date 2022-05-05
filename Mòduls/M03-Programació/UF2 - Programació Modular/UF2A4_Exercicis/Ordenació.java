/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A4_Exercicis;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ordenació {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Número d'elements: ");
        int[] vector = generaVector(num.nextInt());
        int[] vector2 = {4, 14, 56, 34, 2, 4, 6, 9};

        mostraVector(vector);
        System.out.println("");
        System.out.println("==========");
        ordenaSeleccio(vector);
        System.out.println("");
        
    }

    public static int[] generaVector(int numElements) {
        int[] vector = new int[numElements];
        int cont = 0;
        for (int i = numElements; i >= 1; i--) {
            vector[cont] = i;
            cont++;
        }
        return vector;

    }

    public static void mostraVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public static void ordenaSeleccio(int[] vector) {
        for (int i = 0; i < vector.length-1; i++) {
            int n = i;
            for (int j = i+1; j < vector.length; j++) {
                if (vector[j] < vector[i]) {
                    n = j;              
                }
            }
            int numPetit = vector[n];
            vector[n] = vector[i];
            vector[i] = numPetit;
        }
    mostraVector(vector);
    }
    /*
    ORDENA BOMBOLLA
    
    public class JavaExample {
   public static void main(String []args) {
	String str[] = { "Ajeet", "Steve", "Rick", "Becky", "Mohan"};
	String temp;
	System.out.println("Strings in sorted order:");
	for (int j = 0; j < str.length; j++) {
   	   for (int i = j + 1; i < str.length; i++) {
		// comparing adjacent strings
		if (str[i].compareTo(str[j]) < 0) {
			temp = str[j];
			str[j] = str[i];
			str[i] = temp;
		}
	   }
	   System.out.println(str[j]);
	}
   }
}*/

}


// EXAMEN UF2 M03
// While
// Scanner
// Metode Split()
// Compare to
// Equals
// Random
// Controlar els minims i maxims dels arrays
// Cerca Binaria
// Algoritmes d'ordenacio (Bombolla i Seleccio)
// Metodes Void i Metodes que retornen coses
// (Opcional) Metode trim()
// (Pot sortir algo més)