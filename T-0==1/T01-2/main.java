import java.util.Random;

public class main {
    public static void main(String[] args) {
        String cpf = generateCPF();
        System.out.println("CPF gerado: " + cpf);
    }

    private static String generateCPF() {
        int[] digits = new int[11];
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            digits[i] = random.nextInt(10);
        }
        digits[9] = calculateDigit(digits, 10);
        digits[10] = calculateDigit(digits, 11);
        return formatCPF(digits);
    }

    private static int calculateDigit(int[] digits, int weightStart) {
        int sum = 0;
        for (int i = 0; i < weightStart - 1; i++) {
            sum += digits[i] * (weightStart - i);
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    private static String formatCPF(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
            if (i == 2 || i == 5) {
                sb.append('.');
            } else if (i == 8) {
                sb.append('-');
            }
        }
        return sb.toString();
    }
}
