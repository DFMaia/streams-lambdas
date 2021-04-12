import java.util.*;
import java.util.stream.Collectors;

public class Aula3 {

    public static void main(String[] args) {

        /**
         * Usando operações FINAIS ou TERMINAIS
         * Quando executamos uma operação final, o stream foi fechado.
         * O for each é uma operação final. O for each não retorna nada. Ele só é usado para imprimir no console.
         * Porque usar Stream?
         * Stream = loop implícito
         * For - while - do while = loops explícitos.
         */

        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        /**
         * ------->COUNT<-------
         * Contando elementos e armazenando esse valor em uma variável
         */
        System.out.println("Usando o count");
        long count = lista.stream()
                .filter(e -> e %2 == 0)
                .count();
        System.out.println("Imprimindo a variável count com a quantidade de elementos do stream: " + count);

        /**
         * ------->MIN<-------
         * Coletando o menor valor.
         */
        System.out.println("\n\nColetando o menor valor");
        Optional<Integer> menorValor = lista.stream().min(Comparator.naturalOrder());
        System.out.println(menorValor.get());

        /**
         * ------->MAX<-------
         * Coletando o menor valor.
         */
        System.out.println("\n\nColetando o maior valor");
        Optional<Integer> maiorValor = lista.stream().max(Comparator.naturalOrder());
        System.out.println(maiorValor.get());

        /**
         * ------->collect<-------
         * O optional não permite muitas mudanças. Mas se quiser implementar mais mudanças, é possível usar o collect
         * Existem duas assinaturas dele. Vamos usar a mais simples aqui. A outra fica para uma próxima aula.
         */
        System.out.println("\n\nColocando dados de uma lista dentro de outra. ");
        List<Integer> novaLista = lista.stream()
                .filter(e -> e %2 == 0)
                .collect(Collectors.toList());
        System.out.println("Imprimindo valores da nova lista " + novaLista);

        /**
         * ------->collect GROUPING BY<-------
         * Aqui eu consigo separar dentro de uma lista, resultados por grupo.
         * Vou colocar dentro de uma lista somente resultados pares e em outra, resultados ímpares.
         */
        System.out.println("\n\nColocando dados de uma lista dentro de outra por grupo. ");
        Map<Boolean , List<Integer>> listaMapa = lista.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e %2 == 0));
        System.out.println(listaMapa);

        //Outro exemplo sem ser com Map booleano
        //Posso agrupar objetos de clientes que tem uma determinada idade ou endereço. Coisas assim.
        System.out.println();
        Map<Integer, List<Integer>> listaMapa2 = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(listaMapa2);

        /**
         * ------->collect JOINING<-------
         * Só trabalha com Strings e por isso vou transformar todos os números em String.
         */
        System.out.println("\n\nUsando o Joining");
        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining());
                //.collect(Collectors.joining(;)); Isso aqui eu coloco um ponto e vírgula entre cada iteração
        System.out.println("Todos os valores da lista joined e em forma de String: " + collect);

    }

}
