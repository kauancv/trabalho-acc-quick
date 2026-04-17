package QuickFind;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainMedium {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("arquivosdeteste\\mediumUF.txt"));

        int n = sc.nextInt();

        QuickFindUF uf = new QuickFindUF(n);

        PrintWriter writer = new PrintWriter(new FileWriter("medium_quickfind.csv"));
        writer.println("operacao,custo,total,media");

        int total = 0;
        int i = 0;

        while (sc.hasNext()) {

            int p = sc.nextInt();
            int q = sc.nextInt();

            int antes = uf.getAccesses();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }

            int depois = uf.getAccesses();

            int custo_i = depois - antes;
            total += custo_i;

            i++;
            double media = (double) total / i;

            writer.println(i + "," + custo_i + "," + total + "," + media);
        }

        writer.close();
        sc.close();

        System.out.println("Medium finalizado!");
    }
}