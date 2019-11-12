package Parking;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * This is an class Zone - a blueprint for every zones
 *
 * @author pwk1
 * @version 1.2
 */
public class Zone {

    // ------------- Instance Variables -------------

    private String name;
    private int maxCap;
    private double price;
    private ArrayList<Spot> spots = new ArrayList<>();

    // ----------------------------------------------

    /**
     * This in an default constructor for the class Zone
     */
    public Zone() {
    }

    /**
     * This is an constructor for the class Zone
     *
     * @param name - name of the zone
     * @param max  - Max spots in the zone
     * @param p    - Price for the zone
     */
    public Zone(String name, int max, double p) {
        this.name = name;
        this.maxCap = max;
        this.price = p;
        spots = new ArrayList<>(maxCap);
    }

    /**
     * This method gets the name of the zone
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method gets the max capacity of the zone
     *
     * @return
     */
    public int getMaxCap() {
        return maxCap;
    }

    /**
     * This method sets the max capacity for the zone
     *
     * @param maxCap
     */
    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    /**
     * This gets the price of the zone
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * This sets the price for the zone
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This populates the arraylist spots with empty spots with null
     */
    public void populateSpot() {
        spots.clear();
        for (int i = 1; i <= maxCap; i++) {
            spots.add(new Spot(i, null, null));
        }
    }

    /**
     * This method adds to the spot
     *
     * @param spot
     */
    public void add(Spot spot) {
        spots.add(spot);
    }

    /**
     * This method add to the spots
     *
     * @param spot
     * @param id
     */
    public void add(Spot spot, int id) {
        spots.add(id - 1, spot);
    }


    /**
     * This method adds a spot to the spots with attendant functions
     *
     * @param spot
     * @param spotID
     */
    public void addSpotAttendant(Spot spot, int spotID) {
        String n = "null";
        Spot which = null;
        for (Spot s : spots) {
            if (null == (s.getLicence())) {
                which = s;
                break;
            } else if (n.equals(s.getLicence())) {
                which = s;
                break;
            }

        }
        if (which != null) {
            spots.remove(which);
            spot.setSpot(spotID);
            this.add(spot, spotID);
        }
    }


    /**
     * This method add to the first spot with null
     *
     * @param spot
     */
    public void addFirst(Spot spot) {
        String n = "null";
        int where = 0;
        Spot which = null;
        for (Spot s : spots) {
            if (null == (s.getLicence())) {
                which = s;
                where = s.getSpot();
                break;
            } else if (n.equals(s.getLicence())) {
                which = s;
                where = s.getSpot();
                break;
            }

        }
        if (which != null) {
            spots.remove(which);
            spot.setSpot(where);
            this.add(spot, where);
        } else {
            System.out.println("Cant add " + spot);
        }
    }

    /**
     * This counts the available spots in the arraylist
     *
     * @return
     */
    public int availableSpots() {
        String n = "null";
        int count = 0;
        for (Spot s : spots) {
            if (s.getLicence().equals(n)) {
                count++;
            } else if (s.getLicence() == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method removes a spot from the arraylist and adds a empty one
     *
     * @param name
     */
    public void removeSpot(String name) {
        Spot which = null;
        int where = 0;
        for (Spot s : spots) {
            if (name.equals(s.getReceipt())) {
                where = s.getSpot();
                which = s;
                break;
            }
        }
        if (which != null) {
            spots.remove(which);
            this.add(new Spot(where, null, null), where);
            System.out.println("Removed " + which);
        }
    }

    /**
     * This method calculates the cost and the pay functions when the customer checks out
     *
     * @param name
     */
    public void calculateCostAndPay(String name) {
        Scanner scan = new Scanner(System.in);
        double pay;
        double payed;
        double change;
        for (Spot s : spots) {
            if (name.equals(s.getReceipt())) {
                s.setCheckOut();
                pay = s.totalTime() * price;
                System.out.println("Total cost for [" + s.totalTime() + "] is [" + pay + "]");
                System.out.println("Pay: " + pay);
                payed = scan.nextDouble();
                if (payed > pay) {
                    change = payed - pay;
                    System.out.println("Change: " + change);
                } else {
                    System.out.println("No change");
                }
                break;
            }
        }
    }

    /**
     * This method prints the information about the zone
     *
     * @return
     */
    public String toString() {
        StringBuilder r = new StringBuilder();
//        int count = this.availableSpots();

        r.append(name);
//        r.append(" Available spots: [" + (count) + "]");
        r.append(" [Price: " + price);
        r.append(", max spots: " + maxCap + "]").append("\n");
        for (Spot spot : spots) {
            r.append(spot.toString()).append("\n");
        }
        return r.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return Objects.equals(name, zone.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    /**
     * This method read the zone data from the file
     *
     * @param infile
     */
    public void load(Scanner infile) {
        if (infile == null) {
            throw new IllegalArgumentException("infile must not be null");
        }
        spots.clear();
        name = infile.next();
        maxCap = infile.nextInt();
        price = infile.nextDouble();

        Spot spot = null;
        for (int i = 0; i < maxCap; i++) {
            spot = new Spot();
            spot.load(infile);
            spots.add(spot);
        }
    }

    /**
     * This method saves the zone information to the file
     *
     * @param outfile
     */
    public void save(PrintWriter outfile) {
        if (outfile == null)
            throw new IllegalArgumentException("outfile must not be null");
        outfile.println(name);
        outfile.println(maxCap);
        outfile.println(price);

        for (Spot spot : spots) {
            spot.save(outfile);
        }

    }

}

