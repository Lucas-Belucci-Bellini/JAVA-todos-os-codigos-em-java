import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Quantidade de notas: ");
        int quantidade = scanner.nextInt();
        
        double[] notas = new double[quantidade];
        double soma = 0;
        
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }
        
        double media = soma / quantidade;
        System.out.println("\nMédia: " + media);
        
        ArrayList<Double> maioresQueMedia = new ArrayList<>();
        ArrayList<Double> menoresQueMedia = new ArrayList<>();
        
        for (int i = 0; i < quantidade; i++) {
            if (notas[i] > media) {
                maioresQueMedia.add(notas[i]);
            } else if (notas[i] < media) {
                menoresQueMedia.add(notas[i]);
            }
        }
        
        System.out.println("\nNotas maiores que a média:");
        for (Double nota : maioresQueMedia) {
            System.out.println(nota);
        }
        
        System.out.println("\nNotas menores que a média:");
        for (Double nota : menoresQueMedia) {
            System.out.println(nota);
        }
        
        scanner.close();
    }
}
