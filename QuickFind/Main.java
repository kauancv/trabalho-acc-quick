package QuickFind;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("1: 10000 | 2: 50000 | 3: 100000 | 4: 500000");
        Scanner scanner = new Scanner(System.in);
        String opc = scanner.nextLine();

        int n;
        switch (opc) {
            case "1": n = 10000; break;
            case "2": n = 50000; break;
            case "3": n = 100000; break;
            case "4": n = 500000; break;
            default: throw new AssertionError();
        }

        QuickFindUF uf = new QuickFindUF(n);

        PrintWriter writer = new PrintWriter(new FileWriter("quickfind_" + n + ".csv"));
        writer.println("operacao,custo,total,media");

        long inicio = System.nanoTime();

        int total = 0;

        for (int i = 1; i < n; i++) {

            int p = 0;
            int q = i;

            int antes = uf.getAccesses();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }

            int depois = uf.getAccesses();

            int custo_i = depois - antes;
            total += custo_i;
            double media = (double) total / i;

            writer.println(i + "," + custo_i + "," + total + "," + media);
        }

        long fim = System.nanoTime();

        writer.close();

        double tempo = (fim - inicio) / 1_000_000.0;

        System.out.println("QuickFind");
        System.out.println("N = " + n);
        System.out.println("Tempo: " + tempo + " ms");
        System.out.println("CSV gerado!");
    }
}