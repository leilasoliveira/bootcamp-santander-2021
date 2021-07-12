package digital.innovation.one.core;

import digital.innovation.one.utils.operacao.Calculadora;
//import digital.innovation.one.utils.operacao.internal.Soma;  // erro de compilação pois não liberei acesso ao pacote internal

public class Runner {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        //Soma soma = new Soma(); // erro de compilação pois não liberei acesso ao pacote internal
        // muito útil para esconder implementações que não se deseja que sejam publicas

        System.out.println(calculadora.somar(3, 3));
    }

}
