package tax;
import java.util.Scanner;

/**
 * User UI.
 * @author Zhanhong Fang, 19308030
 * @version 1.0.0
 */
public class Presentation {
    public static Scanner scan = new Scanner(System.in);

    /**
     * Print main menu, and privode user with the enter choice.
     * @return 0 for calcator, 1 for updata, and 2 for exit.
     * @author Zhanhong Fang, 19308030
     */
    public static int chooseType() {
        System.out.println("\nMain menu:\nPlease enter the proper number to choose the function:");
        System.out.print("0 - calcator the individual income tax\n");
        System.out.println("1 - update the data\n2 - exit the system");
        System.out.print("Your choose : ");
        int choose = 0;
        while (!scan.hasNextInt()) {
            System.out.println("Illegal input!");
            System.out.print("Your choose : ");
            scan.next();
        }
        choose = scan.nextInt();
        return choose;
    }

    /**
     * Privode user with the entrance of salary.
     * @return The salary which user enter in.
     * @author Zhanhong Fang, 19308030
     */
    public static double readSalary() {
        System.out.print("\nPlease enter the total monthly salary income: ");
        double salary;
        while (!scan.hasNextDouble()) {
            System.out.println("Illegal input!");
            System.out.print("\nPlease enter the total monthly salary income: ");
            scan.next();
        }
        salary = scan.nextDouble();
        return salary;
    }

    /**
     * Privode user with the entrance of tax start point.
     * @return The start point which user enter in.
     * @author Zhanhong Fang, 19308030
     */
    public static double readBase() {
        System.out.print("\nPlease enter the new start point: ");
        double start;
        while (!scan.hasNextDouble()) {
            System.out.println("Illegal input!");
            System.out.print("\nPlease enter the new start point: ");
            scan.next();
        }
        start = scan.nextDouble();
        return start;
    }

    /**
     * Privode user with the entrance of tax level.
     * @return The level which user enter in.
     * @author Zhanhong Fang, 19308030
     */
    public static int readLevel() {
        System.out.print("\nWhich level you want to updata: ");
        int level;
        while (!scan.hasNextInt()) {
            System.out.println("Illegal input!");
            System.out.print("\nWhich level you want to updata: ");
            scan.next();
        }
        level = scan.nextInt();
        return level;
    }

    /**
     * Privode user with the entrance of tax rate.
     * @return The rate which user enter in.
     * @author Zhanhong Fang, 19308030
     */
    public static double readRate() {
        System.out.print("\nPlease enter the new rate: ");
        double rate;
        while (!scan.hasNextDouble()) {
            System.out.println("Illegal input!");
            System.out.print("\nPlease enter the new rate: ");
            scan.next();
        }
        rate = scan.nextDouble();
        return rate;
    }

    /**
     * Print updata menu, and privode user with the enter choice.
     * @return 0 for updata start point, and 1 for updata tax rate.
     * @author Zhanhong Fang, 19308030
     */
    public static int chooseUpdata() {
        System.out.print("\nChoose a type you want to updata:\n");
        System.out.print("0 - start point\n1 - tax rate\nPlease enter 0 or 1: ");
        int co;
        while (!scan.hasNextInt()) {
            System.out.println("Illegal input!");
            System.out.print("\nPlease enter 1 or 2: ");
            scan.next();
        }
        co = scan.nextInt();
        return co;
    }

    /**
     * Print the tax table.
     * @param jtax The Tax class need to print.
     * @author Zhanhong Fang, 19308030
     */
    public static void printTable(Tax jtax) {
        System.out.println("The tax rate table: ");
        int numrow = jtax.getNum();
        System.out.printf("%15s%15s%15s%15s\n", "Level", "Start", "End", "Rate");
        for (int i = 0 ; i < numrow; i++) {
            double s = jtax.getLevelStart(i), e = jtax.getLevelEnd(i), r = jtax.getLevelRate(i);
            if (e < 0)
                System.out.printf("%15d%15.2f%15s%15.2f\n", i + 1, s, "+oo", r);
            else
                System.out.printf("%15d%15.2f%15.2f%15.2f\n", i + 1, s, e, r);
        }
    }

    /**
     * The main programm.
     * @author Zhanhong Fang, 19308030
     */
    public static void main(String args[]) {
        StartPoint jbaseline = new StartPoint();
        Tax jtax = new Tax();
        Calcator one = new Calcator(jbaseline, jtax);
        System.out.println("Welcome to Individual Income Tax System!");
        while (true) {
            int choose = chooseType();          // main menu
            if (choose == 0) {

                /* query part, user proivde the salary, and calcalate the tax. */
                double salary = readSalary();
                double handin = one.calc(salary);
                System.out.println("Your individual income tax is : " + handin);
            } else if (choose == 1) {

                /* updata part, updata start point or rate. */
                int ty = chooseUpdata();
                if (ty == 0) {

                    /* updata the start point. */
                    double start = readBase();
                    boolean flag = jbaseline.set(start);
                    if (!flag)
                        System.out.println("Error: The baseline shoule be a non-negative number!");
                    else
                        System.out.println("Update succeeded!");
                }
                else if (ty == 1) {

                    /* update the interve tax rate. */
                    printTable(jtax);
                    int level = readLevel();
                    double rate = readRate();
                    int flag = jtax.updata(level, rate);
                    if (flag == 1)
                        System.out.println("Error: The rate shoule be a non-negative number and must less equal than 1!");
                    else if (flag == 2)
                        System.out.println("Error: The level shoule between 1 and 5!");
                    else
                        System.out.println("Update succeeded!");
                } else
                    System.out.println("Illegal input!");
            } else if (choose == 2) {

                /* exit part. */
                break;
            } else {
                System.out.println("Illegal input!");
            }
        }
        scan.close();
    }
}
