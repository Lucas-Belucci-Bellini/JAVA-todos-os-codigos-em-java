import java.util.Scanner;

public class SomaMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] matriz = new double[4][4];
        double soma = 0.0;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
                soma += matriz[i][j];
            }

        double media = soma / 16.0;
        System.out.println("\nSoma total: " + soma);
        System.out.println("Media: " + media);
    }
}


