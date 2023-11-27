public class Summer {
    
    protected int mat1d[];

    public Summer(int mat1d[]) {
        this.mat1d = mat1d;
    }

    public long computeSum() {
        long total = 0L;
        for (int i = 0; i < mat1d.length; i++) {
            total += mat1d[i];
        }
        return total;
    }

}
