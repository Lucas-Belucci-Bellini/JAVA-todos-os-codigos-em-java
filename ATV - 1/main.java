import java.util.Scanner;

public class main {
    
    // Função para calcular a média das alturas
    static double calcularMedia(double[] alturas) {
        double soma = 0;
        for (double altura : alturas) {
            soma += altura;
        }
        return soma / alturas.length;
    }
    
    // Procedimento para exibir os resultados finais
    static void exibirResultados(double[] alturas, double media) {
        double maiorAltura = alturas[0];
        double menorAltura = alturas[0];
        int acimaDaMedia = 0;
        
        for (double altura : alturas) {
            if (altura > maiorAltura) {
                maiorAltura = altura;
            }
            if (altura < menorAltura) {
                menorAltura = altura;
            }
            if (altura > media) {
                acimaDaMedia++;
            }
        }
        
        System.out.println("\n========== RESULTADOS ==========");
        System.out.printf("Maior altura: %.2f m\n", maiorAltura);
        System.out.printf("Menor altura: %.2f m\n", menorAltura);
        System.out.printf("Média das alturas: %.2f m\n", media);
        System.out.printf("Pessoas com altura acima da média: %d\n", acimaDaMedia);
        System.out.println("================================\n");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] alturas = new double[10];
        
        // Receber as alturas de 10 pessoas
        System.out.println("=== CONTROLE DE ALTURAS ===\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a altura da pessoa " + (i + 1) + " (em metros): ");
            alturas[i] = scanner.nextDouble();
        }
        
        // Mostrar todas as alturas cadastradas
        System.out.println("\n--- Alturas Cadastradas ---");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Pessoa %d: %.2f m\n", (i + 1), alturas[i]);
        }
        
        // Calcular a média
        double media = calcularMedia(alturas);
        
        // Exibir resultados finais
        exibirResultados(alturas, media);
        
        scanner.close();
    }
}
