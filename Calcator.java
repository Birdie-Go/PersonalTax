package tax;

/**
 * Calculate individual income tax.
 * @author Zhanhong Fang, 19308030
 * @version 1.0.0
 */
public class Calcator {
    private StartPoint jbaseline;
    private Tax jtax;

    /**
     * Constructor.
     * @param _baseline The instantiation of the start point.
     * @param _jtax The instantiation of the tax table.
     * @author Zhanhong Fang, 19308030
     */
    public Calcator(StartPoint _baseline, Tax _jtax) {
        jbaseline = _baseline;
        jtax = _jtax;
    }
    
    /**
     * It provides the tax payable with the salary.
     * It means : tax payable = max(0, salary - baseline) 
     * @param salary Salary entered by user.
     * @return Tax payable.
     * @author Zhanhong Fang, 19308030
     */
    public double subtraction(double salary) {
        double baseline = jbaseline.get();
        if (salary >= baseline)
            return salary - baseline;
        return 0;
    }

    /**
     * With the tax payable, calculate the individual income tax.
     * The salary in the interval would produce tax with the rate of this level.
     * @param salary Tax payable.
     * @return Individual income tax.
     * @author Zhanhong Fang, 19308030
     */
    public double calc(double salary) {
        salary = subtraction(salary);
        double handin = 0;
        int num = jtax.getNum();
        for (int i = 0; i < num - 1; i++) {
            if (salary > jtax.getLevelStart(i))
                handin += (Math.min(salary, jtax.getLevelEnd(i)) - jtax.getLevelStart(i)) * jtax.getLevelRate(i);
        }
        if (salary > jtax.getLevelStart(num - 1)) {

            /* The last interval, with no end point. */
            handin += (salary - jtax.getLevelStart(num - 1)) * jtax.getLevelRate(num - 1);
        }

        return handin;
    }
}
