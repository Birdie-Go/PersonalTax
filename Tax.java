package tax;

/**
 * Tax data storage, and tax updata part.
 * @author Zhanhong Fang, 19308030
 * @version 1.0.0
 */
public class Tax {
    private Row[] rows;         // The tax table, a level is a Row.
    private int numRow;         // The row count in the table.

    /**
     * Constructor.
     * The tax rate table:
     *     Level          Start            End           Rate
     *         1           0.00         500.00           0.05
     *         2         500.00        2000.00           0.10
     *         3        2000.00        5000.00           0.15
     *         4        5000.00       20000.00           0.20
     *         5       20000.00            +oo           0.25
     * (-1 means +oo)
     * @author Zhanhong Fang, 19308030
     */
    public Tax() {
        rows = new Row[5];
        rows[0] = new Row();
        rows[0].setStart(0);
        rows[0].setEnd(500);
        rows[0].setRate(0.05);
        rows[1] = new Row();
        rows[1].setStart(500);
        rows[1].setEnd(2000);
        rows[1].setRate(0.1);
        rows[2] = new Row();
        rows[2].setStart(2000);
        rows[2].setEnd(5000);
        rows[2].setRate(0.15);
        rows[3] = new Row();
        rows[3].setStart(5000);
        rows[3].setEnd(20000);
        rows[3].setRate(0.2);
        rows[4] = new Row();
        rows[4].setStart(20000);
        rows[4].setEnd(-1);
        rows[4].setRate(0.25);
        numRow = 5;
    }

    /**
     * Get the interval starting point of provided level.
     * @param i The level of start point.
     * @return The start point.
     * @author Zhanhong Fang, 19308030
     */
    public double getLevelStart(int i) {
        return rows[i].getStart();
    }

    /**
     * Get the interval end point of provided level.
     * @param i The level of end point.
     * @return The end point.
     * @author Zhanhong Fang, 19308030
     */
    public double getLevelEnd(int i) {
        return rows[i].getEnd();
    }

    /**
     * Get the interval tax rate of provided level.
     * @param i The level of tax rate.
     * @return The tax rate.
     * @author Zhanhong Fang, 19308030
     */
    public double getLevelRate(int i) {
        return rows[i].getRate();
    }

    /**
     * Updata the level i with the new rate.
     * @param level The level need to updata.
     * @param rate The new rate.
     * @return 0 for updata succeed, 1 for the rate is not in [0, 1] and 2 for level is not in the tax table.
     * @author Zhanhong Fang, 19308030
     */
    public int updata(int level, double rate) {
        if (1 <= level && level <= numRow) {
            if (rate >= 0 && rate <= 1)
                rows[level - 1].setRate(rate);
            else
                return 1;
        } else
            return 2;
        return 0;
    }
    
    /**
     * Get row number of the tax table.
     * @return The row count.
     * @author Zhanhong Fang, 19308030
     */
    public int getNum() {
        return numRow;
    }
}
