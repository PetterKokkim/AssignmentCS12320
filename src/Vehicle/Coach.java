package Vehicle;

import java.util.Scanner;

/**
 * This is class Coach -a blueprint for all coaches
 *
 * @author pwk1
 * @version 1.2
 */
public class Coach implements VehicleInterface {

    // ------------- Instance Variables -------------

    private String licence;
    private double height;
    private double length;

    /**
     * An default constructor for the class Coach
     */
    public Coach() {
    }

    /**
     * Constructor for the class coach
     *
     * @param licence
     * @param height
     * @param length
     */
    public Coach(String licence, double height, double length) {
        this.licence = licence;
        this.height = height;
        this.length = length;

    }

    /**
     * This method gets the licence for the coach
     *
     * @return
     */
    public String getLicence() {
        return licence;
    }

    /**
     * This method sets the licence for the coach
     *
     * @param licence
     */
    public void setLicence(String licence) {
        this.licence = licence;
    }

    /**
     * This method gets the height for the coach
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * This method sets the height for the coach
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * This method gets the length for the coach
     *
     * @return
     */
    public double getLength() {
        return length;
    }

    /**
     * This method sets the length for the coach
     *
     * @param length
     */
    public void setLength(double length) {
        if (length <= 15) {
            this.length = length;
        } else {
            System.err.println("Error");
        }
    }

    @Override
    public boolean isAttend() {
        return false;
    }

    public boolean setAttend() {

        return false;
    }

    /**
     * This reads the information form user to coach
     */
    public void readKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter licence number: ");
        this.licence = scan.nextLine();
    }

    /**
     * This method prints the information about coach
     *
     * @return
     */
    public String toString() {
        StringBuilder r = new StringBuilder();

        r.append("Coach[ ");
        r.append("licence: ").append(licence);
        r.append(" height: ").append(height).append("m");
        r.append(" and length: ").append(length).append("m ]");

        return r.toString();
    }

}
