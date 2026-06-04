import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 8;
        String[] nomes = new String[N];
        int[] qtd = new int[N];

        System.out.println("Cadastro de 8 produtos:");
        for (int i = 0; i < N; i++) {
            System.out.print("Nome do produto " + (i+1) + ": ");
            nomes[i] = sc.nextLine();
            System.out.print("Quantidade disponível: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Informe um número inteiro para a quantidade: ");
            }
            qtd[i] = sc.nextInt();
            sc.nextLine();
        }

        mostrarProdutos(nomes, qtd);
        int idxMax = produtoMaiorQuantidade(qtd);
        int idxMin = produtoMenorQuantidade(qtd);
        System.out.println("Produto com maior quantidade: " + nomes[idxMax] + " (" + qtd[idxMax] + ")");
        System.out.println("Produto com menor quantidade: " + nomes[idxMin] + " (" + qtd[idxMin] + ")");
        System.out.println("Total de produtos em estoque: " + totalEstoque(qtd));

        sc.close();
    }

    static void mostrarProdutos(String[] nomes, int[] qtd) {
        System.out.println("\nProdutos cadastrados:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i+1) + ". " + nomes[i] + " - " + qtd[i]);
        }
    }

    static int produtoMaiorQuantidade(int[] qtd) {
        int idx = 0;
        for (int i = 1; i < qtd.length; i++) {
            if (qtd[i] > qtd[idx]) idx = i;
        }
        return idx;
    }

    static int produtoMenorQuantidade(int[] qtd) {
        int idx = 0;
        for (int i = 1; i < qtd.length; i++) {
            if (qtd[i] < qtd[idx]) idx = i;
        }
        return idx;
    }

    static int totalEstoque(int[] qtd) {
        int s = 0;
        for (int v : qtd) s += v;
        return s;
    }
}
