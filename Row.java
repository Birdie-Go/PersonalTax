package tax;

/**
 * Storage the row in the tax table.
 * @author Zhanhong Fang, 19308030
 * @version 1.0.0
 */
public class Row {
    private double start;           // Interval starting point.
    private double end;             // Interval end point.
    private double rate;            // Interval tax rate.

    /**
     * Get the interval starting point.
     * @return The interval starting point.
     * @author Zhanhong Fang, 19308030
     */
    public double getStart() {
        return start;
    }
    
    /**
     * Get the interval end point.
     * @return The interval end point.
     * @author Zhanhong Fang, 19308030
     */
    public double getEnd() {
        return end;
    }

    /**
     * Get the interval tax rate.
     * @return The interval tax rate.
     * @author Zhanhong Fang, 19308030
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set the interval starting point.
     * @param x The new interval starting point.
     * @author Zhanhong Fang, 19308030
     */
    public void setStart(double x) {
        start = x;
    }

    /**
     * Set the interval end point.
     * @param x The new interval end point.
     * @author Zhanhong Fang, 19308030
     */
    public void setEnd(double x) {
        end = x;
    }

    /**
     * Set the interval tax rate.
     * @param x The new interval tax rate.
     * @author Zhanhong Fang, 19308030
     */
    public void setRate(double x) {
        rate = x;
    }
}
