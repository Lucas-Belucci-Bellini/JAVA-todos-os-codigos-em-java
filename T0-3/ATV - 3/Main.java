import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];
        int qtdPares = 0;
        int qtdImpares = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número inteiro: ");
            numeros[i] = scanner.nextInt();
            if (numeros[i] % 2 == 0) {
                pares[qtdPares++] = numeros[i];
            } else {
                impares[qtdImpares++] = numeros[i];
            }
        }

        System.out.print("Números digitados: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.print("Pares: ");
        for (int i = 0; i < qtdPares; i++) {
            System.out.print(pares[i]);
            if (i < qtdPares - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        System.out.print("Ímpares: ");
        for (int i = 0; i < qtdImpares; i++) {
            System.out.print(impares[i]);
            if (i < qtdImpares - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
