/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3_Pràctica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Ex01_LOL {

    public static void main(String[] args) {
        
        String rutaArchiu = "C:\\Users\\Ángel\\Documents\\1 DAM\\M03 Programació\\UF3\\UF3_Practica\\";
        String path = (rutaArchiu + "resultatsLOL.txt");
        
        String filename = (rutaArchiu + "classificacioLOL.txt");
        FileReader fr;
        try {
            fr = new FileReader(path);

            BufferedReader br = new BufferedReader(fr);
            String linea, local, visitant;
            int arrSize = 0, loop = 0, pLocal, pVisitant, i;
            ArrayList<String> arrEquips = new ArrayList<String>();
            ArrayList<Integer> arrPunts = new ArrayList<Integer>();
            while ((linea = br.readLine()).length() > 0) {
                arrSize++;
                local = (linea.split("-")[0].split(":")[0]);
                pLocal = Integer.parseInt((linea.split("-")[0].split(":")[1]));
                pVisitant = Integer.parseInt((linea.split("-")[1].split(":")[1]));
                visitant = (linea.split("-")[1].split(":")[0]);

                arrPunts.add(pLocal);
                arrPunts.add(pVisitant);
                arrEquips.add(local);
                arrEquips.add(visitant);
            }

            classificacioLOL[] classificacio = new classificacioLOL[arrSize * 2];
            emplenaEquips(arrPunts, arrEquips, classificacio);

            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    pLocal = Integer.parseInt((linea.split("-")[0].split(":")[1]));
                    pVisitant = Integer.parseInt((linea.split("-")[1].split(":")[1]));
                    local = (linea.split("-")[0].split(":")[0]);
                    visitant = (linea.split("-")[1].split(":")[0]);

                    comprovaClassificacio(classificacio, pLocal, pVisitant, local, visitant);
                }
            }
            ordenacioClassificacio(classificacio);
            mostraVector(classificacio);
            
            write(filename, classificacio);

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }

    public static void emplenaEquips(ArrayList<Integer> punts, ArrayList<String> equips,
            classificacioLOL[] classificacio) {
        for (int i = 0; i < equips.size(); i++) {
            if (punts.get(i) > punts.get(i + 1)) {
                classificacio[i] = new classificacioLOL(equips.get(i), 1);
                classificacio[i + 1] = new classificacioLOL(equips.get(i + 1), 0);
            } else if (punts.get(i) < punts.get(i + 1)) {
                classificacio[i + 1] = new classificacioLOL(equips.get(i + 1), 1);
                classificacio[i] = new classificacioLOL(equips.get(i), 0);
            }
            i++;
        }
    }

    public static void comprovaClassificacio(classificacioLOL[] classificacio,
            int puntsLocal, int puntsVisitant, String equipLocal, String equipVisitant) {

        for (int i = 0; i < classificacio.length; i++) {
            if (classificacio[i].getEquip().equals(equipLocal)) {
                if (puntsLocal > puntsVisitant) {
                    classificacio[i].setPunts(classificacio[i].getPunts() + 1);
                }
            } else if (classificacio[i].getEquip().equals(equipVisitant)) {
                if (puntsVisitant > puntsLocal) {
                    classificacio[i].setPunts(classificacio[i].getPunts() + 1);
                }
            }
        }
    }

    public static void mostraVector(classificacioLOL[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i].getEquip() + " [Punts] -> " + vector[i].getPunts());
        }
    }

    public static void ordenacioClassificacio(classificacioLOL[] classificacio) {
        classificacioLOL aux;
        for (int i = 0; i < classificacio.length - 1; i++) {
            for (int j = i + 1; j < classificacio.length; j++) {
                int minimo = classificacio[j].getPunts();
                if (minimo > classificacio[i].getPunts()) {
                    aux = classificacio[i];
                    classificacio[i] = classificacio[j];
                    classificacio[j] = aux;
                }
            }
        }
    }

    public static void write(String filename, classificacioLOL[] classificacio) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < classificacio.length; i++) {

            outputWriter.write(classificacio[i].getEquip()+ " | Puntuació = " + classificacio[i].getPunts());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }
}
