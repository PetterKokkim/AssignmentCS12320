package Parking;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * This is the clas Spot -a blueprint for every spots
 *
 * @author pwk1
 * @version 1.2
 */

public class Spot {

    // ------------- Instance Variables -------------

    private int spot;
    private String licence;
    private String vehicleType;
    private String receipt;
    private long checkIn;
    private long checkOut;

    // ----------------------------------------------

    /**
     * This is and default constructor for the class Spot
     */
    public Spot() {
    }

    /**
     * This is an constructor for the class Spot
     * @param spot
     * @param licence
     * @param receipt
     */
    public Spot(int spot, String licence, String receipt) {
        this.spot = spot;
        this.licence = licence;
        this.receipt = receipt;
    }

    /**
     * This method gets the licence from the spot
     *
     * @return
     */
    public String getLicence() {
        return licence;
    }

    /**
     * This method sets the licence for the spot
     *
     * @param licence
     */
    public void setLicence(String licence) {
        this.licence = licence;
    }

    /**
     * This method gets the vehicle type
     *
     * @return
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * This sets the vehicle type
     *
     * @param vehicleType
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * This method gets the receipt
     * @return
     */
    public String getReceipt() {
        return receipt;
    }

    /**
     * This method sets the receipt and makes it with UUID
     */
    public void setReceipt() {
        this.receipt = UUID.randomUUID().toString();
    }

    /**
     * This method sets the spot nr
     * @param spot
     */
    public void setSpot(int spot) {
        this.spot = spot;
    }

    /**
     * This method gets the spot nr
     * @return
     */
    public int getSpot() {
        return spot;
    }

    /**
     * This method gets the CheckIn time
     * @return
     */
    public double getCheckIn() {
        return checkIn;
    }

    /**
     * This method set the check in time with System.currentTimeMillis()
     *
     */
    public void setCheckIn() {
        this.checkIn = System.currentTimeMillis();
    }

    /**
     * This method gets the Checkout time
     * @return
     */
    public double getCheckOut() {
        return checkOut;
    }

    /**
     * This method sets the check out time of leaving
     */
    public void setCheckOut() {
        this.checkOut = System.currentTimeMillis();
    }

    /**
     * This method calculate the total time spend in the spot and converts
     * it to hours(Minutes)
     * @return
     */
    public int totalTime() {
        int totalTime = (int) (checkOut - checkIn);
        int hour = (int) TimeUnit.MILLISECONDS.toMinutes(totalTime);
        return hour;
    }

    /**
     * This method prints the information about the spot
     * @return
     */
    public String toString() {
        StringBuilder r = new StringBuilder();

        r.append("Spot [").append(spot).append("]");
        r.append(" Parked [").append(licence).append("]");
        if (checkIn != 0 && checkOut != 0) {
            r.append(" Total time parked [").append(totalTime()).append("min]");
        }
        r.append(" Receipt [").append(receipt).append("]");

        return r.toString();
    }

    /**
     * This method compares the receipt
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return receipt == spot.receipt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receipt);
    }

    /**
     * This method reads the spots from the file
     * @param infile
     */
    public void load(Scanner infile) {
        if (infile == null) {
            throw new IllegalArgumentException("infile must not be null");
        }

        spot = infile.nextInt();
        licence = infile.next();
        receipt = infile.next();
    }

    /**
     * This method save the spot in the file
     * @param outfile
     */
    public void save(PrintWriter outfile) {

        outfile.println(spot);
        outfile.println(licence);
        outfile.println(receipt);

    }
}