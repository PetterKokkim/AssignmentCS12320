import Parking.Park;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main app for the MultiStory CarPark
 *
 * @author pwk1
 * @version 1.2
 */
public class MCPApp {

    private String filename;
    private Scanner scan;
    private Park park;

    private MCPApp() {
        scan = new Scanner(System.in);
        System.out.println("Please enter the filename of CarPark: ");
        filename = scan.next();

        park = new Park();
    }

    private void initialise() {
        System.out.println("Using file ");

        try {
            park.load(filename);
        } catch (FileNotFoundException e) {
            System.err.println("The file: " + " does not exist. Assuming first use and an empty file." +
                    " If this is not the first use then have you accidentally deleted the file?");
        } catch (IOException e) {
            System.err.println("An unexpected error occurred when trying to open the file " + filename);
            System.err.println(e.getMessage());
        }
    }

    private void sizeMap() {
        System.out.println("--------- Size map ---------");
        System.out.println("Standard: Height = 2m, Length = 5m");
        System.out.println("High: Height = 2m - 3m, Length = 5m");
        System.out.println("Long: Height = 3m, Length = 5.1m - 6m");
    }

    private void runApp() {
        String response;
        do {
            System.out.println("--------- Welcome to Multi-Story Car-Park ---------");
            System.out.println("1 - Add vehicle ");
            System.out.println("2 - Pick up vehicle");
            System.out.println("3 - Attendant");
            System.out.println("4 - Admin");
            System.out.println("Q - Quit");
            response = scan.next().toUpperCase();
            switch (response) {
                case "1":
                    this.addVehicle();
                    break;
                case "2":
                    this.checkOut();
                    break;
                case "3":
                    this.attendantMenu();
                    break;
                case "4":
                    this.adminMenu();
                case "Q":
                    break;
                default:
                    System.out.println("Try again");
            }
        }
        while (!(response.equals("Q")));
    }

    private void addVehicle() {
        String response;
        boolean repeat = true;
        while (repeat) {
            System.out.println("--------- Vehicle type ---------");
            System.out.println("1 - Car");
            System.out.println("2 - Coach");
            System.out.println("3 - Motorbike");
            response = scan.next().toUpperCase();
            switch (response) {
                case "1":
                    this.addCar();
                    repeat = false;
                    break;
                case "2":
                    park.addCoachAncPark();
                    repeat = false;
                    break;
                case "3":
                    park.addMotorbikeAndPark();
                    repeat = false;
                    break;
            }
        }
    }

    private void addCar() {
        String response;
        boolean repeat = true;
        while (repeat) {
            System.out.println("--------- Car type ---------");
            System.out.println("1 - Standard");
            System.out.println("2 - High");
            System.out.println("3 - Long");
            System.out.println("4 - Size map");
            response = scan.next().toUpperCase();
            switch (response) {
                case "1":
                    park.addStandardAndPark();
                    repeat = false;
                    break;
                case "2":
                    park.addHighAndPark();
                    repeat = false;
                    break;
                case "3":
                    park.addLongAndPark();
                    repeat = false;
                    break;
                case "4":
                    this.sizeMap();
                    break;
            }
        }
    }

    private void attendantMenu() {
        String response;
        do {
            System.out.println("--------- Attendant ---------");
            System.out.println("1 - Create new attendant");
            System.out.println("2 - Park vehicle");
            System.out.println("3 - Print vehicle pool");
            System.out.println("4 - Print attendant pool");
            System.out.println("Q - Quit");
            response = scan.next().toUpperCase();
            switch (response) {
                case "1":
                    park.createAttendant();
                    break;
                case "2":
                    park.attendantPark();
                    break;
                case "3":
                    System.out.println(park.printVehiclePool());
                    break;

                case "4":
                    System.out.println(park.printAttendantPool());

                    break;
                case "q":
                    break;
            }
        }
        while (!(response.equals("Q")));
    }

    private void adminMenu() {
        String response;
        do {
            System.out.println("--------- Admin ---------");
            System.out.println("1 - Edit zone");
            System.out.println("2 - Populate Zone");
            System.out.println("3 - Print Car park");
            System.out.println("4 - Print attendant pool");
            System.out.println("5 - Print vehicle pool");
            System.out.println("Q - Quit");
            response = scan.next().toUpperCase();
            switch (response) {
                case "1":
                    this.editZone();
                    break;
                case "2":
                    park.addZones();
                    break;
                case "3":
                    System.out.println(park.printCarPark());
                    break;
                case "4":
                    System.out.println(park.printAttendantPool());
                    break;
                case "5":
                    System.out.println(park.printVehiclePool());
                    break;
                case "Q":
                    break;
            }
        }
        while (!(response.equals("Q")));
    }

    private void editZone() {
        System.out.println("Enter zone: ");
        String zone = scan.next();
        park.editZone(zone);
    }

    private void checkOut() {
        System.out.println("Enter receipt: ");
        String receipt = scan.next();
        park.checkoutForVehicle(receipt);
    }

    private void save() {
        try {
            park.save(filename);
        } catch (IOException e) {
            System.err.println("Problem when trying to write to file: " + filename);
        }
    }

    public static void main(String[] args) {
        System.out.println("--------- HELLO ---------");

        MCPApp app = new MCPApp();
        app.initialise();
        app.runApp();
        app.save();

        System.out.println("--------- GOODBYE ---------");
    }
}
