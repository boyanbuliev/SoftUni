package RawData;

public class Tire {
    private double t1p;
    private int t1a;
    private double t2p;
    private int t2a;
    private double t3p;
    private int t3a;
    private double t4p;
    private int t4a;

    public Tire(double t1p, int t1a, double t2p, int t2a, double t3p, int t3a, double t4p, int t4a) {
        this.t1p = t1p;
        this.t1a = t1a;
        this.t2p = t1p;
        this.t2a = t1a;
        this.t3p = t1p;
        this.t3a = t1a;
        this.t4p = t1p;
        this.t4a = t1a;
    }

    public boolean isFragile() {
        if (this.t1p < 1 || this.t2p < 1 || this.t3p < 1 || this.t4p < 1) {
            return true;
        }
        return false;
    }
}
