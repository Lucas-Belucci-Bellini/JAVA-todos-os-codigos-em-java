import java.util.Arrays;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        int[] numeros = new int[15];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(101); // 0 a 100
        }

        System.out.println("Valores sorteados:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println("\n");

        int pares = 0;
        System.out.println("Valores pares:");
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                System.out.print(numero + " ");
                pares++;
            }
        }
        System.out.println("\nQuantidade de pares: " + pares + "\n");

        int acima50 = 0;
        System.out.println("Valores acima de 50:");
        for (int numero : numeros) {
            if (numero > 50) {
                System.out.print(numero + " ");
                acima50++;
            }
        }
        System.out.println("\nQuantidade acima de 50: " + acima50 + "\n");

        int[] ordenados = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(ordenados);
        System.out.println("Valores em ordem crescente:");
        for (int numero : ordenados) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
