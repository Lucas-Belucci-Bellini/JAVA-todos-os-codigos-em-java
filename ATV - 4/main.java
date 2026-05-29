import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int[] senhas = {5432, 1234, 9876, 4567, 2222, 9999};

        Arrays.sort(senhas);
        System.out.println("Vetor ordenado: " + Arrays.toString(senhas));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha para busca: ");
        int senhaBusca = scanner.nextInt();
        scanner.close();

        int posicao = Arrays.binarySearch(senhas, senhaBusca);
        if (posicao >= 0) {
            System.out.println("Senha encontrada na posicao: " + posicao);
        } else {
            System.out.println("Senha inexistente.");
        }
    }
}
