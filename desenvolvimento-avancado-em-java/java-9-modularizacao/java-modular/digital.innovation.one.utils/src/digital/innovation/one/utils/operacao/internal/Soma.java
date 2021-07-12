package digital.innovation.one.utils.operacao.internal;

public class Soma implements Operacao {
    @Override
    public int executar(int a, int b) {
        return a+b;
    }
}
