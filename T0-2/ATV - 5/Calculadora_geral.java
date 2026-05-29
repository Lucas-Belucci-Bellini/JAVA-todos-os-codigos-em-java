import java.util.Scanner;

public class Calculadora_geral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("===== Calculadora Geral =====");
            System.out.println("1 - Calculadora Básica");
            System.out.println("2 - Calculadora Científica");
            System.out.println("3 - Tipos de Calculadoras");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    calculadoraBasica(scanner);
                    break;
                case 2:
                    calculadoraCientifica(scanner);
                    break;
                case 3:
                    mostrarTiposCalculadoras();
                    break;
                case 0:
                    System.out.println("Encerrando a calculadora. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void calculadoraBasica(Scanner scanner) {
        System.out.println("--- Calculadora Básica ---");
        System.out.print("Digite o primeiro número: ");
        double a = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double b = scanner.nextDouble();

        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Escolha a operação: ");
        int operacao = scanner.nextInt();

        double resultado;
        switch (operacao) {
            case 1:
                resultado = a + b;
                System.out.println("Resultado: " + resultado);
                break;
            case 2:
                resultado = a - b;
                System.out.println("Resultado: " + resultado);
                break;
            case 3:
                resultado = a * b;
                System.out.println("Resultado: " + resultado);
                break;
            case 4:
                if (b == 0) {
                    System.out.println("Erro: divisão por zero.");
                } else {
                    resultado = a / b;
                    System.out.println("Resultado: " + resultado);
                }
                break;
            default:
                System.out.println("Operação inválida.");
        }
    }

    private static void calculadoraCientifica(Scanner scanner) {
        System.out.println("--- Calculadora Científica ---");
        System.out.println("1 - Raiz quadrada");
        System.out.println("2 - Potência");
        System.out.println("3 - Seno");
        System.out.println("4 - Cosseno");
        System.out.println("5 - Tangente");
        System.out.println("6 - Logaritmo natural");
        System.out.print("Escolha a operação: ");
        int operacao = scanner.nextInt();

        double valor;
        switch (operacao) {
            case 1:
                System.out.print("Digite o número: ");
                valor = scanner.nextDouble();
                if (valor < 0) {
                    System.out.println("Erro: valor negativo para raiz quadrada.");
                } else {
                    System.out.println("Resultado: " + Math.sqrt(valor));
                }
                break;
            case 2:
                System.out.print("Digite a base: ");
                double base = scanner.nextDouble();
                System.out.print("Digite o expoente: ");
                double expoente = scanner.nextDouble();
                System.out.println("Resultado: " + Math.pow(base, expoente));
                break;
            case 3:
                System.out.print("Digite o ângulo em graus: ");
                valor = scanner.nextDouble();
                System.out.println("Resultado: " + Math.sin(Math.toRadians(valor)));
                break;
            case 4:
                System.out.print("Digite o ângulo em graus: ");
                valor = scanner.nextDouble();
                System.out.println("Resultado: " + Math.cos(Math.toRadians(valor)));
                break;
            case 5:
                System.out.print("Digite o ângulo em graus: ");
                valor = scanner.nextDouble();
                System.out.println("Resultado: " + Math.tan(Math.toRadians(valor)));
                break;
            case 6:
                System.out.print("Digite o número: ");
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("Erro: logaritmo definido apenas para valores positivos.");
                } else {
                    System.out.println("Resultado: " + Math.log(valor));
                }
                break;
            default:
                System.out.println("Operação inválida.");
        }
    }

    private static void mostrarTiposCalculadoras() {
        System.out.println("--- Tipos de Calculadoras ---");
        System.out.println("Calculadoras Básicas: realizam operações básicas como +, -, *, /, raiz quadrada e porcentagem.");
        System.out.println("Calculadoras Científicas: adicionam funções trigonométricas, logaritmos, exponenciais e notação científica.");
        System.out.println("Calculadoras Financeiras: projetadas para cálculos de juros, amortizações e fluxo de caixa.");
        System.out.println("Calculadoras Gráficas: desenham gráficos e ajudam em funções e matrizes complexas.");
        System.out.println("Calculadoras de Programador: trabalham com bases binária, octal e hexadecimal e operações lógicas.");
        System.out.println("Calculadoras Online/Específicas: ferramentas para cálculos especializados como IMC, impostos e finanças pessoais.");
    }
}
