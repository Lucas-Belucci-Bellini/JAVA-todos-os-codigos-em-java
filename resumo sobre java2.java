// Resumo sobre Java: básico até avançado
// Tudo explicado por meio de comentários.

public class ResumoJava2 {
    public static void main(String[] args) {
        // O ponto de entrada de um programa Java é o método main.
        // Ele recebe um array de Strings como argumento.
        System.out.println("Resumo Java iniciado");
    }

    // 1. Estrutura básica do Java
    // - Todo código Java está dentro de classes ou interfaces.
    // - Um arquivo .java geralmente contém uma classe pública com o mesmo nome do arquivo.

    // 2. Tipos de dados e variáveis
    // - Tipos primitivos: byte, short, int, long, float, double, char, boolean.
    // - Tipos por referência: String, arrays e objetos.
    // - Declaração de variável:
    //   int idade = 30;
    //   double salario = 4500.50;
    //   boolean ativo = true;

    // 3. Operadores básicos
    // - Aritméticos: + - * / %
    // - Comparação: == != > < >= <=
    // - Lógicos: && || !
    // - Atribuição: = += -= *= /= %=.

    // 4. Controle de fluxo
    // if / else / else if
    // switch (a partir do Java 7 suporta String)
    // while, do-while, for, for-each.
    // Exemplo:
    // for (int i = 0; i < 10; i++) {
    //     System.out.println(i);
    // }

    // 5. Métodos e passagem de parâmetros
    // - Métodos são funções dentro de classes.
    // - São usados para organizar e reutilizar código.
    // - Java tem passagem por valor: objetos são passados como referência de valor.
    public static int soma(int a, int b) {
        return a + b;
    }

    // 6. Classes e objetos
    // - Classe define um tipo de dado com atributos e comportamentos.
    // - Objeto é uma instância de uma classe.
    // - Exemplo:
    //   Pessoa p = new Pessoa("Maria", 28);
    //   p.falar();

    // 7. Encapsulamento e modificadores de acesso
    // - private: só acessível dentro da própria classe.
    // - protected: acessível na mesma classe, pacote e subclasses.
    // - public: acessível de qualquer lugar.
    // - default (sem modificador): acessível no mesmo pacote.
    class Pessoa {
        private String nome; // atributo privado
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome; // palavra-chave this refere-se ao objeto atual
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void falar() {
            System.out.println("Olá, meu nome é " + nome);
        }
    }

    // 8. Construtores e inicialização
    // - Construtores são métodos especiais para criar objetos.
    // - Podem ser sobrecarregados com diferentes assinaturas.

    // 9. Herança e reuso de código
    // - Uma classe pode estender outra classe com a palavra-chave extends.
    // - A subclasse herda campos e métodos da superclasse.
    class Animal {
        public void emitirSom() {
            System.out.println("Som genérico de animal");
        }
    }

    class Cachorro extends Animal {
        @Override
        public void emitirSom() {
            System.out.println("Au au");
        }
    }

    // 10. Polimorfismo
    // - O mesmo método pode ter comportamentos diferentes em subclasses.
    // - O tipo da referência pode ser a classe base e o objeto pode ser da subclasse.
    //   Animal a = new Cachorro();
    //   a.emitirSom(); // imprime "Au au"

    // 11. Classes abstratas e interfaces
    // - Classe abstrata pode ter métodos abstratos e concretos.
    // - Interface define um contrato de métodos que devem ser implementados.
    abstract class Veiculo {
        public abstract void acelerar();

        public void ligar() {
            System.out.println("Veículo ligado");
        }
    }

    interface Operavel {
        void operar();
    }

    class Carro extends Veiculo implements Operavel {
        @Override
        public void acelerar() {
            System.out.println("Carro acelerando");
        }

        @Override
        public void operar() {
            System.out.println("Operando carro");
        }
    }

    // 12. Modificadores especiais: static, final
    // - static: membro pertence à classe e não à instância.
    // - final: constante ou método que não pode ser sobrescrito.
    public static final String VERSAO_JAVA = "Java 21+";

