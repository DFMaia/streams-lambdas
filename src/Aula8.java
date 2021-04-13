import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Aula8 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        /**
         * REFERENCE METHOD
         * As duas são a mesma coisa.
         */
        System.out.println("Com method reference");
        list.stream()
                .forEach(System.out::println);

        System.out.println("\n\nSem method reference");
        list.stream()
                .forEach((n) -> System.out.println(n));

        /**
         * lambdas que usam métodos (tem um método estático no final do código)
         * Fazem a mesma coisa
         */
        System.out.println("\n\nUsando lambda com método sem o reference method");
        list.stream()
                .map((n) -> multipliquePorDois(n))
                .forEach(System.out::println);
                //forEach((n) -> System.out.println(n));

        System.out.println("\n\nUsando lambda com método com o reference method");
        list.stream()
                .map(Aula8::multipliquePorDois)
                .forEach(System.out::println);

        /**
         * Usando com construtores
         * Ambas fazem a mesma coisa
         */

        System.out.println("\n\nImprimindo construtor sem o método reference");
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach(System.out::println);

        System.out.println("\n\nImprimindo construtor com o método reference");
        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        /**
         * Com várias instâncias
         * Ambas fazem a mesma coisa
         */
        System.out.println("\n\nTransformando int em double sem o method reference");
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach(System.out::println);

        System.out.println("\n\nTransformando int em double com o method reference");
        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        /**
         * Única Instância
         * Ambas fazem a mesma coisa
         */
        System.out.println("\n\nTransformando int em big decimal e multiplicando sem o method reference");
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((b) -> dois.multiply(b))
                .forEach(System.out::println);

        System.out.println("\n\nTransformando int em big decimal e multiplicando com o method reference");
        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);
    }

    private static Integer multipliquePorDois(Integer i){
        return i * 2;
    }

}
