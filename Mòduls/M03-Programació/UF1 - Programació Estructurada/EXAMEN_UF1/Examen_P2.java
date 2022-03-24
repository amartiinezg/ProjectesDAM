/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXAMEN_UF1;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class Examen_P2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dni;
        int lletra;
        System.out.println("Introdueix el número: ");
        int numerodni = in.nextInt();
        lletra = numerodni % 23;
        System.out.println("El residu es " + lletra);
            switch (lletra) {
                case 0:
                    dni = numerodni + ("T");
                    System.out.println("El DNI es " + dni);
                    break;
                case 1:
                    dni = numerodni + ("R");
                    System.out.println("El DNI es " + dni);
                    break;
                case 2:
                    dni = numerodni + ("W");
                    System.out.println("El DNI es " + dni);
                    break;
                case 3:
                    dni = numerodni + ("A");
                    System.out.println("El DNI es " + dni);
                    break;
                case 4:
                    dni = numerodni + ("G");
                    System.out.println("El DNI es " + dni);
                    break;
                case 5:
                    dni = numerodni + ("M");
                    System.out.println("El DNI es " + dni);
                    break;
                case 6:
                    dni = numerodni + ("Y");
                    System.out.println("El DNI es " + dni);
                    break;
                case 7:
                    dni = numerodni + ("F");
                    System.out.println("El DNI es " + dni);
                    break;
                case 8:
                    dni = numerodni + ("P");
                    System.out.println("El DNI es " + dni);
                    break;
                case 9:
                    dni = numerodni + ("D");
                    System.out.println("El DNI es " + dni);
                    break;
                case 10:
                    dni = numerodni + ("X");
                    System.out.println("El DNI es " + dni);
                    break;
                case 11:
                    dni = numerodni + ("B");
                    System.out.println("El DNI es " + dni);
                    break;
                case 12:
                    dni = numerodni + ("N");
                    System.out.println("El DNI es " + dni);
                    break;
                case 13:
                    dni = numerodni + ("J");
                    System.out.println("El DNI es " + dni);
                    break;
                case 14:
                    dni = numerodni + ("Z");
                    System.out.println("El DNI es " + dni);
                    break;
                case 15:
                    dni = numerodni + ("S");
                    System.out.println("El DNI es " + dni);                    
                    break;
                case 16:
                    dni = numerodni + ("Q");
                    System.out.println("El DNI es " + dni);
                    break;
                case 17:
                    dni = numerodni + ("V");
                    System.out.println("El DNI es " + dni);
                    break;
                case 18:
                    dni = numerodni + ("H");
                    System.out.println("El DNI es " + dni);
                    break;
                case 19:
                    dni = numerodni + ("L");
                    System.out.println("El DNI es " + dni);
                    break;
                case 20:
                    dni = numerodni + ("C");
                    System.out.println("El DNI es " + dni);
                    break;
                case 21:
                    dni = numerodni + ("K");
                    System.out.println("El DNI es " + dni);
                    break;
                case 22:
                    dni = numerodni + ("E");
                    System.out.println("El DNI es " + dni);
                    break;
                default:
                    System.out.println("DNI no es vàlid.");
                    break;

            }
        }
    }
 
