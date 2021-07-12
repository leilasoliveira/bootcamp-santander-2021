package digital.innovation.one.utils.operacao;

import digital.innovation.one.utils.operacao.internal.Divisao;
import digital.innovation.one.utils.operacao.internal.Multiplicacao;
import digital.innovation.one.utils.operacao.internal.Soma;
import digital.innovation.one.utils.operacao.internal.Subtracao;

public class Calculadora {

    private Soma soma;
    private Subtracao subtracao;
    private Multiplicacao multiplicacao;
    private Divisao divisao;

    public Calculadora() {
        soma = new Soma();
        subtracao = new Subtracao();
        multiplicacao = new Multiplicacao();
        divisao = new Divisao();
    }

    public int somar(int a, int b) {
        return soma.executar(a, b);
    }

    public int subtrair(int a, int b) {
        return subtracao.executar(a, b);
    }

    public int multiplicar(int a, int b) {
        return multiplicacao.executar(a, b);
    }

    public int dividir(int a, int b) {
        return divisao.executar(a, b);
    }

}
