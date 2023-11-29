public class SummerMulti extends Thread {

    protected int mat1d[];
    protected int start;
    protected int length;
    protected long total; // our total

    // take in the shared memory reference 
    // as well as our starting and how many numbers we should add
    public SummerMulti(int mat1d[], int start, int length) {
        this.mat1d = mat1d;
        this.start = start;
        this.length = length;
    }

    // computer our subtotal
    public void computeSum() {
        total = 0L;
        for (int i = start; i < start + length; i++) {
            total += mat1d[i];
        }
    }

    @Override
    public void run() {
        this.computeSum();
    }
}