    // 13. Arrays e coleções
    // - Arrays têm tamanho fixo.
    // - Collection framework inclui List, Set, Map e suas implementações.
    // Exemplo de array:
    //   int[] numeros = {1, 2, 3};
    // Exemplo de coleção:
    //   List<String> nomes = new ArrayList<>();

    // 14. Generics
    // - Permitem tipos parametrizados para segurança de tipo em tempo de compilação.
    class Caixa<T> {
        private T conteudo;

        public void guardar(T conteudo) {
            this.conteudo = conteudo;
        }

        public T abrir() {
            return conteudo;
        }
    }

    // 15. Exceptions e tratamento de erros
    // - Throwable é a superclasse de Exception e Error.
    // - Exception representa erros recuperáveis.
    // - RuntimeException é não verificada.
    // - try/catch/finally para tratar exceções.
    public static void tratarExcecao() {
        try {
            int resultado = 10 / 0; // lança ArithmeticException
            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero");
        } finally {
            System.out.println("Executa sempre");
        }
    }

    // 16. Classes utilitárias: String, StringBuilder, Math, Arrays, Collections.
    // - String é imutável.
    // - StringBuilder é usado quando é necessário construir strings de forma eficiente.

    // 17. Java 8 e evolução: lambdas e Streams
    // - Lambda: expressões funcionais para simplificar código.
    // - Stream: API para processamento de coleções de forma declarativa.
    // Exemplo de lambda:
    //   List<String> nomes = List.of("Ana", "Bruno", "Carlos");
    //   nomes.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);

    // 18. Functional interfaces
    // - Interface com um único método abstrato.
    // - Exemplo: Runnable, Callable, Function, Consumer, Supplier.
    class MinhaTarefa implements Runnable {
        @Override
        public void run() {
            System.out.println("Executando tarefa em thread");
        }
    }

    // 19. Concorrência e multithreading
    // - Thread e Runnable para criar threads.
    // - ExecutorService para gerenciar pools de threads.
    // - synchronized para proteger seções críticas.
    // - volatile garante visibilidade de variáveis entre threads.

    // 20. Membres de pacotes e importações
    // - Pacotes organizam classes em namespaces.
    // - import permite usar classes de outros pacotes sem referenciar o nome completo.

    // 21. Sistema de módulos (Java 9+)
    // - module-info.java define módulos, exportação e dependências.
    // - Modularidade melhora encapsulamento e tempo de inicialização.

    // 22. I/O e arquivos
    // - Java.io e java.nio para leitura e escrita de arquivos.
    // - try-with-resources fecha automaticamente recursos.
    // Exemplo:
    //   try (BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"))) {
    //       String linha;
    //       while ((linha = reader.readLine()) != null) {
    //           System.out.println(linha);
    //       }
    //   } catch (IOException e) {
    //       e.printStackTrace();
    //   }

    // 23. Java Virtual Machine (JVM)
    // - JVM executa bytecode gerado pelo compilador.
    // - A JVM gerencia memória com heap, stack, PermGen / Metaspace.
    // - Garbage collector libera memória de objetos não mais usados.

    // 24. Memory e coleta de lixo
    // - Heap guarda objetos e arrays.
    // - Stack guarda frames de método e variáveis locais.
    // - Garbage collector não garante quando um objeto será liberado.

    // 25. Debugging e boas práticas
    // - Use nomes claros para classes, métodos e variáveis.
    // - Evite métodos longos; prefira métodos com única responsabilidade.
    // - Comente código quando o propósito não for óbvio.

    // 26. Desenvolvimento profissional
    // - Ferramentas: JDK, IDEs como IntelliJ IDEA, Eclipse, VS Code.
    // - Build tools: Maven, Gradle.
    // - Controle de versão: Git.

    // Observação final:
    // Java é uma linguagem orientada a objetos e multiplataforma.
    // Aprenda os fundamentos primeiro e depois pratique com projetos reais.
}
