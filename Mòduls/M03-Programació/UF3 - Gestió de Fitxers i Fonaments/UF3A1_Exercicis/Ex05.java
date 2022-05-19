/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3A1_Exercicis;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Ex05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        File f = new File(in.nextLine());

        System.out.println(f.length() + " Bytes");
        System.out.println(f.length() / 1024 + " KiloBytes");
        System.out.println(f.length() / Math.pow(1024, 2) + " MegaBytes");
    }
}

//C:\Users\Ángel\Downloads\ISOS\es-es_windows_server_2019_updated_aug_2021_x64_dvd_47104769.iso