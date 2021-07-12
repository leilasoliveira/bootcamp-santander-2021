package dio.santander.bootcamp.tratamentodatas;

import java.util.Calendar;

public class FormatandoDatas {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // full date
        System.out.printf("%tc\n", calendar);

        // data padrão YYYY-MM-DD
        System.out.printf("%tF\n", calendar);

        // data padrão MM/DD/YY
        System.out.printf("%tD\n", calendar);

        // hora com minutos e segundos padrão 12h
        System.out.printf("%tr\n", calendar);

        // hora com minutos e segundos padrão 24h
        System.out.printf("%tT\n", calendar);
    }

}
