package QuickUnion;

import java.util.Scanner;

public class MainUnion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho de N (quantidade de elementos): ");
        int n = scanner.nextInt();

        QuickUnionUF uf = new QuickUnionUF(n);

        System.out.println("Gerando e imprimindo pares de conexão adversarial...");

        // Captura o tempo inicial (útil para o relatório do seu trabalho)
        long tempoInicio = System.currentTimeMillis();

        // Gera as conexões no formato exigido: o elemento 0 se conecta ao i
        for (int i = 1; i < n; i++) {
            int p = 0;
            int q = i;

            // Imprime o par na tela, conforme solicitado
            System.out.println(p + " " + q);

            // Só une se já não estiverem no mesmo componente
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }
        }

        // Captura o tempo final
        long tempoFim = System.currentTimeMillis();
        long tempoTotal = tempoFim - tempoInicio;

        System.out.println("-----------------------------------");
        System.out.println("Processamento concluído!");
        System.out.println("Tempo total de execução: " + tempoTotal + " ms.");
        System.out.println(uf.count() + " componentes restantes ao final.");

        scanner.close();
    }
}
