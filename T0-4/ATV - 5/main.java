import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jarvis: Olá! Eu sou Jarvis. Como posso ajudar?");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.isEmpty()) {
                System.out.println("Jarvis: Por favor, digite um comando.");
                continue;
            }

            if (entrada.contains("sair") || entrada.contains("tchau") || entrada.contains("até mais")) {
                System.out.println("Jarvis: Até logo! Se precisar, estou aqui.");
                break;
            }

            if (entrada.contains("hora")) {
                String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println("Jarvis: Agora são " + hora + ".");
                continue;
            }

            if (entrada.contains("nome")) {
                System.out.println("Jarvis: Meu nome é Jarvis, seu assistente virtual.");
                continue;
            }

            if (entrada.contains("ajuda") || entrada.contains("comando") || entrada.contains("o que você faz")) {
                System.out.println("Jarvis: Posso responder perguntas simples, informar a hora e interagir com você em português.");
                System.out.println("Jarvis: Digite 'hora' para saber as horas ou 'sair' para encerrar.");
                continue;
            }

            System.out.println("Jarvis: Desculpe, não entendi. Tente perguntar sobre a hora ou pedir ajuda.");
        }

        scanner.close();
    }
}
