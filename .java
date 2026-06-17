import java.util.Scanner;

public class SistemaEscolar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE NOTAS ESCOLARES ===");
        System.out.print("Informe a quantidade de alunos: ");
        int qtdAlunos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado (importante após ler número)

        // Declaração do vetor para os nomes e da matriz para as notas
        String[] nomes = new String[qtdAlunos];
        double[][] notas = new double[qtdAlunos][4]; // Matriz: Linhas = alunos, Colunas = 4 notas

        // Chamada do procedimento para ler os dados
        lerDados(scanner, qtdAlunos, nomes, notas);

        // Chamada do procedimento para exibir o relatório final
        exibirRelatorio(qtdAlunos, nomes, notas);

        scanner.close();
    }

    // ====================================================================
    // PROCEDIMENTOS (void - Sem retorno)
    // ====================================================================

    /**
     * Procedimento para ler os nomes e as notas preenchendo o vetor e a matriz.
     */
    public static void lerDados(Scanner scanner, int qtdAlunos, String[] nomes, double[][] notas) {
        System.out.println("\n--- ENTRADA DE DADOS ---");
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.print("\nNome do " + (i + 1) + "º aluno: ");
            nomes[i] = scanner.nextLine();

            // Loop para ler as 4 notas (4 bimestres)
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota do " + (j + 1) + "º bimestre: ");
                notas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Limpar o buffer para o próximo nome
        }
    }

    /**
     * Procedimento para exibir o relatório final, utilizando as funções auxiliares.
     */
    public static void exibirRelatorio(int qtdAlunos, String[] nomes, double[][] notas) {
        System.out.println("\n========== RELATÓRIO FINAL ==========");
        
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Aluno: " + nomes[i]);
            
            // Exibir as notas formatadas
            System.out.print("Notas: ");
            for (int j = 0; j < 4; j++) {
                System.out.print(notas[i][j]);
                if (j < 3) { // Coloca o separador " | " entre as notas, menos na última
                    System.out.print(" | ");
                }
            }
            System.out.println(); // Quebra de linha após as notas

            // Chama a função de calcular média passando as 4 notas do aluno atual
            double media = calcularMedia(notas[i]);
            
            // Chama a função de verificar aprovação passando a média
            String situacao = verificarAprovacao(media);

            // Exibe a média e a situação (%.2f garante duas casas decimais)
            System.out.printf("Média Final: %.2f\n", media);
            System.out.println("Situação: " + situacao);
            System.out.println("------------------------------------");
        }
    }


    // ====================================================================
    // FUNÇÕES (Com retorno de valores)
    // ====================================================================

    /**
     * Função que recebe um vetor com as notas de um único aluno e retorna a média.
     */
    public static double calcularMedia(double[] notasDoAluno) {
        double soma = 0;
        for (int i = 0; i < 4; i++) {
            soma += notasDoAluno[i];
        }
        return soma / 4.0;
    }

    /**
     * Função que recebe a média e retorna uma String dizendo se foi aprovado ou não.
     */
    public static String verificarAprovacao(double media) {
        if (media >= 7.0) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
    }
}