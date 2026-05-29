import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] velocidades = new double[12];

        System.out.println("Digite a velocidade de 12 veículos (km/h):");
        for (int i = 0; i < velocidades.length; i++) {
            System.out.print("Veículo " + (i + 1) + ": ");
            velocidades[i] = scanner.nextDouble();
        }

        System.out.println("\nVelocidades informadas:");
        for (double velocidade : velocidades) {
            System.out.printf("%.2f km/h\n", velocidade);
        }

        int acimaDe80 = 0;
        double soma = 0;
        double maior = velocidades[0];

        for (double velocidade : velocidades) {
            if (velocidade > 80) {
                acimaDe80++;
            }
            if (velocidade > maior) {
                maior = velocidade;
            }
            soma += velocidade;
        }

        double media = soma / velocidades.length;

        System.out.println("\nQuantidade de veículos acima de 80 km/h: " + acimaDe80);
        System.out.printf("Maior velocidade registrada: %.2f km/h\n", maior);
        System.out.printf("Média das velocidades: %.2f km/h\n", media);

        double[] velocidadesOrdenadas = Arrays.copyOf(velocidades, velocidades.length);
        Arrays.sort(velocidadesOrdenadas);
        System.out.println("Velocidades em ordem crescente:");
        for (double velocidade : velocidadesOrdenadas) {
            System.out.printf("%.2f km/h\n", velocidade);
        }

        scanner.close();
    }
}
