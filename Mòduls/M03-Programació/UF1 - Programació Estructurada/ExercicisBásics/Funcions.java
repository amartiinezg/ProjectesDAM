/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisBásics;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Funcions {

    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        HolaMundo();
        System.out.println("Intro numeros:");
        int n1 = numero.nextInt(), n2 = numero.nextInt();
        System.out.println("La suma es " + Suma(n1,n2));
        System.out.println("Major que:");
        MajorQue(numero.nextInt());
    }

    public static void HolaMundo() {
        System.out.println("Hola Mundo.");
    }

    public static int Suma(int n1, int n2) {
        int suma = n1 + n2;
        return suma;
    }

    public static void MajorQue(int n1) {
        if (n1 > 0){
            System.out.println("El número es major que 0.");
        }
        else {
            System.out.println("El número es menor que 0.");
        }
    }
}
