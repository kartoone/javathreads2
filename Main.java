public class Main {
    public static void main(String[] args) {
        int size = 1000000000;
        int mat1d[] = new int[size];
        long start = System.nanoTime();
        Summer s = new Summer(mat1d);
        long total = s.computeSum();
        long end = System.nanoTime();
        System.out.println("Single thread:");
        System.out.println("Total: " + total);
        System.out.println((end-start) + " ns");

        start = System.nanoTime();
        int n = 3;
        int len = mat1d.length / n;
        total = 0L;
        SummerMulti workers[] = new SummerMulti[n];
        for (int i = 0; i < n; i++) {
            // launch these in a thread
            workers[i] = new SummerMulti(mat1d, i*len, len);
            workers[i].start();
        }
        // add sync to wait for threads to finish
        for (int i = 0; i < n; i++) {
            // launch these in a thread
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // add in the total from all three threads when they finish
        for (int i = 0; i < n; i++) {
            total += workers[i].total;
        }
        end = System.nanoTime();
        System.out.println("Multi thread: " + n + " threads");
        System.out.println("Total: " + total);
        System.out.println((end-start) + " ns");

    }
}
