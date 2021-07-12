package dio.santander.bootcamp.tratamentodatas;

import java.time.LocalDateTime;
import java.time.Month;

public class ExercicioTrabalhandoComDatasJava8 {

    /*
    * Adicione 4 anos, 6 meses e 13 horas ao momento 15/05/2010 10:00:00.
    * */
    public static void main(String[] args) {

        LocalDateTime quinzeMaio2010 = LocalDateTime.of(2010, Month.MAY, 15, 10, 0, 0);
        System.out.println("Data base: " + quinzeMaio2010);

        LocalDateTime dataFutura = quinzeMaio2010.plusYears(4).plusMonths(6).plusHours(13);
        System.out.println("Data Futura: " + dataFutura);
    }

}
