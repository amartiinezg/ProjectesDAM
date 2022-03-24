package BLOC5;

import java.util.Scanner;

public class Bloc5proves {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner inNum = new Scanner(System.in);
        classCotxe concessionari[] = new classCotxe[3];
        for (int i = 0; i < concessionari.length; i++) {
            System.out.println("Marca:");
            String marca = in.nextLine();
            System.out.println("Model:");
            String model = in.nextLine();
            System.out.println("Potència:");
            int potencia = inNum.nextInt();
            System.out.println("És electric:");
            boolean electric = inNum.nextBoolean();

            concessionari[i] = new classCotxe(marca, model, potencia, electric);
        }
        imprimeix(concessionari);
        System.out.println("La potencia mitjana és " + mitjanaPotencia(concessionari));
        System.out.println("Hi ha " + noElectrics(concessionari) + " vehicles no elèctrics");
        augmentaPotencia(concessionari);
    }

    public static void imprimeix(classCotxe[] taller) {
        System.out.println("Impressió de l'array");
        for (int i = 0; i < taller.length; i++) {
            taller[i].imprimeix();
        }
    }

    public static double mitjanaPotencia(classCotxe[] taller) {
        int sumaPot = 0;
        for (int i = 0; i < taller.length; i++) {
            sumaPot += taller[i].getPotencia();
        }
        double mitjana = (float) sumaPot / taller.length;
        return mitjana;
    }

    public static int noElectrics(classCotxe[] taller) {
        int noElec = 0;
        for (int i = 0; i < taller.length; i++) {
            if (taller[i].isElectric() == true) {
                noElec++;
            }
        }
        return noElec;
    }

    public static void augmentaPotencia(classCotxe[] taller) {
        for (int i = 0; i < taller.length; i++) {
            taller[i].augmentaPotencia(10);
            System.out.println("El vehicle " + taller[i].getMarca()
                    + " ara te " + taller[i].getPotencia());
        }
    }
}
