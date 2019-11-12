package Vehicle;

import java.util.Scanner;

/**
 * This is class MotorBike -a blueprint for all motorbikes
 *
 * @author pwk1
 * @version 1.2
 */
public class Motorbike implements VehicleInterface {

    // ------------- Instance Variables -------------

    public String licence;

    /**
     * This is an default constructor for class motorbike
     */
    public Motorbike() {
    }

    /**
     * This is an constructor for class motorbike
     *
     * @param licence
     */
    public Motorbike(String licence) {
        this.licence = licence;
    }

    /**
     * This method gets the licence form the motorbike
     * @return
     */
    public String getLicence() {
        return licence;
    }

    /**
     * This method sets the licence for the motorbike
     * @param licence
     */
    public void setLicence(String licence) {
        this.licence = licence;
    }

    /**
     * This method gets the height for the motorbike
     * @return
     */
    @Override
    public double getHeight() {
        return 0;
    }

    /**
     * This method sets the height for the motorbike
     * @param height
     */
    @Override
    public void setHeight(double height) {

    }

    /**
     * This method gets the length of the motorbike
     * @return
     */
    @Override
    public double getLength() {
        return 0;
    }

    /**
     * This method sets the length for the motorbike
     * @param length
     */
    @Override
    public void setLength(double length) {

    }

    /**
     * This method set the attend status
     * @return
     */
    @Override
    public boolean isAttend() {
        return false;
    }

    /**
     * This method set the attend status for motorbike
     * @return
     */
    @Override
    public boolean setAttend() {
        return false;
    }

    /**
     * This method reads the input from user
     */
    public void readKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter licence number: ");
        this.licence = scan.nextLine();

    }

    /**
     * This method prints the information form bike
     * @return
     */
    @Override
    public String toString() {
        return "Motorbike[ licence" + licence + "]";
    }
}
