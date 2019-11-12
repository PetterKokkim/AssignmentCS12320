package Vehicle;

import java.util.Scanner;


/**
 * This is class CarStandard -a blueprint for all CarStandard
 *
 * @author pwk1
 * @version 1.2
 */
public class CarStandard implements VehicleInterface {

    // ------------- Instance Variables -------------

    String licence;
    double height;
    double length;
    boolean attend;

    /**
     * This is an default constructor for class CarStandard
     */
    public CarStandard() {
        super();
    }

    /**
     * This is constructor for the class CarStandard
     *
     * @param licence
     * @param height
     * @param length
     * @param attend
     */
    public CarStandard(String licence, double height, double length, boolean attend) {
        this.licence = licence;
        this.height = height;
        this.length = length;
        this.attend = attend;
    }

    /**
     * This method gets the licence for the car
     *
     * @return
     */
    @Override
    public String getLicence() {
        return licence;
    }

    /**
     * This method sets the licence for the car
     *
     * @param licence
     */
    @Override
    public void setLicence(String licence) {
        this.licence = licence;
    }

    /**
     * This method getst the height for the car
     *
     * @return
     */
    @Override
    public double getHeight() {
        return height;
    }

    /**
     * This method sets the height for the car
     *
     * @param height
     */
    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * This method sets the length for the car
     *
     * @param length
     */
    @Override
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * This method gets the length of the car
     *
     * @return
     */
    @Override
    public double getLength() {
        return length;
    }

    /**
     * This gets the attend status for the car
     *
     * @return
     */
    @Override
    public boolean isAttend() {
        return attend;
    }

    /**
     * This method sets the attend status for the car
     *
     * @return
     */
    @Override
    public boolean setAttend() {
        System.out.println("Require attend? (Y/N)");
        Scanner scan = new Scanner(System.in);
        String type;
        boolean answer = true, valid = true;
        while (valid) {
            type = scan.nextLine().toUpperCase();
            switch (type) {
                case "Y":
                    valid = false;
                    break;
                case "N":
                    answer = false;
                    valid = false;
                    break;
                default:
                    System.err.println("Invalid choice ");
                    System.out.println("Try again (Y/N)" + "\n");
            }
        }
        this.attend = answer;
        return answer;
    }

    /**
     * This method reads the input for the car from user
     */
    public void readKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter licence number: ");
        this.licence = scan.nextLine();
    }

    /**
     * This method print out the information about the car
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();

        r.append("CarStandard [");
        r.append("licence: ").append(licence);
        r.append(". Attend required: ").append(attend).append("]");

        return r.toString();
    }
}

