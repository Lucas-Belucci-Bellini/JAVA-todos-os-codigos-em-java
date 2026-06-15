public class main {
    public static void main(String[] args) {
        // Criar um vetor com 50 posições
        int[] numeros = new int[50];
        
        // Preencher o vetor com números de 101 a 150
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = 101 + i;
        }
        
        // Exibir os valores do vetor
        System.out.println("Valores do vetor:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }
    }
}
