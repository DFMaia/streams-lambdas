import java.util.Arrays;
import java.util.List;

public class Aula2 {

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        lista.stream().forEach(e -> System.out.print(e + ", "));

        /**
         * ------->OPERAÇÕES INTERMEDIÁRIAS<-------
         * O Stream é um fluxo de dados.
         * Quando eu uso um for ou um for each (aquele que tem : ) aquilo só itera dentro da lista
         */

        /**
         * ------->SKIP<-------
         * Pulando os dois primeiros dados da lista.
         */
        System.out.println("\n\nPulando os dois primeiros dados da lista");
        lista.stream()
                .skip(2)
                .forEach(e -> System.out.print(e + ", "));

        /**
         * ------->LIMIT<-------
         * Aqui eu estou processando somente os dois primeiros elementos.
         */
        System.out.println("\n\nProcessando no Stream somente os dois primeiros elementos.");
        lista.stream()
                .limit(2)
                .forEach(e -> System.out.print(e + ", "));

        /**
         * ------->DISTINCT<-------
         * Aqui eu estou processando elementos que não são repetidos.
         * Se eu for fazer isso entre classes, é preciso que cada classe esteja com o equals e hashcode implementados
         */
        System.out.println("\n\nProcessando no Stream elementos que não são repetidos.");
        lista.stream()
                .distinct()
                .forEach(e -> System.out.print(e + ", "));

        /**
         * ------->USANDO DIFERENTES OPERAÇÕES INTERMEDIÁRIAS<-------
         * É possível misturar essas operações intermediárias.
         */
        System.out.println("\n\nPulando os dois primeiros números, limitando o processamento somente das três" +
                "primeiras posições e não permitindo que sejam elementos repetidos.");
        lista.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .forEach(e -> System.out.print(e + ", "));

        /**
         * ------->FILTER<-------
         * Os exemplos acima podem ser também chamados de filtros.
         * Mas em caso de um filtro mais personalizado, usamos o filter.
         */
        System.out.println("\n\nUsando filtro (filter)");
        lista.stream()
                .filter( e -> e %2 == 0)
                .distinct()
                .forEach(e -> System.out.print( e + ", "));

        /**
         * ------->MAP<-------
         * Para fazer uma TRANSFORMAÇÃO DOS DADOS, usamos o map.
         * Em uma outra aula (que está no git: https://github.com/DFMaia/JavaCollections) é dito que o stream
         * retorna sempre o tamanho do objeto. Já o map, retorna um objeto de tamanho diferente.
         * Usando o map, a lista original NÃO ALTERA A LISTA ORIGINAL
         */
        System.out.println("\n\nUsando Map para multiplicar cada número da lista. ");
        lista.stream()
                .map(e -> e * 2)
                .forEach(e -> System.out.print( e + ", "));



    }

}
