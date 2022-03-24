/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC5;
import java.util.Arrays;
/**
 *
 * @author Ángel
 */
public class MesMetodes {
    public static void main(String[] args) {

        String cadena = "Cadena per fer proves";

        // String: toCharArray
        char[] cadenaArr = new char[cadena.length()];
        cadenaArr = cadena.toCharArray();
        for (int i = 0; i < cadenaArr.length; i++) {
            System.out.println("Caràcter:" + cadenaArr[i]);
        }

        // String: split
        cadena = "Victor;Lino;12/12/1964;Sabadell";
        String[] cadenaStr = new String[4];
        cadenaStr = cadena.split(";");

        for (int i = 0; i < cadenaStr.length; i++) {
            System.out.println("Camp:" + cadenaStr[i]);
        }

        // Arrays: copyOf
        int[] arrInt = new int[]{2, 4, 6, 8, 0, 7, 5};
        int[] arrInt2 = Arrays.copyOf(arrInt, arrInt.length);
        // Podria ser més curt, i truncaria; o més llarg
        // i deixaria caselles sense assignar valor
        for (int i = 0; i < arrInt2.length; i++) {
            System.out.print(" " + arrInt2[i]);
        }

        // Arrays: equals
        // ArrInt i arrInt2 estan creats en l'apartat anterior i són iguals
        int[] arrInt3 = new int[]{9, 8, 7, 6, 5, 4, 3};
        boolean iguals = Arrays.equals(arrInt, arrInt2);
        if (iguals == true) {
            System.out.println(" Son iguals");
        }
        // o més elegant
        if (Arrays.equals(arrInt, arrInt2)) {
            System.out.println("Són iguals");
        } else {
            System.out.println("No són iguals");
        }

        // Arrays: fill
        // Faig una còpia de arrInt
        int[] arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
        // L'emplenem tot de 0
        Arrays.fill(arrInt4, 0);
        // Comprovem
        for (int i = 0; i < arrInt4.length; i++) {
            System.out.print(" " + arrInt4[i]);
        }
        // O emplenem una part
        // Tornem a regenerar l'array
        System.out.println("");
        arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
        // i substituim
        Arrays.fill(arrInt4, 1, 3, 0);
        // Comprovem
        for (int i = 0; i < arrInt4.length; i++) {
            System.out.print(" " + arrInt4[i]);
        }

        // Arrays: sort
        // Tornem a regenerar l'array
        System.out.println("");
        arrInt4 = Arrays.copyOf(arrInt, arrInt.length);
        // i substituim
        Arrays.sort(arrInt4);
        // Comprovem
        for (int i = 0; i < arrInt4.length; i++) {
            System.out.print(" " + arrInt4[i]);
        }        

        // Arrays : toString
        // Array de char a String
        cadenaArr = new char[] {'h','o','l','a'};
        cadena = Arrays.toString(cadenaArr);
        // Imprimim l'string
        System.out.println(cadena);
        
        // Array de int a String
        cadena = Arrays.toString(arrInt);
        // S'ha generat com string
        System.out.println(cadena);
        System.out.println(cadena.length());
        System.out.println(cadena.charAt(1));
    }
     
}
