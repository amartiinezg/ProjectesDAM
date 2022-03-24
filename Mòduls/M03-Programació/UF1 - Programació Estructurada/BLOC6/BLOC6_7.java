/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLOC6;

import java.util.Scanner;

/**
 *
 * @author Ángel
 */
public class BLOC6_7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        BLOC6_7_class2 departaments[] = new BLOC6_7_class2[4];
        BLOC6_7_class1 empleats[] = new BLOC6_7_class1[10];
        /*for (int i = 0; i < departaments.length; i++) {
            System.out.println("Departament " + i + ":");
            String departament = in.nextLine();
            System.out.println("Sou:");
            float sou = num.nextFloat();
            System.out.println("Hores:");
            int hores = num.nextInt();
        }*/
        departaments[0] = new BLOC6_7_class2(35, 1610, "Recursos Humans");
        departaments[1] = new BLOC6_7_class2(38, 1755, "Informática");
        departaments[2] = new BLOC6_7_class2(40, 1355, "Fabrica");
        departaments[3] = new BLOC6_7_class2(34, 1455, "Psicologia");
        emplenaEmpleats(empleats);
        imprimeix(departaments, empleats);
    }

    public static void emplenaEmpleats(BLOC6_7_class1 empleats[]) {
        empleats[0] = new BLOC6_7_class1("Joan Fatxò", 33, 648238437, "Informática");
        empleats[1] = new BLOC6_7_class1("Pere Miret", 45, 74375973, "Psicologia");
        empleats[2] = new BLOC6_7_class1("Aleix Vidal", 27, 67823583, "Informática");
        empleats[3] = new BLOC6_7_class1("Ivet Miralls", 24, 692834754, "Recursos Humans");
        empleats[4] = new BLOC6_7_class1("Carlos García", 41, 652375833, "Fabrica");
        empleats[5] = new BLOC6_7_class1("Claudia Serra", 22, 626384954, "Recursos Humans");
        empleats[6] = new BLOC6_7_class1("Ana Vila", 22, 628635928, "Recursos Humans");
        empleats[7] = new BLOC6_7_class1("Iris Herrerias", 22, 612847843, "Psicologia");
        empleats[8] = new BLOC6_7_class1("Francisco Javier", 22, 736389172, "Fabrica");
        empleats[9] = new BLOC6_7_class1("Juan Kalindo", 22, 683264734, "Fabrica");
    }

    public static void imprimeix(BLOC6_7_class2 departaments[], BLOC6_7_class1 empleats[]) {
        for (int i = 0; i < departaments.length; i++) {
            System.out.println("");
            System.out.println("-----------");
            System.out.println(departaments[i].getDepartamento());
            System.out.println("-----------");
            for (int j = 0; j < empleats.length; j++){
                if(departaments[i].getDepartamento().equals(empleats[j].getDepartament())){
                    System.out.println(empleats[j].getNom());
                }
            }
            
        }
    }
}
