/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A2_Exercicis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author HP
 */
public class Ex01 {

    public static void main(String[] args) {
        String path = "C:\\Users\\Ángel\\Documents\\1 DAM\\M03 Programació\\UF3\\Ex01_UF3A2\\resultats.txt";

        FileReader fr;
        try {
            fr = new FileReader(path);

            BufferedReader br = new BufferedReader(fr);
            String linea, local, visitant;
            classificacio[] classificacio = new classificacio[20];
            int loop = 0, golsLocal, golsVisitant, i = 0;
            emplenaEquips(classificacio);

            while ((linea = br.readLine()) != null) {
                golsLocal = Integer.parseInt(linea.split("-")[0].split(":")[1]);
                golsVisitant = Integer.parseInt(linea.split("-")[1].split(":")[1]);

                String prueba;
                local = (linea.split("-")[0].split(":")[0]);
                visitant = (linea.split("-")[1].split(":")[0]);

                if (i < 20) {
                    do {
                        if (classificacio[i] == null) {
                            classificacio[i] = new classificacio(local, 0, 0, 0);
                        }
                        if (classificacio[i + 1] == null) {
                            classificacio[i + 1] = new classificacio(visitant, 0, 0, 0);
                            System.out.println(classificacio[i].getEquip());
                        }
                    } while (i % 2 != 0);
                    i = i + 2;
                }
                
                
                for (int j = 0; j < classificacio.length; j++) {
                    int cont = 0;
                    //System.out.println(classificacio[2].getEquip() + "------>");
                    /*if (local.equals(classificacio[j].getEquip())) {
                        if (golsLocal > golsVisitant) {
                            classificacio[j].setGuanyat(cont++);
                        } else if (golsLocal < golsVisitant) {
                            classificacio[j].setPerdut(cont++);
                        } else {
                            classificacio[j].setEmpat(cont++);
                        }
                    }
                    else if (visitant.equals(classificacio[j].getEquip())) {
                        if (golsLocal > golsVisitant) {
                            classificacio[j].setGuanyat(cont++);
                        } else if (golsLocal < golsVisitant) {
                            classificacio[j].setPerdut(cont++);
                        } else {
                            classificacio[j].setEmpat(cont++);
                        }
                    }*/
                }
            }
            mostraVector(classificacio);

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    public static void emplenaEquips(classificacio[] equips) {
    }

    public static void mostraVector(classificacio[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i].toString());
        }
    }
}
