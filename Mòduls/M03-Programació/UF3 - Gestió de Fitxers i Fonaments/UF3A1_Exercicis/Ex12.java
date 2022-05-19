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
public class Ex12 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String nomFitxer = preguntaNomFitxer(in);
        File rutaCarpeta = llegirRutaCarpeta();
        System.out.println("----------");
        cerca(rutaCarpeta, nomFitxer);
    }

    public static String preguntaNomFitxer(Scanner in) {
        System.out.println("Quin és el nom del fitxer a buscar?");
        return in.nextLine();
    }

    public static File llegirRutaCarpeta() {
        File file = null;
        boolean preguntar = true;
        Scanner lector = new Scanner(System.in);
        while (preguntar) {
            System.out.println("Escriu el nom d'una ruta a una carpeta: ");
            String nomCarpeta = lector.nextLine();
            file = new File(nomCarpeta);
            if (file.isDirectory()) {
                preguntar = false;
            } else {
                System.out.println("Aquesta carpeta no existeix...");
            }
        }
        return file;
    }
    
        public static void cerca(File carpeta, String nom) {
        File[] elements = carpeta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isDirectory()) {
                cerca(elements[i], nom);
            } else {
                String nomElement = elements[i].getName();
                if (nomElement.equalsIgnoreCase(nom)) {
                    System.out.println("S'ha trobat el fitxer a: " + elements[i].getAbsolutePath());
                }
            }
        }

    }
}
