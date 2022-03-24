/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A1_Practica1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex1 {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int n1 = 0, n2 = 0;
        String operacio;
        boolean sortir = false;

        do {
            if (num.hasNextInt()) {
                n1 = num.nextInt();
                n2 = num.nextInt();
                num.nextLine();  
                operacio = num.nextLine(); 
                switch (operacio) {
                    case "+":
                        suma(n1, n2);
                        break;
                    case "-":
                        restar(n1, n2);
                        break;
                    case "x":
                        multiplicar(n1, n2);
                        break;
                    case "/":
                        dividir(n1, n2);
                        break;
                    default:
                        System.out.println("Operació no vàlida, torna a intentar-ho");
                        break;
                }
            }
            else if (num.nextLine().equals("S")) {
                sortir = true;
            }
        } while (sortir != true);

    }

    public static void suma(int n1, int n2) {
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
    }

    public static void restar(int n1, int n2) {
        System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
    }

    public static void multiplicar(int n1, int n2) {
        System.out.println(n1 + " x " + n2 + " = " + (n1 * n2));
    }

    public static void dividir(int n1, int n2) {
        if (n2 != 0) {
        System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
        } else {
            System.out.println("No es pot dividir per 0.");
        }
    }
}
