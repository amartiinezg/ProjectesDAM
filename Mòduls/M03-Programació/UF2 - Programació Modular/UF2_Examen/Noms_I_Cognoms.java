/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2_Examen;

import java.util.Arrays;

/**
 *
 * @author HP
 */
public class Noms_I_Cognoms {

    public static void main(String[] args) {
        String[] nomsComplets = {"Torres Hernández, Pere",
            "Majoral Gatell, Anna",
            "Pérez Gomis, Josep",
            "López López, Rosa",
            "Camps García, Ricard",
            "Sánchez Pasqual, Carles",
            "Mengual Sánchez, Gemma",
            "Puig Soler, Jordi",};

        String nomsSplit = Arrays.toString(nomsComplets);
        String[] noms = nomsSplit.split(",");
        
        ordenaBombolla(nomsComplets, noms);
        mostraNoms(nomsComplets);
    }

    public static void ordenaBombolla(String[] nomsComplets, String[] noms) {
        String temp;
        for (int j = 0; j < nomsComplets.length; j++) {
            for (int i = j + 1; i < nomsComplets.length; i++) {
                if (nomsComplets[i].compareTo(nomsComplets[j]) < 0) {
                    temp = nomsComplets[j];
                    nomsComplets[j] = nomsComplets[i];
                    nomsComplets[i] = temp;
                }
            }
        }
    }

    public static void mostraNoms(String[] nomsComplets) {
        int num = 1;
        for (int i = 0; i < nomsComplets.length; i++) {
            num++;
            System.out.println(num + ". " + nomsComplets[i]);
        }
    }
}
