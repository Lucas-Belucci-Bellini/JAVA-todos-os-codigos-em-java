import java.util.Scanner;

public class ATV {
    public static void main(String[] args) {
        mostrarCabecalho();

        Scanner pele = new Scanner(System.in);
        String neymar[] = new String[4];
        int messi[][] = new int[4][3];
        int ronaldo[] = new int[4];
        double mbappe[] = new double[4];
        String ramos[] = new String[4];

        for (int i = 0; i < neymar.length; i++) {
            System.out.print("Informe o nome da seleção " + (i + 1) + ": ");
            neymar[i] = pele.nextLine();
        }

        for (int i = 0; i < messi.length; i++) {
            for (int j = 0; j < messi[i].length; j++) {
                messi[i][j] = (int) (Math.random() * 4);
            }
        }

        System.out.println("\nRELATÓRIO FINAL");
        System.out.println("====================================");

        int totalGeral = 0;
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 0; i < neymar.length; i++) {
            ronaldo[i] = calcularTotalGols(messi[i][0], messi[i][1], messi[i][2]);
            mbappe[i] = Math.round((ronaldo[i] / 3.0) * 100.0) / 100.0;
            ramos[i] = classificarSelecao(ronaldo[i]);

            mostrarDados(neymar[i], ronaldo[i], mbappe[i], ramos[i]);
            System.out.println("Gols do jogo 1: " + messi[i][0]);
            System.out.println("Gols do jogo 2: " + messi[i][1]);
            System.out.println("Gols do jogo 3: " + messi[i][2]);
            System.out.println("------------------------------------");

            totalGeral += ronaldo[i];
            if (ronaldo[i] > ronaldo[indiceMaior]) {
                indiceMaior = i;
            }
            if (ronaldo[i] < ronaldo[indiceMenor]) {
                indiceMenor = i;
            }
        }

        System.out.println("ESTATÍSTICAS GERAIS");
        System.out.println("====================================");
        System.out.println("Total geral de gols da competição: " + totalGeral);
        System.out.println("Seleção com maior número de gols: " + neymar[indiceMaior] + " (" + ronaldo[indiceMaior] + " gols)");
        System.out.println("Seleção com menor número de gols: " + neymar[indiceMenor] + " (" + ronaldo[indiceMenor] + " gols)");

        pele.close();
    }

    public static void mostrarCabecalho() {
        System.out.println("====================================");
        System.out.println("   COPA DO MUNDO 2026");
        System.out.println("CONTROLE DE SELEÇÕES");
        System.out.println("====================================");
    }

    public static void mostrarDados(String selecao, int totalGols, double mediaGols, String classificacao) {
        System.out.println("Seleção: " + selecao);
        System.out.println("Total de gols: " + totalGols);
        System.out.println("Média de gols: " + mediaGols);
        System.out.println("Classificação: " + classificacao);
    }

    public static int calcularTotalGols(int jogo1, int jogo2, int jogo3) {
        return jogo1 + jogo2 + jogo3;
    }

    public static String classificarSelecao(int totalGols) {
        if (totalGols >= 6) {
            return "Ótimo ataque";
        } else if (totalGols >= 3) {
            return "Ataque regular";
        } else {
            return "Baixo ataque";
        }
    }
}
