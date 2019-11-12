package Person;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is the class for the People -a blueprint for all people
 */

public class People {

    // ------------- Instance Variables -------------
    String name;


    /**
     * This is and default constructor for class people
     */
    public People() {

    }

    /**
     * This is an constructor for class people
     *
     * @param name
     */
    public People(String name) {
        this.name = name;
    }

    /**
     * This in an method for get the name of the people
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name for the people
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method read the input from the user to people
     */
    public void readKeyboard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scan.next();
    }

    /**
     * This method prints out the information about the people
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();

        r.append("Name [" + name + "]");

        return r.toString();
    }

    /**
     * This method reads the information about people from the file
     *
     * @param infile
     */
    public void load(Scanner infile) {
        if (infile == null) {
            throw new IllegalArgumentException("infile must not be null");
        }
        name = infile.nextLine();
    }

    /**
     * This method writes the information about the people to the file
     *
     * @param outfile
     */
    public void save(PrintWriter outfile) {
        if (outfile == null)
            throw new IllegalArgumentException("outfile must not be null");

        outfile.println(name);
    }

}
