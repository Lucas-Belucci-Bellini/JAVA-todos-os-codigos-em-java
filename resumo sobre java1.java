public class ResumoSobreJava {
    public static void main(String[] args) {
        System.out.println("Resumo sobre Java: do básico ao avançado\n");
        basico();
        intermediario();
        avancado();
    }

    private static void basico() {
        System.out.println("=== Básico ===");

        // Tipos primitivos e variáveis
        int numero = 10;
        double valor = 5.75;
        boolean ativo = true;
        char letra = 'J';
        String texto = "Java básico";

        System.out.println("int: " + numero);
        System.out.println("double: " + valor);
        System.out.println("boolean: " + ativo);
        System.out.println("char: " + letra);
        System.out.println("String: " + texto);

        // Estruturas de controle
        if (numero > 5) {
            System.out.println("Número maior que 5");
        } else {
            System.out.println("Número menor ou igual a 5");
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("Loop for: " + i);
        }

        int contador = 0;
        while (contador < 2) {
            System.out.println("Loop while: " + contador);
            contador++;
        }

        // Arrays e coleções básicas
        int[] numeros = {1, 2, 3};
        System.out.print("Array: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println("\n");
    }

    private static void intermediario() {
        System.out.println("=== Intermediário ===");

        // Métodos e sobrecarga
        System.out.println("Soma 2 valores: " + somar(3, 4));
        System.out.println("Soma 3 valores: " + somar(2, 5, 7));

        // Classe e objeto
        Pessoa pessoa = new Pessoa("Maria", 28);
        System.out.println(pessoa);

        // Herança e polimorfismo
        Animal cachorro = new Cachorro("Rex");
        Animal gato = new Gato("Miau");
        cachorro.fazerSom();
        gato.fazerSom();

        // Interface
        Veiculo carro = new Carro("Sedan");
        carro.mover();

        // Enum
        DiaSemana dia = DiaSemana.SEGUNDA;
        System.out.println("Dia da semana: " + dia);

        // Tratamento de exceções
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
    }

    private static void avancado() {
        System.out.println("=== Avançado ===");

        // Generics
        Caixa<String> caixa = new Caixa<>();
        caixa.setConteudo("Conteúdo genérico");
        System.out.println(caixa.getConteudo());

        // Lambda e Stream API
        java.util.List<Integer> lista = java.util.Arrays.asList(10, 20, 30, 40);
        int soma = lista.stream()
                .filter(n -> n > 15)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Soma com stream: " + soma);

        // Thread e concorrência simples
        Thread tarefa = new Thread(() -> System.out.println("Executando em outra thread"));
        tarefa.start();
        try {
            tarefa.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Classes internas e abstratas
        Formulario form = new Formulario() {
            @Override
            public void enviar() {
                System.out.println("Formulário enviado");
            }
        };
        form.enviar();

        System.out.println();
    }

    private static int somar(int a, int b) {
        return a + b;
    }

    private static int somar(int a, int b, int c) {
        return a + b + c;
    }

    private static int dividir(int a, int b) {
        return a / b;
    }

    static class Pessoa {
        private final String nome;
        private final int idade;

        Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public String toString() {
            return "Pessoa{nome='" + nome + "', idade=" + idade + "}";
        }
    }

    static abstract class Animal {
        protected final String nome;

        Animal(String nome) {
            this.nome = nome;
        }

        abstract void fazerSom();
    }

    static class Cachorro extends Animal {
        Cachorro(String nome) {
            super(nome);
        }

        @Override
        void fazerSom() {
            System.out.println(nome + " diz: Au au");
        }
    }

    static class Gato extends Animal {
        Gato(String nome) {
            super(nome);
        }

        @Override
        void fazerSom() {
            System.out.println(nome + " diz: Miau");
        }
    }

    interface Veiculo {
        void mover();
    }

    static class Carro implements Veiculo {
        private final String modelo;

        Carro(String modelo) {
            this.modelo = modelo;
        }

        @Override
        public void mover() {
            System.out.println("O carro " + modelo + " está em movimento");
        }
    }

    enum DiaSemana {
        SEGUNDA,
        TERCA,
        QUARTA,
        QUINTA,
        SEXTA,
        SABADO,
        DOMINGO
    }

    static class Caixa<T> {
        private T conteudo;

        public void setConteudo(T conteudo) {
            this.conteudo = conteudo;
        }

        public T getConteudo() {
            return conteudo;
        }
    }

    interface Formulario {
        void enviar();
    }
}
