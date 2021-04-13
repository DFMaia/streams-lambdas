import java.util.*;
import java.util.stream.Collectors;

public class Aula6 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> collect = list.stream()
                .filter((n) -> n %2 == 0)
                .collect(Collectors.toList());
        System.out.println("Passando valores para uma outra lista.");
        System.out.println(collect);

        Double media = list.stream()
                .collect(Collectors.averagingDouble((n)-> n.doubleValue()));
        System.out.println("\n\nMédia dos números " +  media);

        Integer soma = list.stream()
                .collect(Collectors.summingInt((n) -> n.intValue()));
        System.out.println("\n\nOutra forma de somar todos os valores: " + soma);

        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println("\n\nProvê estatísticas sobre a lista: ");
        System.out.println("Maior valor " + stats.getMax());
        System.out.println("Menor valor " + stats.getMin());
        System.out.println("Média " + stats.getAverage());
        System.out.println("Quantidade de itens" + stats.getCount());
        System.out.println("Soma " + stats.getSum());

        Long count = list.stream()
                .filter((n) -> n %2 == 0)
                .collect(Collectors.counting());
        System.out.println("Número de elementos: " + count);

        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n %3));
        System.out.println("\n\nAgrupando por resto (modal): " + groupingBy);

        Map<Boolean, List<Integer>> groupingByBoolean = list.stream()
                .collect(Collectors.partitioningBy((n) -> n %3 == 0));
        System.out.println("\n\nAgrupando por resto  com booleano: " + groupingByBoolean);


        /**
         * MAP
         * Executar um mapa cm índice e valor
         */
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors
                .toMap(n -> n,
                n -> n *2)); //O primeiro N é o índice e o segundo o valor
        System.out.println("\n\nMapa com índice e valor" + toMap);

        Map<Integer, Double> toMap1 = list.stream()
                .collect(Collectors
                .toMap(n -> n,
                n -> n * Math.pow(n.doubleValue(), 5)
                ));
        System.out.println("\n\nMapa com índice e valor em potência de 5 " + toMap1);




    }

}
