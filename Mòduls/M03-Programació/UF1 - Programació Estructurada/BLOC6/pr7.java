package BLOC6;

import java.util.Arrays;
import java.util.Scanner;

public class pr7 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        pr_employees[] treballadors = new pr_employees[5];
        pr7_departaments[] departaments = new pr7_departaments[3];
        
        emplenaDepartaments(departaments);
        emplenaEmpleats(treballadors);

        // Cerca dades per departament
        
       /* System.out.println("Intro departament: ");
        String dep = in.nextLine();
        cercaDadesDepartament(departaments, treballadors, dep);
*/
       
        //Canviar telèfon treballador 0
        
       /* System.out.println("Nou telèfon: ");
        String nouTelefon = in.nextLine();
        treballadors[0].setTelefon(nouTelefon);

        System.out.println(treballadors[0].getTelefon());
*/
    }

    public static void cercaDadesDepartament(
            pr7_departaments[] deps,
            pr_employees[] emp,
            String dep) {
        int hores = 1;
        double sou = 1;
        for (int i = 0; i < deps.length; i++) {
            if (deps[i].getNom().equals(dep)) {
                hores = deps[i].getHores();
                sou = deps[i].getSou();
            }
            break;
        }
        int treballador = 0;
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].getDepartament().equals(dep)) {
                treballador++;
            }
        }

        System.out.println("Departament:" + dep);
        System.out.println("Trebaladors: " + treballador);
        System.out.println("Sous: " + (sou * treballador));
        System.out.println("Hores: " + (hores * treballador));

    }

       public static void emplenaDepartaments(pr7_departaments[] departaments) {
        departaments[0] = new pr7_departaments("Comptable", 40, 1500);
        departaments[1] = new pr7_departaments("Direcció", 38, 1700);
        departaments[2] = new pr7_departaments("Vendes", 39, 1600);
    }


    public static void emplenaEmpleats(pr_employees[] workers) {
        Scanner in = new Scanner(System.in);
        System.out.println("TREBALLADOR 1 | Departament");
        String dep1 = in.nextLine();
        workers[0] = new pr_employees("Pepe", 23, "625458965", dep1); //Comptable
        System.out.println("TREBALLADOR 2 | Departament");
        String dep2 = in.nextLine();
        workers[1] = new pr_employees("Lluis", 25, "625458965", dep2); //Comptable
        System.out.println("TREBALLADOR 3 | Departament");
        String dep3 = in.nextLine();
        workers[2] = new pr_employees("Maria", 27, "626458965", dep3); //Direcció
        System.out.println("TREBALLADOR 4 | Departament");
        String dep4 = in.nextLine();
        workers[3] = new pr_employees("Julia", 23, "645458965", dep4); //Comptable
        System.out.println("TREBALLADOR 5 | Departament");
        String dep5 = in.nextLine();
        workers[4] = new pr_employees("José Luis", 43, "625458955", dep5); //Vendes
    }
}