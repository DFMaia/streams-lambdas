import java.util.Optional;

public class Aula4 {

    /**
     * OBSERVAÇÃO: DEVE-SE USAR O OPTIONAL SEMPRE COMO RETORNO. NUNCA COMO PARÂMETRO OU ARGUMENTO
     */

    /**
     * OPTIONAL
     * Ele tenta retornar se é uma condição do Optional ou não. Nesse caso, se não for o resultado do Optional
     * poderá ser null
     */
    public static Optional<Integer> converteNumero(String numeroStr){

        try{
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    /**
     * Se o número puder ser null ele retornará um Optional.empty.
     * @param numeroStr
     * @return
     */
    public  static Optional<Integer> converteNumeroNullable(String numeroStr){
        try{
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.ofNullable(null);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    public static void main(String[] args) {

        String stringOlaMundo = "Olá mundo";
        String numeroString = "132";

        Optional <Integer> numero = converteNumero(stringOlaMundo);
        System.out.println(numero);

        Optional<Integer> converteNumeroNullable = converteNumeroNullable(stringOlaMundo);
        System.out.println(converteNumeroNullable);

        System.out.println("------------------------------");

        /**
         * ------->IS PRESENT<-------
         * Retorna true or false
         */
        System.out.println(numero.isPresent());

        numero = converteNumero(numeroString);
        System.out.println(numero.isPresent());

        System.out.println("------------------------------");

        /**
         * ------->GET<--------
         * Pegando um valor de um optional
         * O problema disso aqui é que se o valor não existir, vai retornar um erro de excessão.
         */
        System.out.println("O valor do optional é " + numero.get());

        System.out.println("------------------------------");

        /**
         * IF PRESENT
         * Retorna p valor se ele existir e não retorna nada se não existir.
         */
        numero = converteNumero(stringOlaMundo);
        numero.ifPresent(n -> System.out.println(n)); // Aqui não está impresso nada. Nem aparece linha de console vazia.
        numero = converteNumero(numeroString);
        numero.ifPresent(n -> System.out.println(n));
        //Outra forma de escrever isso seria assim:
        converteNumero(numeroString).ifPresent(e -> System.out.println(e));

        System.out.println("------------------------------");

        /**
         * OR ELSE
         * Retorna o valor que você espera. Se não retornar, retornará o valor que está no else.
         * Isso pode ser armazenado em uma variável.
         * Com o OR ELSE GET dentro dele vai uma operação lambda ( () -> retorno operaçãoPesada)
         */
        System.out.println(converteNumero(stringOlaMundo).orElse(5));

        /**
         * OR ELSE THROW
         * Se o resultado não for encontrado será lançado uma excessão a sua escolha.
         * Isso pode ser armazenado em uma variável ou impresso diretamente no System
         */
        Integer numero1 = converteNumero(stringOlaMundo).orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(numero1);
        //Ou então
        System.out.println(converteNumero(stringOlaMundo).orElseThrow(() -> new NullPointerException("Valor vazio")));



    }

}
