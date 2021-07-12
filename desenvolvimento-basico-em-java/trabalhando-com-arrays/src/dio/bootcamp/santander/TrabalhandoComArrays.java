package dio.bootcamp.santander;

public class TrabalhandoComArrays {
    public static void main(String[] args) {

        // formas de criar array
        int[] meuArray = new int[7];
        int[] outroArray = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Imprimindo conteúdo do array meuArray: \n(inicializa todas as posições com o valor padrão)");
        for (int i = 0; i < meuArray.length; i++) {
            System.out.print(meuArray[i] + " ");
        }

        System.out.println();

        System.out.println("Imprimindo conteúdo do array outroArray: ");
        for (int i = 0; i < outroArray.length; i++) {
            System.out.print(outroArray[i] + " ");
        }

        System.out.println();

        // arrays multidimensionais
        int[][] multi = {{1,2,3,4,5}, {6,7,8}};
        for (int i = 0; i < multi.length; i++) {
            System.out.print("Posição " + i + ": ");
            for (int j = 0; j < multi[i].length; j++) {
                System.out.print(multi[i][j] + " ");
            }
            System.out.println();
        }

    }
}
