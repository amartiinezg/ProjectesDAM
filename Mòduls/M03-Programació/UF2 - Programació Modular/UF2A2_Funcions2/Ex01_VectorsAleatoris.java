/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF2A2_Funcions2;

/**
 *
 * @author HP
 */
public class Ex01_VectorsAleatoris {

    public static void main(String[] args) {
        final int ELEMENTS = 10;
        // A[]
        int[] a = vectorA(ELEMENTS);

        // B[]
        int[] b = vectorB(ELEMENTS);

        // C[]
        int[] c = vectorC(ELEMENTS, a, b);

        // Mostrar resultats A[], B[] i C[]
        mostraResultats(ELEMENTS, a, b, c);
    }

    public static int[] vectorA(int ELEMENTS) {
        int[] a = new int[ELEMENTS];
        for (int i = 0; i < ELEMENTS; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        return a;
    }

    public static int[] vectorB(int ELEMENTS) {
        int[] a = new int[ELEMENTS];
        int numero;
        for (int i = 0; i < ELEMENTS; i++) {
            numero = (int) (Math.random() * 1000);
            if (numero < 1000 && numero > 99) {
                a[i] = numero;  // completar
            }
        }
        return a;
    }

    public static int[] vectorC(int ELEMENTS, int a[], int b[]) {
        int[] c = new int[2 * ELEMENTS];
        for (int i = 0; i < 2 * ELEMENTS; i++) {
            if (i % 2 == 0) {
                c[i] = a[i / 2];
            } else {
                c[i] = b[i / 2];
            }
        }
        return c;
    }

    public static void mostraResultats(int ELEMENTS, int a[], int b[], int c[]) {
        System.out.print("A[] = ");
        for (int i = 0; i < ELEMENTS; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.print("B[] = ");
        for (int i = 0; i < ELEMENTS; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        System.out.print("C[] = ");
        for (int i = 0; i < 2 * ELEMENTS; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println();
    }
}
