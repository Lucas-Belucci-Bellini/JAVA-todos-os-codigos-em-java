public class ALU {
    private int A;
    private int B;
    private int resultado;
    private boolean zeroFlag;

    public ALU(int a, int b) {
        this.A = a;
        this.B = b;
        this.resultado = 0;
        this.zeroFlag = false;
    }

    public void executar(int opcode) {
        switch (opcode) {
            case 0: // Adição
                resultado = A + B;
                break;
            case 1: // Subtração
                resultado = A - B;
                break;
            case 2: // Multiplicação
                resultado = A * B;
                break;
            case 3: // Divisão
                if (B != 0) {
                    resultado = A / B;
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    resultado = 0;
                }
                break;
            case 4: // AND lógico (bitwise)
                resultado = A & B;
                break;
            case 5: // OR lógico (bitwise)
                resultado = A | B;
                break;
            case 6: // XOR lógico (bitwise)
                resultado = A ^ B;
                break;
            case 7: // NOT (complemento de A)
                resultado = ~A;
                break;
            default:
                System.out.println("Opcode inválido!");
                resultado = 0;
        }

        // Verifica a Zero Flag
        if (resultado == 0) {
            zeroFlag = true;
        } else {
            zeroFlag = false;
        }
    }

    public int getResultado() {
        return resultado;
    }

    public boolean isZeroFlag() {
        return zeroFlag;
    }

    public void setOperandos(int a, int b) {
        this.A = a;
        this.B = b;
    }

    @Override
    public String toString() {
        return "ALU{" +
                "A=" + A +
                ", B=" + B +
                ", resultado=" + resultado +
                ", zeroFlag=" + zeroFlag +
                '}';
    }

    public static void main(String[] args) {
        ALU ula = new ALU(10, 5);

        System.out.println("=== Testando Operações da ULA ===\n");

        // Adição
        ula.executar(0);
        System.out.println("Adição (10 + 5): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // Subtração
        ula.executar(1);
        System.out.println("Subtração (10 - 5): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // Subtração resultando em zero
        ula.setOperandos(7, 7);
        ula.executar(1);
        System.out.println("Subtração (7 - 7): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // Multiplicação
        ula.setOperandos(10, 5);
        ula.executar(2);
        System.out.println("Multiplicação (10 * 5): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // Divisão
        ula.executar(3);
        System.out.println("Divisão (10 / 5): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // AND bitwise
        ula.setOperandos(12, 10); // 1100 & 1010 = 1000 (8)
        ula.executar(4);
        System.out.println("AND (12 & 10): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // OR bitwise
        ula.executar(5);
        System.out.println("OR (12 | 10): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());

        // XOR bitwise
        ula.executar(6);
        System.out.println("XOR (12 ^ 10): " + ula.getResultado() + " | Zero Flag: " + ula.isZeroFlag());
    }
}
