import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] nomes = new String[5];
        double[][] notas = new double[5][3];
        double[] medias = new double[5];
        
        // Leitura dos dados dos alunos
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome do aluno " + (i + 1) + ": ");
            nomes[i] = sc.nextLine();
            
            for (int j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + " de " + nomes[i] + ": ");
                notas[i][j] = sc.nextDouble();
            }
            sc.nextLine(); // Limpar buffer
            
            medias[i] = (notas[i][0] + notas[i][1] + notas[i][2]) / 3;
        }
        
        // Calcular média da turma
        double mediaTurma = 0;
        for (int i = 0; i < 5; i++) {
            mediaTurma += medias[i];
        }
        mediaTurma /= 5;
        
        // Contar aprovados e acima da média
        int aprovados = 0;
        int acimaDaMedia = 0;
        
        for (int i = 0; i < 5; i++) {
            if (medias[i] >= 6.0) {
                aprovados++;
            }
            if (medias[i] > mediaTurma) {
                acimaDaMedia++;
            }
        }
        
        // Exibir resultados
        System.out.println("\n=== RESULTADO FINAL ===");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s: %.2f%n", nomes[i], medias[i]);
        }
        
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.printf("Média da turma: %.2f%n", mediaTurma);
        System.out.println("Alunos Aprovados: " + aprovados);
        System.out.println("Alunos acima da média: " + acimaDaMedia);
        
        sc.close();
    }
}
