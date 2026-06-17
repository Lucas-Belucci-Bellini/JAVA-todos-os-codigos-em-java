import java.util.Scanner;

public class SistemaEscolar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE NOTAS ESCOLARES ===");
        System.out.print("Informe a quantidade de alunos: ");
        int qtdAlunos = scanner.nextInt();
        scanner.nextLine(); 

        
        String[] nomes = new String[qtdAlunos];
        double[][] notas = new double[qtdAlunos][4]; 

        
        lerDados(scanner, qtdAlunos, nomes, notas);

        
        exibirRelatorio(qtdAlunos, nomes, notas);

        scanner.close();
    }

    

    
    public static void lerDados(Scanner scanner, int qtdAlunos, String[] nomes, double[][] notas) {
        System.out.println("\n--- ENTRADA DE DADOS ---");
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.print("\nNome do " + (i + 1) + "º aluno: ");
            nomes[i] = scanner.nextLine();

            
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota do " + (j + 1) + "º bimestre: ");
                notas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); 
        }
    }

    
    public static void exibirRelatorio(int qtdAlunos, String[] nomes, double[][] notas) {
        System.out.println("\n========== RELATÓRIO FINAL ==========");
        
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("Aluno: " + nomes[i]);
            
            
            System.out.print("Notas: ");
            for (int j = 0; j < 4; j++) {
                System.out.print(notas[i][j]);
                if (j < 3) { 
                    System.out.print(" | ");
                }
            }
            System.out.println(); 

            
            double media = calcularMedia(notas[i]);
            
            
            String situacao = verificarAprovacao(media);

           
            System.out.printf("Média Final: %.2f\n", media);
            System.out.println("Situação: " + situacao);
            System.out.println("------------------------------------");
        }
    }


    
    public static double calcularMedia(double[] notasDoAluno) {
        double soma = 0;
        for (int i = 0; i < 4; i++) {
            soma += notasDoAluno[i];
        }
        return soma / 4.0;
    }

    
    public static String verificarAprovacao(double media) {
        if (media >= 7.0) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
    }
}