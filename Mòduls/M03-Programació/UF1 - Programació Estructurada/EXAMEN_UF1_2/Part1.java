/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXAMEN_UF1_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HP
 *
 */
public class Part1 {

    public static final int FILES = 8;
    public static final int COLUMNES = 8;

    public static void main(String[] args) {
        //En un tauler de joc de taula de 8 x 8 caselles hi ha situades aleatòriament 5  'X' 
        //(Pots col.locar-les directament per codi) i volem col.locar 4 fitxes més amb la condició 
        //que no estiguin en contacte amb les vores ni en contacte amb cap fitxa ja existent. 
        String[][] tauler = new String[FILES][COLUMNES];
        emplenarTaula(tauler);
        introdueixFitxa(tauler);
        
// imprimeix(tauler);
    }

    public static void emplenarTaula(String tauler[][]) {
        for (int i = 0; i < FILES; i++) {
            for (int j = 0; j < COLUMNES; j++) {
                if (i == 1 && j == 2) {
                    tauler[i][j] = "X";
                } else if (i == 2 && j == 4) {
                    tauler[i][j] = "X";
                } else if (i == 4 && j == 7) {
                    tauler[i][j] = "X";
                } else if (i == 6 && j == 0) {
                    tauler[i][j] = "X";
                }
                else if (i == 7 && j == 7) {
                    tauler[i][j] = "X";
                }
                else{
                tauler[i][j] = "";
                }
            }
        }
    }
    public static void introdueixFitxa(String tauler[][]){
    Scanner introFitxa = new Scanner(System.in);
    Scanner introFitxa2 = new Scanner(System.in);
    boolean correcte = false;   
    int x, y;
    for(int i = 0; i < 4; i++){
        do {
        System.out.println("Escull la fila: ");
        x = introFitxa.nextInt();
            if (x >= 0 && x < 8){
            correcte = true;
            }
        } while (correcte == true);
        correcte = false;
        do {
        System.out.println("Escull la columna: ");
        y = introFitxa2.nextInt();
            if (y >= 0 && y < 8){
            correcte = true;
            }
        } while (correcte == true);
        System.out.println("Has introduit la " + (i+1) + " fitxa en la casella "
                + x + " : " + y);
        }
        System.out.println("Ja has introduit totes les fitxes.");

    }
    public static void imprimeix(String tauler[][]) {
        for (int i = 0; i < FILES; i++) {
            for (int j = 0; j < COLUMNES; j++) {
            System.out.println(tauler[i][j]);
            }

        }
    }

}
        /* for (int i = 0; i < FILES; i++) {
            for (int j = 0; j < COLUMNES; j++){
                
            }
        }*/