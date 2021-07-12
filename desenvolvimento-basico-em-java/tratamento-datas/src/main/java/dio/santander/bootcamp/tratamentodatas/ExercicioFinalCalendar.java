package dio.santander.bootcamp.tratamentodatas;

import java.util.Calendar;

public class ExercicioFinalCalendar {

    public static void main(String[] args) {
        /*
        * Um cliente tem 10 Ødias para pagar uma fatura após sua data de vencimento sem que os juros sejam cobrados.
        * Caso essa data caia em um sábado ou domingo, o cliente pode pagar na segunda-feira seguinte.
        * Crie uma estrutura que receba uma data de vencimento e calcule quantos dias ele tem para pagar.
        * */

        Calendar dataVencimento = Calendar.getInstance();
        dataVencimento.set(Calendar.DAY_OF_MONTH, 9); // sexta-feira
        dataVencimento.set(Calendar.MONTH, Calendar.JULY);
        dataVencimento.set(Calendar.YEAR, 2021);
        System.out.printf("Data de vencimento: %tF\n", dataVencimento);

        double diasParaPagar = calcularDataVencimento(dataVencimento);
        System.out.printf("Dias para pagar fatura: %d", (int) diasParaPagar);

        Calendar dataVencimentoFds = Calendar.getInstance();
        dataVencimentoFds.set(Calendar.DAY_OF_MONTH, 10); // sábado
        dataVencimentoFds.set(Calendar.MONTH, Calendar.JULY);
        dataVencimentoFds.set(Calendar.YEAR, 2021);
        System.out.printf("\n\nData de vencimento: %tF\n", dataVencimentoFds);

        double diasParaPagarFds = calcularDataVencimento(dataVencimentoFds);
        System.out.printf("Dias para pagar fatura: %d", (int) diasParaPagarFds);
    }

    private static double calcularDataVencimento(Calendar dataVencimento) {
        switch (dataVencimento.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SATURDAY:
                dataVencimento.add(Calendar.DAY_OF_YEAR, 2);
                break;
            case Calendar.SUNDAY:
                dataVencimento.add(Calendar.DAY_OF_YEAR, 1);
                break;
        }

        Calendar hoje = Calendar.getInstance();
        System.out.printf("Data de hoje: %tF\n", hoje);

        long milis = dataVencimento.getTimeInMillis() - hoje.getTimeInMillis();
        //System.out.printf("Millis: %d\n", milis);

        double seconds = calculaSegundos(milis);
        //System.out.println("Seconds: " + seconds);

        double minutes = calculaMinutos(seconds);
        //System.out.println("Minutes: " + minutes);

        double hours = calculaHoras(minutes);
        //System.out.println("Hours: " + hours);

        return calculaDias(hours) + 2; // considera o dia de hoje e o dia da data de vencimento
    }

    private static double calculaDias(double hours) {
        return hours / 24;
    }

    private static double calculaHoras(double minutes) {
        return minutes / 60;
    }

    private static double calculaMinutos(double seconds) {
        return seconds / 60;
    }

    private static double calculaSegundos(long milis) {
        return milis / 1000;
    }

}
