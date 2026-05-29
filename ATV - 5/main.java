import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vendas = new double[7];

        System.out.println("Informe as vendas dos 7 dias da semana:");
        for (int i = 0; i < vendas.length; i++) {
            System.out.printf("Dia %d: ", i + 1);
            vendas[i] = scanner.nextDouble();
        }

        double totalVendido = calcularTotal(vendas);
        double mediaVendas = calcularMedia(vendas);
        double maiorVenda = encontrarMaior(vendas);
        double menorVenda = encontrarMenor(vendas);
        List<Integer> diasAcimaMedia = diasAcimaMedia(vendas, mediaVendas);

        exibirRelatorio(vendas, totalVendido, mediaVendas, maiorVenda, menorVenda, diasAcimaMedia);
        scanner.close();
    }

    public static double calcularTotal(double[] vendas) {
        double total = 0;
        for (double valor : vendas) {
            total += valor;
        }
        return total;
    }

    public static double calcularMedia(double[] vendas) {
        double total = calcularTotal(vendas);
        return total / vendas.length;
    }

    public static double encontrarMaior(double[] vendas) {
        double maior = vendas[0];
        for (double valor : vendas) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public static double encontrarMenor(double[] vendas) {
        double menor = vendas[0];
        for (double valor : vendas) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    public static List<Integer> diasAcimaMedia(double[] vendas, double media) {
        List<Integer> dias = new ArrayList<>();
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] > media) {
                dias.add(i + 1);
            }
        }
        return dias;
    }

    public static void exibirRelatorio(double[] vendas, double total, double media, double maior, double menor, List<Integer> diasAcimaMedia) {
        System.out.println("\nRelatório de Vendas Semanais");
        System.out.println("--------------------------");
        for (int i = 0; i < vendas.length; i++) {
            System.out.printf("Dia %d: R$ %.2f%n", i + 1, vendas[i]);
        }
        System.out.printf("\nTotal vendido: R$ %.2f%n", total);
        System.out.printf("Média de vendas: R$ %.2f%n", media);
        System.out.printf("Maior venda: R$ %.2f%n", maior);
        System.out.printf("Menor venda: R$ %.2f%n", menor);
        System.out.print("Dias acima da média: ");
        if (diasAcimaMedia.isEmpty()) {
            System.out.println("nenhum");
        } else {
            for (int i = 0; i < diasAcimaMedia.size(); i++) {
                System.out.print(diasAcimaMedia.get(i));
                if (i < diasAcimaMedia.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
