import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> materias = criarQuestoesPorMateria();

        System.out.println("Gerador de prova (máximo 25 questões)");
        int quantidade = lerInteiro(scanner, "Quantidade de questões (1-25): ", 1, 25);
        int notaTotal = lerInteiro(scanner, "Nota total da prova (pontos inteiros): ", 1, 1000);
        String materiaEscolhida = escolherMateria(scanner, materias);

        List<Questao> prova = gerarProva(materias, materiaEscolhida, quantidade, notaTotal);
        imprimirProva(prova, notaTotal);
        scanner.close();
    }

    private static Map<String, List<String>> criarQuestoesPorMateria() {
        Map<String, List<String>> materias = new HashMap<>();

        materias.put("Matemática", List.of(
            "Resolva a expressão 3x + 5 = 20.",
            "Calcule a área de um triângulo com base 8 e altura 5.",
            "Qual é o valor de x na equação x^2 - 9 = 0?",
            "Transforme 25% em número decimal.",
            "Simplifique a fração 18/24."
        ));

        materias.put("Física", List.of(
            "Explique a diferença entre velocidade e aceleração.",
            "Calcule a força resultante de uma massa de 2 kg acelerando a 3 m/s^2.",
            "O que é energia cinética? Dê um exemplo.",
            "Descreva a lei da inércia de Newton.",
            "Como funciona um circuito em série?"
        ));

        materias.put("Português", List.of(
            "Identifique o sujeito da frase: 'O aluno leu o livro'.",
            "Classifique o verbo em 'elas cantaram bem'.",
            "Faça a concordância correta: 'Nós ___ felizes'.",
            "Explique a diferença entre 'por que' e 'porque'.",
            "Reescreva a frase no plural: 'O menino tem um caderno'."
        ));

        materias.put("Química", List.of(
            "O que é uma molécula? Dê um exemplo.",
            "Defina ácido e base segundo Arrhenius.",
            "Qual é a fórmula da água?",
            "Explique o que é uma reação de combustão.",
            "Quais são os estados físicos da matéria?"
        ));

        materias.put("História", List.of(
            "O que foi a Revolução Industrial?",
            "Cite uma consequência da Primeira Guerra Mundial.",
            "Quem foi um líder importante da independência do Brasil?",
            "Explique o conceito de democracia.",
            "O que é a Era dos Descobrimentos?"
        ));

        materias.put("Biologia", List.of(
            "O que é fotossíntese?",
            "Explique a função das células nervosas.",
            "Qual é a unidade básica da vida?",
            "Descreva o papel dos nutrientes no corpo humano.",
            "O que é um ecossistema?"
        ));

        materias.put("Inglês", List.of(
            "Traduza para o português: 'She is studying'.",
            "Escreva a forma passada de 'go'.",
            "Qual é o plural de 'child'?",
            "Formule uma pergunta simples em inglês.",
            "Explique quando usar 'a' e 'an'."
        ));

        return materias;
    }

    private static int lerInteiro(Scanner scanner, String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Entrada inválida. Digite um número inteiro.");
                continue;
            }
            int valor = scanner.nextInt();
            scanner.nextLine();
            if (valor < minimo || valor > maximo) {
                System.out.println("Valor deve estar entre " + minimo + " e " + maximo + ".");
                continue;
            }
            return valor;
        }
    }

    private static String escolherMateria(Scanner scanner, Map<String, List<String>> materias) {
        List<String> chaves = new ArrayList<>(materias.keySet());
        System.out.println("Escolha a matéria da prova:");
        System.out.println("0 - Todas as matérias");
        for (int i = 0; i < chaves.size(); i++) {
            System.out.println((i + 1) + " - " + chaves.get(i));
        }
        int escolha = lerInteiro(scanner, "Digite o número da opção: ", 0, chaves.size());
        if (escolha == 0) {
            return "Todas";
        }
        return chaves.get(escolha - 1);
    }

    private static List<Questao> gerarProva(Map<String, List<String>> materias, String materiaEscolhida, int quantidade, int notaTotal) {
        List<String> pool = new ArrayList<>();
        if ("Todas".equals(materiaEscolhida)) {
            materias.values().forEach(pool::addAll);
        } else {
            pool.addAll(materias.get(materiaEscolhida));
        }

        List<Questao> prova = new ArrayList<>();
        Random random = new Random();
        int tamanho = pool.size();
        int base = notaTotal / quantidade;
        int resto = notaTotal % quantidade;

        for (int i = 0; i < quantidade; i++) {
            if (tamanho == 0) {
                pool.add("Questão extra gerada automaticamente.");
                tamanho = pool.size();
            }
            int indice = random.nextInt(tamanho);
            String texto = pool.get(indice);
            pool.remove(indice);
            tamanho--;
            int notaQuestoes = base + (i < resto ? 1 : 0);
            prova.add(new Questao(texto, notaQuestoes));
        }
        return prova;
    }

    private static void imprimirProva(List<Questao> prova, int notaTotal) {
        System.out.println("\n--- Prova Gerada ---");
        for (int i = 0; i < prova.size(); i++) {
            Questao q = prova.get(i);
            System.out.println((i + 1) + ". [" + q.nota + " pontos] " + q.texto);
        }
        System.out.println("\nNota total da prova: " + notaTotal + " pontos");
    }

    private static class Questao {
        String texto;
        int nota;

        Questao(String texto, int nota) {
            this.texto = texto;
            this.nota = nota;
        }
    }
}
