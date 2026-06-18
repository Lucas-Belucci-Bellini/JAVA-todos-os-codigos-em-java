import java.util.Arrays;

/*
 Revisão Completa de Java - versão comentada e com exemplos.

 Este arquivo foi criado para reunir os principais conceitos estudados,
 com explicações em português e exemplos práticos. Ele não apenas mostra
 estruturas de controle e funções, mas também descreve o raciocínio por trás
 de cada tópico.

 O objetivo aqui é oferecer uma revisão extensa e detalhada, indicada para
 quem já passou por lógica, controle de fluxo, modularização, recursão,
 vetores e matrizes.
*/
public class RevisaoJava1 {

    public static void main(String[] args) {
        System.out.println("Revisão completa de Java\n");

        // 1. CONDITIONALS: if/else
        System.out.println("1. Condicionais (if/else)");
        double nota = 7.2;
        System.out.println("Nota: " + nota + " => " + verificarAprovacao(nota));
        int idade = 17;
        System.out.println("Idade: " + idade + " => " + classificarCorredor(idade, 12.5));

        // 2. SWITCH / CASE
        System.out.println("\n2. Switch / Case");
        exibirMenu(3);

        // 3. LAÇOS DE REPETIÇÃO
        System.out.println("\n3. Laços de repetição");
        System.out.println("Soma de 1 a 5 = " + somarAte(5));
        System.out.println("Fatorial iterativo de 5 = " + fatorialIterativo(5));
        System.out.println("Fatorial recursivo de 5 = " + fatorialRecursivo(5));

        // 4. MODULARIZAÇÃO
        System.out.println("\n4. Modularização");
        double media = calcularMedia(8.5, 7.8, 9.1);
        System.out.println("Média calculada = " + media);
        System.out.println("Resultado final = " + verificarAprovacao(media));

        // 5. VETORES
        System.out.println("\n5. Vetores");
        int[] vetor = criarVetorComValores(5);
        System.out.println("Vetor criado: " + Arrays.toString(vetor));
        System.out.println("Maior valor no vetor = " + encontrarMaior(vetor));

        // 6. MATRIZES
        System.out.println("\n6. Matrizes");
        int[][] matriz = criarMatriz(3, 4);
        imprimirMatriz(matriz);
        analisarMatriz(matriz);

        // 7. CLASSE Arrays
        System.out.println("\n7. Classe Arrays");
        exemploArraysClass();

        // 8. Análise de log de erro simples
        System.out.println("\n8. Análise de log de erro");
        String log = "ERROR: NullPointerException na linha 42 do arquivo App.java";
        analisarLogDeErro(log);
    }

    // Exemplo de condicional com retorno de String
    public static String verificarAprovacao(double notaFinal) {
        // Em Java, o if/else é a estrutura básica para tomar decisões.
        if (notaFinal >= 7.0) {
            return "Aprovado";
        } else if (notaFinal >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static String classificarCorredor(int idade, double tempo) {
        // A lógica pode usar if encadeados para combinar várias condições.
        if (idade < 18) {
            return "Corredor Iniciante";
        } else if (tempo <= 10.0) {
            return "Corredor Avançado";
        } else {
            return "Corredor Intermediário";
        }
    }

    // Exemplo de switch/case com menu
    public static void exibirMenu(int opcao) {
        System.out.println("Opção escolhida: " + opcao);
        switch (opcao) {
            case 1:
                System.out.println("Cadastro de aluno");
                break;
            case 2:
                System.out.println("Relatório de notas");
                break;
            case 3:
                System.out.println("Sair do sistema");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    // Exemplo de laço de repetição with for
    public static int somarAte(int n) {
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i; // soma = soma + i
        }
        return soma;
    }

    // Exemplo de laço for para calcular fatorial
    public static int fatorialIterativo(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i; // resultado = resultado * i
        }
        return resultado;
    }

    // Exemplo de recursão: fatorial
    public static int fatorialRecursivo(int n) {
        if (n <= 1) {
            return 1; // caso base
        }
        return n * fatorialRecursivo(n - 1); // chamada recursiva
    }

    // Exemplo de modularização: função que calcula média de três notas
    public static double calcularMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Vetor: array unidimensional com valores de exemplo
    public static int[] criarVetorComValores(int tamanho) {
        int[] valores = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            valores[i] = (i + 1) * 10; // 10, 20, 30...
        }
        return valores;
    }

    public static int encontrarMaior(int[] vetor) {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    // Matriz: array bidimensional com explicação de linhas e colunas
    public static int[][] criarMatriz(int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = i * colunas + j + 1; // preenche sequencialmente
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void analisarMatriz(int[][] matriz) {
        int soma = 0;
        int maiorLinha0 = matriz[0][0];
        int pares = 0;
        int impares = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int valor = matriz[i][j];
                soma += valor;
                if (valor % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }
                if (i == 0 && valor > maiorLinha0) {
                    maiorLinha0 = valor;
                }
            }
        }

        System.out.println("Soma de todos os elementos = " + soma);
        System.out.println("Pares = " + pares + ", Ímpares = " + impares);
        System.out.println("Maior valor na primeira linha = " + maiorLinha0);
        System.out.println("Diagonal principal: " + Arrays.toString(extrairDiagonalPrincipal(matriz)));
        System.out.println("Diagonal secundária: " + Arrays.toString(extrairDiagonalSecundaria(matriz)));
    }

    public static int[] extrairDiagonalPrincipal(int[][] matriz) {
        int tamanho = Math.min(matriz.length, matriz[0].length);
        int[] diagonal = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            diagonal[i] = matriz[i][i];
        }
        return diagonal;
    }

    public static int[] extrairDiagonalSecundaria(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int tamanho = Math.min(linhas, colunas);
        int[] diagonal = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            diagonal[i] = matriz[i][colunas - 1 - i];
        }
        return diagonal;
    }

    // Exemplo de uso de classe de utilitários Arrays
    public static void exemploArraysClass() {
        int[] numeros = {5, 1, 8, 3, 2};
        System.out.println("Array original: " + Arrays.toString(numeros));

        Arrays.sort(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(numeros));

        int indice = Arrays.binarySearch(numeros, 3);
        System.out.println("Busca binária do valor 3, posição: " + indice);

        int[] copia = Arrays.copyOf(numeros, numeros.length);
        System.out.println("Cópia do array: " + Arrays.toString(copia));
    }

    // Exemplo simples de análise de log de erro usando String
    public static void analisarLogDeErro(String log) {
        System.out.println("Log recebido: " + log);
        if (log.contains("NullPointerException")) {
            System.out.println("Possível causa: objeto nulo em Java.");
        }
        if (log.contains("linha")) {
            String[] partes = log.split("linha");
            if (partes.length > 1) {
                System.out.println("Linha do erro extraída: " + partes[1].trim());
            }
        }
    }

    /*
      Observações finais:

      - A revisão acima mostra que Java exige tipos explícitos, que ajudam
        tanto no desenvolvimento quanto na manutenção do código.
      - A modularização com métodos permite reutilizar código e tornar o sistema
        mais legível.
      - A recursão é poderosa, mas deve ter sempre um caso base claro.
      - Vetores e matrizes são fundamentais para organizar informações em
        coleções e tabelas.
      - A próxima etapa natural em Java é Programação Orientada a Objetos (POO),
        onde se estuda classes, objetos, atributos, métodos, encapsulamento,
        herança e polimorfismo.

      Esta revisão foca em código Java real e em explicações, não apenas em
      palavras. Cada método exemplifica uma prática que você já estudou, com
      comentários para reforçar o aprendizado.
    */
}
