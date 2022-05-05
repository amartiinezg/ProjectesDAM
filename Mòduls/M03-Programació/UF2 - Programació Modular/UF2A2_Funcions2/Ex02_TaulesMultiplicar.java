/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_Funcions2;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex02_TaulesMultiplicar {
    public static final int TOTALTAULESMOSTRA = 6;
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int totalTaules, taulaInici, taulaFinal;
        System.out.println("Quantes taules de multiplicar vols mostrar? ");
        totalTaules = num.nextInt();
        for (int taula = 0; taula < totalTaules; taula = taula + TOTALTAULESMOSTRA) {
            taulaInici = taula+1; 
            taulaFinal = Math.min(taula + TOTALTAULESMOSTRA,totalTaules);
            for (int i = 1; i <= 10; i++) {
                taules(taulaInici,taulaFinal, i);
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        }

    }

    public static void taules(int taulaInici, int taulaFinal, int n) {
        System.out.println(taulaFinal);
        for (int i = taulaInici; i <= taulaFinal; i++) {
            System.out.print(i + " x " + n + " = " + i * n + "\t");
        }
    }

    /*  // Mostra una línia d’una taula de multiplicar
static String muntarLiniaTaulaMultiplicar(int taula,int n);

    // Mostra una línia d’una sèrie de taules de multiplicar, començant per taulaInicial i acabant per taulaFinal.
static String muntarLiniaPantalla(int taulaInicial, int taulaFinal, int n);

    // Mostra un bloc de taules per pantalla des de taulaInicial fins taulaFinal.
static void mostrarBlocPantalla(int taulaInicial, int taulaFinal);*/
}
