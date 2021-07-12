package dio.santander.bootcamp.tratamentodatas;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Referencia: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html
* */
public class ExercicioFinalDateFormat {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        System.out.println(sdf.format(new Date()));
    }

}
