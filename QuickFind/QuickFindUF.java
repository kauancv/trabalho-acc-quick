package QuickFind;

public class QuickFindUF {
    private int[] id;
    private int count;
    private int accesses; 

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            accesses++; 
        }
    }

    public int getAccesses() {
        return accesses;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        accesses++; 
        return id[p];
    }

    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException();
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);

        accesses += 2;
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {
            accesses++; 
            if (id[i] == pID) {
                id[i] = qID;
                accesses++; 
            }
        }

        count--;
    }
}