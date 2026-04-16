package QuickFind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o tamanho de N: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            // Inicia a contagem do tempo
            long tempoInicio = System.currentTimeMillis();

            QuickFindUF uf = new QuickFindUF(n);

            System.out.println("Processando e imprimindo todas as conexões:");

            // Gera e imprime todos os pares (0, i)
            for (int i = 1; i < n; i++) {
                int p = 0;
                int q = i;

                if (uf.find(p) == uf.find(q)) {
                    continue;
                }

                uf.union(p, q);

                // Impressão obrigatória de todos os pares
                System.out.println(p + " " + q);
            }

            long tempoFim = System.currentTimeMillis();
            long tempoTotal = tempoFim - tempoInicio;

            System.out.println("---------------------------------------");
            System.out.println("Total de componentes restantes: " + uf.count());
            System.out.println("Tempo total (incluindo impressões): " + tempoTotal + " ms");
        }

        scanner.close();
    }
}