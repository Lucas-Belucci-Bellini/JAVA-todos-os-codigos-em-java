import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int[] vetor = new int[20];
        int indice = 0;
        
        // Preencher o vetor com números pares entre 50 e 150
        for (int i = 50; i <= 150 && indice < 20; i += 2) {
            vetor[indice] = i;
            indice++;
        }
        
        // Exibir o vetor
        System.out.println("Vetor preenchido:");
        for (int i = 0; i < 20; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        
        // Solicitar número ao usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para procurar: ");
        int numeroProcurado = scanner.nextInt();
        
        // Procurar o número no vetor
        int posicaoEncontrada = -1;
        for (int i = 0; i < 20; i++) {
            if (vetor[i] == numeroProcurado) {
                posicaoEncontrada = i;
                break;
            }
        }
        
        // Exibir resultado
        if (posicaoEncontrada != -1) {
            System.out.println("Número encontrado na posição: " + posicaoEncontrada);
        } else {
            System.out.println("Número não encontrado no vetor.");
        }
        
        scanner.close();
    }
}
