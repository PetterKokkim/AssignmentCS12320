package Parking;

import Person.Attendant;
import Vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is class Park
 *
 * @author pwk1
 * @version 1.2
 */

public class Park {

    // ------------- Instance Variables -------------

    private String name = "MultiStoryCarPark";
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Zone> zones;
    private ArrayList<Spot> vehiclePool;
    private ArrayList<Attendant> attendants;

    // ------------- Zone Objects -------------

    Zone zone1 = new Zone("Zone1", 5, 2);
    Zone zone2 = new Zone("Zone2", 5, 0);
    Zone zone3 = new Zone("Zone3", 5, 0);
    Zone zone4 = new Zone("Zone4", 5, 0);
    Zone zone5 = new Zone("Zone5", 5, 0);


    /**
     * Constructor for the class park
     */
    public Park() {
        this.zones = new ArrayList<>();
        this.vehiclePool = new ArrayList<>();
        this.attendants = new ArrayList<>();
    }


    /**
     * This method add all the different zones to the arraylist zones
     * and call the method that makes all the empty spots in the zones
     */
    public void addZones() {
        this.addZone(zone1);
        this.addZone(zone2);
        this.addZone(zone3);
        this.addZone(zone4);
        this.addZone(zone5);

        for (Zone z : zones) {
            z.populateSpot();
        }
    }

    /**
     * This method add the zone to the ArrayList zones
     *
     * @param zone
     */
    public void addZone(Zone zone) {
        zones.add(zone);
    }

    /**
     * This method add vehicles to the ArrayList VehiclePool
     *
     * @param spot
     */
    public void addVehiclePool(Spot spot) {
        vehiclePool.add(spot);
    }

    /**
     * This method add attendatn to the ArrayList attendantPool
     *
     * @param attendant
     */
    public void addAttendantPool(Attendant attendant) {
        attendants.add(attendant);
    }

    /**
     * This method add a standard car and parks it to the correct zone, and it also check if its
     * available spot in the zone
     */
    public void addStandardAndPark() {
        CarStandard standard = new CarStandard();
        Spot spot = new Spot();
        standard.readKeyboard();
        spot.setLicence(standard.getLicence());
        spot.setCheckIn();
        spot.setReceipt();
        spot.setVehicleType("Standard");
        if (standard.setAttend()) {
            this.addVehiclePool(spot);
            System.out.println("Your receipt = " + spot.getReceipt());
        } else if (zone1.availableSpots() <= zone1.getMaxCap()) {
            zones.get(0).addFirst(spot);
            System.out.println("Drive to zone 1, spot " + spot.getSpot());
            System.out.println("Your receipt = " + spot.getReceipt());
        } else if (zone4.availableSpots() <= zone4.getMaxCap()) {
            zones.get(3).addFirst(spot);
            System.out.println("Drive to zone 4, spot " + spot.getSpot());
        } else {
            System.err.println("No available spots for standard vehicle");
        }

    }

    /**
     * This method add a high car and parks it to the correct zone, and also checks if its
     * available spot in the zone
     */
    public void addHighAndPark() {
        CarHigh high = new CarHigh();
        Spot spot = new Spot();
        high.readKeyboard();
        spot.setLicence(high.getLicence());
        spot.setCheckIn();
        spot.setReceipt();
        spot.setVehicleType("High");
        if (high.setAttend()) {
            this.addVehiclePool(spot);
            System.out.println("Your receipt = " + spot.getReceipt());
        } else if (zone1.availableSpots() <= zone1.getMaxCap()) {
            zones.get(0).addFirst(spot);
            System.out.println("Drive to zone 1, spot " + spot.getSpot());
            System.out.println("Your receipt = " + spot.getReceipt());
        } else {
            System.err.println("No available spots for high vehicle");
        }
    }

    /**
     * This method add a long car and parks it to the correct zone, and also checks if its
     * available spot in the zone
     */

    public void addLongAndPark() {
        CarLong carLong = new CarLong();
        Spot spot = new Spot();
        carLong.readKeyboard();
        spot.setLicence(carLong.getLicence());
        spot.setCheckIn();
        spot.setReceipt();
        spot.setVehicleType("Long");
        if (carLong.setAttend()) {
            this.addVehiclePool(spot);
            System.out.println("Your receipt = " + spot.getReceipt());
        } else if (zone2.availableSpots() <= zone2.getMaxCap()) {
            zones.get(1).addFirst(spot);
            System.out.println("Drive to zone 2, spot " + spot.getSpot());
            System.out.println("Your receipt = " + spot.getReceipt());
        } else {
            System.err.println("No available spots for long vehicle");
        }
    }

    /**
     * This method add a coach and parks it to the correct zone, and also checks if its
     * available spot in the zone
     */

    public void addCoachAncPark() {
        Coach coach = new Coach();
        Spot spot = new Spot();
        coach.readKeyboard();
        spot.setLicence(coach.getLicence());
        spot.setCheckIn();
        spot.setReceipt();
        if (zone3.availableSpots() <= zone3.getMaxCap()) {
            zones.get(2).addFirst(spot);
            System.out.println("Drive to zone 3, spot " + spot.getSpot());
            System.out.println("Your receipt = " + spot.getReceipt());
        } else {
            System.err.println("No available spots for coach");
        }
    }

