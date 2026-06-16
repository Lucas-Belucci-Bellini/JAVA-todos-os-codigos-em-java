import java.util.Scanner;

public class MaiorPorLinha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }

        System.out.println();
        for (int i = 0; i < 3; i++) {
            int maior = matriz[i][0];
            int colMaior = 0;
            for (int j = 1; j < 3; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                    colMaior = j;
                }
            }
            System.out.println("Linha " + i + ": maior valor = " + maior +
                    " na posicao [" + i + "][" + colMaior + "]");
        }
    }
}