/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A1_Exercicis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex13 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Escriu l'extensió origen i destí: ");
        String origen = in.next();
        String desti = in.next();

        String dirTreball = System.getProperty("user.dir");
        System.out.println(dirTreball);
        File rutaTreball = new File(dirTreball);

        File[] elements = rutaTreball.listFiles();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                canviaExtensio(elements[i], origen, desti);
            }
        }
    }

    public static void canviaExtensio(File ruta, String or, String des) {
        String nom = ruta.getName();
        int punt = nom.lastIndexOf(".");
        if (punt >= 0) {
            String extOrigen = nom.substring(punt + 1, nom.length());
            if (extOrigen.equals(or)) {
                String nouNom = nom.substring(0, punt + 1) + des;
                nouNom = ruta.getParent() + File.separator + nouNom;
                File novaRuta = new File(nouNom);
                ruta.renameTo(novaRuta);
            }
        }
    }
}
