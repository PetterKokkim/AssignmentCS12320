package Person;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This is class Attendant -a blue print for every attendants
 *
 * @author pwk1
 * @version 1.2
 */

public class Attendant extends People {

    // ------------- Instance Variables -------------

    private boolean available = true;
    private long startWork;
    private int time;

    /**
     * An default constructor for class Attendant
     */
    public Attendant() {
    }

    /**
     * This is and constructor for class attendant
     *
     * @param name
     */
    public Attendant(String name) {
        super(name);
    }


    /**
     * This method returns the Available of the attendant
     *
     * @return
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * This method sets the available for the attendant
     *
     * @return
     */

    public boolean setAvailable() {
        this.available = false;
        if (time <= 3) {
            this.available = true;
            this.startWork = System.currentTimeMillis();
        }
        return available;
    }

    /**
     * This method starts the timer for the attendant
     */
    public void setStartWork() {
        this.startWork = System.currentTimeMillis();
        this.time = (int) TimeUnit.MILLISECONDS.toMinutes(startWork);
    }

    /**
     * This prints out the information for the attendant
     *
     * @return
     */
    public String toString() {
        StringBuilder r = new StringBuilder();

        r.append(super.toString());
        r.append(" Available [").append(this.setAvailable()).append("]");

        return r.toString();
    }

    /**
     * This method reads the information about the attendant from the file
     *
     * @param infile
     */
    @Override
    public void load(Scanner infile) {
        if (infile == null) {
            throw new IllegalArgumentException("infile must not be null");
        }

        name = infile.next();
        available = infile.nextBoolean();
    }

    /**
     * This method writes the information about the attendant to the file
     *
     * @param outfile
     */
    @Override
    public void save(PrintWriter outfile) {
        if (outfile == null)
            throw new IllegalArgumentException("outfile must not be null");

        outfile.println(name);
        outfile.println(available);

    }

}
