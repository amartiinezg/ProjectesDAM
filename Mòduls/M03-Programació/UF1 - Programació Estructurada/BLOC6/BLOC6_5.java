/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC6_5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        classAlumnes5 alumnes[] = new classAlumnes5[3];
        System.out.println("Materia 1: ");
        String mat1 = in.nextLine();
        System.out.println("Materia 2: ");
        String mat2 = in.nextLine(); 
        System.out.println("Materia 3: ");
        String mat3 = in.nextLine();
        for (int i = 0; i < alumnes.length; i++){
            System.out.println("Nom: ");
            String nom = in.nextLine();
            System.out.println("NOTA - " + mat1);
            float not1 = num.nextFloat();
            System.out.println("NOTA - " + mat2); 
            float not2 = num.nextFloat();
            System.out.println("NOTA - " + mat3);
            float not3 = num.nextFloat();
            
            alumnes[i] = new classAlumnes5(nom, not1, mat1, not2, mat2, not3, mat3);
            System.out.println("---------");
        }
        imprimeix(alumnes);
    }
        public static void imprimeix(classAlumnes5 alumnes[]) {
        System.out.println("Impressió de l'array");
        for (int i = 0; i < alumnes.length; i++) {
            alumnes[i].imprimeix();
        }
    }
}
