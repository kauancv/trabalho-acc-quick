package WeightedQuickUnionUF;

import java.util.Scanner;
public class MainWeighted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho (N) para a estrutura Union-Find: ");
        int n = scanner.nextInt();

        // Inicializa a estrutura
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);

        System.out.println("\nGerando pares automaticamente no formato adversarial...");
        System.out.println(n); // Imprime o N inicial simulando o arquivo de entrada

        // Inicia o cronômetro em milissegundos
        long tempoInicial = System.currentTimeMillis();

        // Gera os pares: (0 1), (0 2), (0 3) ... (0 N-1)
        for (int i = 1; i < n; i++) {

            // Verifica se já estão conectados
            if (uf.find(0) != uf.find(i)) {
                uf.union(0, i);
            }

            // Imprime apenas os 10 primeiros para não atrasar o cronômetro
            if (i <= 10) {
                System.out.println("0 " + i);
            } else if (i == 11) {
                System.out.println("... (impressões ocultadas para não afetar a medição de tempo)");
            }
        }

        // Para o cronômetro
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;

        System.out.println("\nProcessamento concluído!");
        System.out.println(uf.count() + " componente(s) restante(s) (o esperado é 1).");

        // Exibe o tempo total gasto
        System.out.println("Tempo total de processamento: " + tempoTotal + " milissegundos (" + (tempoTotal / 1000.0) + " segundos).");

        scanner.close();
    }
}
