public class Main {
    public static void main(String[] args) {
        int size = 1000000000;
        int mat1d[] = new int[size];
        Summer s = new Summer(mat1d);
        long start = System.nanoTime();
        long total = s.computeSum();
        long end = System.nanoTime();
        System.out.println("Single thread:");
        System.out.println("Total: " + total);
        System.out.println((end-start) + " ns");

        start = System.nanoTime();
        int n = 3;
        int len = mat1d.length / n;
        total = 0L;
        for (int i = 0; i < n; i++) {
            // launch these in a thread
            SummerMulti sm = new SummerMulti(mat1d, i*len, len);
            total += sm.computeSum();
        }
        // add sync to wait for threads to finish
        end = System.nanoTime();
    }
}