    /**
     * This method add a Motorbike and parks it to the correct zone, and also checks if its
     * available spot in the zone
     */
    public void addMotorbikeAndPark() {
        Motorbike motorbike = new Motorbike();
        Spot spot = new Spot();
        motorbike.readKeyboard();
        spot.setLicence(motorbike.getLicence());
        spot.setCheckIn();
        spot.setReceipt();
        if (zone5.availableSpots() <= zone5.getMaxCap()) {
            zones.get(4).addFirst(spot);
            System.out.println("Drive to zone 5, spot " + spot.getSpot());
            System.out.println("Your receipt = " + spot.getReceipt());
        } else {
            System.err.println("No available spots for motorbike");
        }
    }

    /**
     * This method checks out an vehicle and calculates the cost of its parking
     *
     * @param name = the licence
     */
    public void checkoutForVehicle(String name) {
        for (Zone z : zones) {
            z.calculateCostAndPay(name);
            z.removeSpot(name);

        }
    }

    /**
     * This method does so the admin can edit the zone price and capacity
     *
     * @param zone
     */
    public void editZone(String zone) {
        double newPrice;
        int newMax;
        for (Zone z : zones) {
            if (zone.equals(z.getName())) {
                String response;
                boolean repeat = true;
                while (repeat) {
                    System.out.println("--------- Edit zone ---------");
                    System.out.println("1 - Edit price");
                    System.out.println("2 - Edit maxCap");
                    response = scan.next().toUpperCase();
                    switch (response) {
                        case "1":
                            System.out.println("New price");
                            newPrice = scan.nextDouble();
                            z.setPrice(newPrice);
                            repeat = false;
                            break;

                        case "2":
                            System.out.println("New max cap: ");
                            newMax = scan.nextInt();
                            z.setMaxCap(newMax);
                            z.populateSpot();
                            repeat = false;
                            break;
                    }
                }
            }
        }
    }

    /**
     * This method creates an new attendant and adds it to the list
     */
    public void createAttendant() {
        Attendant attendant = new Attendant(null);
        attendant.readKeyboard();
        this.addAttendantPool(attendant);
    }

    /**
     * This method does so the attendant can pick and vehicle and park it
     */
    public void attendantPark() {
        System.out.println("Enter your name: ");
        String name = scan.next();
        System.out.println(this.printVehiclePool());
        System.out.println("Enter the licence of the vehicle you wanna park: ");
        String licence = scan.next();
        Spot which = null;
        int park;
        for (Attendant a : attendants) {
            if (name.equals(a.getName())) {
                a.setStartWork();
                for (Spot v : vehiclePool) {
                    if (licence.equals(v.getLicence())) {
                        System.out.println(this.printCarPark());
                        System.out.println("Enter the zone you want to park in: ");
                        String zone = scan.next();
                        for (Zone z : zones) {
                            if (zone.equals(z.getName())) {
                                System.out.println(z.toString());
                                System.out.println("Which spot do you wanna park in?");
                                park = scan.nextInt();
                                z.addSpotAttendant(v, park);
                                which = v;
                            }
                        }
                    }
                }
            }
        }
        vehiclePool.remove(which);
    }

    /**
     * This method prints the vehicle pool
     *
     * @return
     */
    public String printVehiclePool() {
        StringBuilder r = new StringBuilder();
        r.append("Vehicles waiting for attendant: " + "\n");

        for (Spot s : vehiclePool) {
            r.append(s.toString());
            r.append("\n");
        }
        return r.toString();
    }

    /**
     * This method prints the attendant pool
     *
     * @return
     */
    public String printAttendantPool() {
        StringBuilder r = new StringBuilder();
        r.append("Total attendees [" + attendants.size() + "]" + "\n");

        for (Attendant a : attendants) {
            r.append(a.toString());
            r.append("\n");
        }
        return r.toString();
    }

    /**
     * This method print the the zones
     *
     * @return
     */
    public String printCarPark() {
        StringBuilder r = new StringBuilder();

        for (Zone zone : zones) {
            r.append(zone.toString());
            r.append("\n");
        }
        return r.toString();
    }

    /**
     * This method load the file for the program
     *
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void load(String filename) throws FileNotFoundException, IOException {
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr);
             Scanner infile = new Scanner(br)) {

            attendants.clear();
            vehiclePool.clear();
            zones.clear();

            infile.useDelimiter("\r?\n|\r");

            name = infile.next();

            int numAttendants = infile.nextInt();
            while (infile.hasNext()) {
                for (int i = 0; i < numAttendants; i++) {
                    Attendant p = new Attendant();
                    p.load(infile);
                    attendants.add(p);
                }
                int numVehicles = infile.nextInt();
                for (int i = 0; i < numVehicles; i++) {
                    Spot v = new Spot();
                    v.load(infile);
                    vehiclePool.add(v);
                }
                for (int i = 0; i < 5; i++) {
                    Zone z = new Zone();
                    z.load(infile);
                    zones.add(z);
                }
            }
        }
    }

    /**
     * This method save the file for the program
     *
     * @param outfileName
     * @throws IOException
     */
    public void save(String outfileName) throws IOException {
        // Again using try-with-resource so that I don't need to close the file explicitly
        try (FileWriter fw = new FileWriter(outfileName);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter outfile = new PrintWriter(bw)) {

            outfile.println(name);

            outfile.println(attendants.size());
            for (Attendant attendant : attendants) {
                attendant.save(outfile);

            }
            outfile.println(vehiclePool.size());
            for (Spot vehiclePool : vehiclePool) {
                vehiclePool.save(outfile);
            }

            for (Zone zone : zones) {
                zone.save(outfile);

            }

        }
    }

}
