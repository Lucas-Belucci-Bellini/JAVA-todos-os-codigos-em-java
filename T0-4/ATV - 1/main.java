import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {
    
    static class LLM {
        private List<String> conversationHistory;
        
        public LLM() {
            this.conversationHistory = new ArrayList<>();
        }
        
        public String chat(String userMessage) {
            conversationHistory.add("User: " + userMessage);
            String response = generateResponse(userMessage);
            conversationHistory.add("LLM: " + response);
            return response;
        }
        
        private String generateResponse(String userMessage) {
            String message = userMessage.toLowerCase().trim();
            
            if (message.contains("oi") || message.contains("olá") || message.contains("ola")) {
                return "Olá! Como posso ajudá-lo?";
            } else if (message.contains("como você está") || message.contains("como cê está")) {
                return "Estou bem, obrigado por perguntar! E você, como está?";
            } else if (message.contains("qual é seu nome") || message.contains("quem é você")) {
                return "Sou uma LLM (Large Language Model) em Java. Estou aqui para conversar com você!";
            } else if (message.contains("bye") || message.contains("adeus") || message.contains("até logo")) {
                return "Até logo! Foi um prazer conversar com você.";
            } else if (message.contains("qual é a data") || message.contains("que horas")) {
                return "Não tenho acesso à data/hora em tempo real, mas você pode verificar no seu sistema.";
            } else if (message.contains("me ajude") || message.contains("me ajuda") || message.contains("ajuda")) {
                return "Claro! Qual é a sua dúvida ou necessidade?";
            } else if (message.isEmpty()) {
                return "Você não disse nada. Poderia repetir?";
            } else {
                return "Entendi que você disse: \"" + userMessage + "\". Isso é interessante! Pode me dizer mais?";
            }
        }
        
        public void showHistory() {
            System.out.println("\n=== Histórico da Conversa ===");
            for (String entry : conversationHistory) {
                System.out.println(entry);
            }
            System.out.println("=============================\n");
        }
        
        public void clearHistory() {
            conversationHistory.clear();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LLM llm = new LLM();
        
        System.out.println("=== LLM em Java ===");
        System.out.println("Digite 'sair' para encerrar, 'histórico' para ver a conversa, 'limpar' para limpar histórico");
        System.out.println("====================\n");
        
        while (true) {
            System.out.print("Você: ");
            String userInput = scanner.nextLine();
            
            if (userInput.toLowerCase().equals("sair")) {
                System.out.println("Encerrando a conversa...");
                break;
            } else if (userInput.toLowerCase().equals("histórico")) {
                llm.showHistory();
            } else if (userInput.toLowerCase().equals("limpar")) {
                llm.clearHistory();
                System.out.println("Histórico limpo.\n");
            } else {
                String response = llm.chat(userInput);
                System.out.println("LLM: " + response + "\n");
            }
        }
        
        scanner.close();
    }
}
