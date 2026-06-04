import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class main {
    static BigDecimal calcular(BigDecimal valorInicial, int dias) {
        return valorInicial.multiply(BigDecimal.valueOf(2).pow(dias));
    }

    static int diasPorTempo(int quantidade, String tipo) {
        switch (tipo) {
            case "dias":
            case "dia":
                return quantidade;
            case "meses":
            case "mes":
                return quantidade * 30;
            case "anos":
            case "ano":
                return quantidade * 365;
            default:
                throw new IllegalArgumentException("Tipo de tempo inválido: use dias, meses ou anos.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Valor inicial (ex: 0.10): ");
        String valorTexto = sc.nextLine().trim().replace(',', '.');
        BigDecimal valorInicial = new BigDecimal(valorTexto);

        System.out.print("Quantidade de tempo: ");
        int quantidade = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Tipo de tempo (dias, meses, anos): ");
        String tipo = sc.nextLine().trim().toLowerCase();

        int dias = diasPorTempo(quantidade, tipo);
        BigDecimal total = calcular(valorInicial, dias);

        System.out.println("Dias totais: " + dias);
        System.out.println("Valor após " + quantidade + " " + tipo + ": " + total.setScale(2, RoundingMode.HALF_UP).toPlainString());
        sc.close();
    }
}
