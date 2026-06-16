import java.util.Scanner;

public class ContagemCondicional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][4];
        int pares = 0, impares = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }

        System.out.println("\nPosicoes dos numeros pares:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] % 2 == 0) {
                    pares++;
                    System.out.println("[" + i + "][" + j + "] = " + matriz[i][j]);
                } else {
                    impares++;
                }
            }

        System.out.println("\nTotal de pares: " + pares);
        System.out.println("Total de impares: " + impares);
    }
}