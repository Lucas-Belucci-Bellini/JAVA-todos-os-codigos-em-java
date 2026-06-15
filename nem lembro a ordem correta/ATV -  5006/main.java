import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definir as perguntas
        String[] perguntas = {
            "1. Qual é a capital da França?",
            "2. Qual é o planeta mais próximo do Sol?",
            "3. Em que ano terminou a Segunda Guerra Mundial?",
            "4. Qual é o maior oceano da Terra?",
            "5. Quantos continentes existem?"
        };
        
        // Definir as opções de resposta
        String[][] opcoes = {
            {"A) Paris", "B) Lyon", "C) Marseille", "D) Nice"},
            {"A) Vênus", "B) Mercúrio", "C) Terra", "D) Marte"},
            {"A) 1943", "B) 1944", "C) 1945", "D) 1946"},
            {"A) Atlântico", "B) Índico", "C) Pacífico", "D) Ártico"},
            {"A) 5", "B) 6", "C) 7", "D) 8"}
        };
        
        // Definir as respostas corretas
        char[] respostasCorretas = {'A', 'B', 'C', 'C', 'C'};
        
        // Array para armazenar as respostas do usuário
        char[] respostasUsuario = new char[5];
        int acertos = 0;
        
        System.out.println("======================================");
        System.out.println("     PROGRAMA DE PERGUNTAS E RESPOSTAS");
        System.out.println("======================================\n");
        
        // Loop para cada pergunta
        for (int i = 0; i < perguntas.length; i++) {
            boolean respostaValida = false;
            
            while (!respostaValida) {
                System.out.println(perguntas[i]);
                for (String opcao : opcoes[i]) {
                    System.out.println(opcao);
                }
                
                System.out.print("Sua resposta (A/B/C/D): ");
                String entrada = scanner.nextLine().toUpperCase();
                
                if (entrada.length() == 1 && (entrada.equals("A") || entrada.equals("B") || entrada.equals("C") || entrada.equals("D"))) {
                    respostasUsuario[i] = entrada.charAt(0);
                    respostaValida = true;
                    
                    if (respostasUsuario[i] == respostasCorretas[i]) {
                        acertos++;
                        System.out.println("✓ Correto!\n");
                    } else {
                        System.out.println("✗ Incorreto! A resposta correta é " + respostasCorretas[i] + "\n");
                    }
                } else {
                    System.out.println("Entrada inválida! Digite A, B, C ou D.\n");
                }
            }
        }
        
        // Exibir resultado final
        System.out.println("\n======================================");
        System.out.println("           RESULTADO FINAL");
        System.out.println("======================================\n");
        
        for (int i = 0; i < perguntas.length; i++) {
            String resultado = (respostasUsuario[i] == respostasCorretas[i]) ? "✓ Acertou" : "✗ Errou";
            System.out.println("Questão " + (i + 1) + ": " + respostasUsuario[i] + " - " + resultado);
        }
        
        double nota = (acertos / 5.0) * 10;
        System.out.println("\nAcertos: " + acertos + " de 5");
        System.out.println("Nota Final: " + String.format("%.1f", nota));
        
        if (acertos == 5) {
            System.out.println("\n🎉 PARABÉNS! Você acertou todas as questões! 🎉");
        }
        
        System.out.println("\n======================================\n");
        
        scanner.close();
    }
}
