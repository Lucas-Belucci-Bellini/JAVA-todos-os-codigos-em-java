import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String heaviestName = null;
        double heaviestWeight = 0;
        String lightestName = null;
        double lightestWeight = 0;

        System.out.println("Programa de registro de pesos.");
        System.out.println("Digite o nome do usuário (ou pressione Enter para terminar):");

        while (true) {
            System.out.print("Nome: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Peso (kg): ");
            String pesoStr = sc.nextLine().trim();
            double weight;
            try {
                weight = Double.parseDouble(pesoStr.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Peso inválido. Tente novamente.");
                continue;
            }

            if (heaviestName == null) {
                heaviestName = lightestName = name;
                heaviestWeight = lightestWeight = weight;
            } else {
                if (weight > heaviestWeight) {
                    heaviestWeight = weight;
                    heaviestName = name;
                }
                if (weight < lightestWeight) {
                    lightestWeight = weight;
                    lightestName = name;
                }
            }

            System.out.printf("Maior peso até agora: %s com %.2f kg%n", heaviestName, heaviestWeight);
        }

        System.out.println();
        if (heaviestName == null) {
            System.out.println("Nenhum usuário registrado.");
        } else {
            System.out.printf("Usuário de maior peso: %s - %.2f kg%n", heaviestName, heaviestWeight);
            System.out.printf("Usuário de menor peso: %s - %.2f kg%n", lightestName, lightestWeight);
        }

        sc.close();
    }
}
