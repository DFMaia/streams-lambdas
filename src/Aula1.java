import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Aula1 {

    public static void main(String[] args) {

        /**
         * Isso é uma thread realizada até o java 8.
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Olá mundo");
            }
        }).run();

        /**
         * A mesma thread executada com lambda.
         */
        new Thread(() -> System.out.println("Olá mundo")).run();

        System.out.println("------------------------------");

        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Olá mundo");
            }
        });

        /**
         * Perceba que nesse caso usamos um campo "e" dentro da lambda. Isso acontece porque no JButton ele usa um
         * parâmetro no actionPerformed(ActionEvent e).
         */
        JButton jButton1 = new JButton();
        jButton1.addActionListener(e -> System.out.println("Olá mundo!"));

        //------------------------------------------------------

        /**
         * ITERANDO SOBRE UMA LISTA
         * Um Stream é um fluxo de dados
         */

        List<Integer> asList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        /**
         * Uma forma de percorrer isso seria com um for
         */
        for(Iterator iterator = asList.iterator(); iterator.hasNext();){
            Integer integer = (Integer) iterator.next();
            System.out.print(integer + " ");
        }

        System.out.println();

        /**
         * Ou então com o outro for
         */
        for(Integer integer : asList){
            System.out.print(integer + " ");
        }

        /**
         * Usando o Stream
         */

        System.out.println("\nUsando Stream");
        asList.stream().forEach(e -> System.out.print(e + ", "));

        /**
         * usando o filter
         */

        System.out.println("\nUsando o filter");
        asList.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print( e + ", "));

    }

}
