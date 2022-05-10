package tax;

/**
 * Storage the tax starting point, and updata part of it.
 * @author Zhanhong Fang, 19308030
 * @version 1.0.0
 */
public class StartPoint {
    private double baseline;            // The tax starting point.
    
    /**
     * Constructor.
     * The initial start point is 800 RMB.
     * @author Zhanhong Fang, 19308030
     */
    public StartPoint() {
        baseline = 800.0;
    }

    /**
     * Updata the starting point.
     * @param _baseline The new tax starting point.
     * @return true - updata succeeded, false - updata failed.
     * @author Zhanhong Fang, 19308030
     */
    public boolean set(double _baseline) {
        if (_baseline >= 0) {
            baseline = _baseline;
            return true;
        }
        return false;
    }

    /**
     * Get the tax starting point.
     * @return The tax starting point.
     * @author Zhanhong Fang, 19308030
     */
    public double get() {
        return baseline;
    }
}
