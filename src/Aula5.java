import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Aula5 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        String s = "Lambdas e streams são uma coisa muito legal";
        String split[] = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        /**
         * REDUCE
         * Pega todos os elementos da lista e transforma em uma coisa só
         * Para somar os valores de dentro dessa lista.
         * O n1 será o primeiro elemento e o n2 o segundo. A soma deles será um resultado e o n1 passará a ser
         * o resultado somado. O n2 será então o terceiro elemento. Eles serão somados e assim por diante.
         */
        Optional<Integer> reduceSoma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println("Somando todos os valores de dentro de uma lista.");
        System.out.println(reduceSoma.get());

        System.out.println("\nMultiplicação de todos os valores de dentro de uma lista");
        Optional<Integer> reduceMultiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao.get());

        /**
         * REDUCE DE CONCATENAÇÃO
         * Concatenando letras de um arquivo
         */
        Optional<String> reduceString = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println("\n\nConcatenando letras de um array de letras: " + reduceString.get());

        /**
         * REDUCE COM VALOR DE IDENTIDADE
         * Para que serve se o resultado é o mesmo?
         * Porque no Optional, se o resultado não for o esperado pelo Optional, ele nem retorna.
         * No REDUCE DE IDENTIDADE, se o resultado for vazio, ele vai retornar somente o valor de identidade.
         * Não é um optional mais.
         * Abaixo tem o reduce com as listas lá de cima com os valores preenchidos e logo depois eu crio uma lista
         * vazia e sem valores para comparar.
         */

        Integer reduceSomaidentidade = list.stream().reduce(0 ,(n1, n2) -> n1 + n2);
        System.out.println("\n\nImprimindo a soma com reduce de identidade " + reduceSomaidentidade);
        Integer reduceMultiplicacaoIdentidade = list.stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.println("Imprimindo a multiplicação com reduce de identidade: " + reduceMultiplicacaoIdentidade);
        String reduceStringIdentidade = listStr.stream().reduce("",(s1, s2) -> s1.concat(s2));
        System.out.println("Imprimindo a concatenação com reduce de identidade: " + reduceStringIdentidade);

        //Vou criar uma lista sem nada. O reduce de identidade vai me retornar um valor de identidade.
        List<Integer> list2 = Arrays.asList();
        Integer reduceSomaidentidadeDeListaVazia = list2.stream().reduce(0 ,(n1, n2) -> n1 + n2);
        System.out.println("\n\nImprimindo a soma com reduce de identidade " + reduceSomaidentidadeDeListaVazia);
        Integer reduceMultiplicacaoIdentidadeDeListaVazia = list2.stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.println("Imprimindo a multiplicação com reduce de identidade: " + reduceMultiplicacaoIdentidadeDeListaVazia);

        OptionalDouble reduceDoube = DoubleStream.of(1.5, 2.9, 6.7).reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println("\nRetornando o o menor double de um DoubleOptional: " + reduceDoube);
        double menorValor = DoubleStream.of(1.5, 2.9, 6.7).reduce(Double.POSITIVE_INFINITY,( d1, d2) -> Math.min(d1, d2));

    }

}
