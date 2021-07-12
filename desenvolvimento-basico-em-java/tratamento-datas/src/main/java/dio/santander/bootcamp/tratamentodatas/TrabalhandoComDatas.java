package dio.santander.bootcamp.tratamentodatas;

import java.util.Calendar;

public class TrabalhandoComDatas {

	public static void main(String[] args) {

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.YEAR, 1991);
		dataNascimento.set(Calendar.MONTH, Calendar.NOVEMBER);
		dataNascimento.set(Calendar.DAY_OF_MONTH, 10);

		System.out.println("Data de Nascimento: " + dataNascimento.toInstant());

		Calendar quinzeDeMaioDe2010 = Calendar.getInstance();
		quinzeDeMaioDe2010.set(Calendar.YEAR, 2010);
		quinzeDeMaioDe2010.set(Calendar.MONTH, Calendar.MAY);
		quinzeDeMaioDe2010.set(Calendar.DAY_OF_MONTH, 15);

		System.out.println("Data quinzeDeMaioDeDoisMilEDez: " + quinzeDeMaioDe2010.toInstant());

		System.out.println("Data Nascimento é anterior à 15/05/2010? "
				+ dataNascimento.toInstant().isBefore(quinzeDeMaioDe2010.toInstant()));

	}

}
