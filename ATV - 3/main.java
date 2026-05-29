import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double valor1 = entrada.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = entrada.nextDouble();

        mostrarResultado("Soma", soma(valor1, valor2));
        mostrarResultado("Subtração", subtracao(valor1, valor2));
        mostrarResultado("Multiplicação", multiplicacao(valor1, valor2));
        mostrarResultado("Divisão", divisao(valor1, valor2));
        mostrarResultado("Exponenciação", potencia(valor1, valor2));
        mostrarResultado("Radiciação", radiciacao(valor1, valor2));

        entrada.close();
    }

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return a / b;
    }

    public static double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public static double radiciacao(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return Math.pow(a, 1.0 / b);
    }

    public static void mostrarResultado(String operacao, double valor) {
        if (Double.isNaN(valor)) {
            System.out.println(operacao + ": operação inválida");
        } else {
            System.out.println(operacao + ": " + valor);
        }
    }
}
