import java.awt.event.ActionEvent;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;
/**
 * Constructs and initializes Database constructor to open File, read each line from
 * the Produceitem.txt file using BufferedReader and FileReader classes.
 * Then StringTokenizer is used to separate the Strings and assign them to String type,String Code, String name, Float price
 * using a method nexToken.
 * checks if the its either a fruit or a vegetable then adds it to ProduceItem.java.
 * and then it adds them to the thelist.append.
 * @Param does not take in any Parameters.
 * @return does not return anything.
 * @Throws FileNotFoundException and IOException and numberFormatException.
 *
 */
public class Database {

    Producelist thelist = new Producelist();
    StringTokenizer tokenizer;
    ProduceItem dfruit;
    ProduceItem dveg;
    ArrayList<ProduceItem> displayfruit = new ArrayList<>();
    ArrayList<ProduceItem> displayveg = new ArrayList<>();
    Iterator indivItems = displayfruit.iterator();
    Iterator indivItems2 = displayveg.iterator();
    String[] fruit = new String[100];
    String[] veg = new String[100];
    int count3 = 0;
    int count2 = 0;


    /**
     *
     * database to send data from file to the LinkedList. i've explained in the above paragraph.
     * this is where i sent my file from the actionlisteners that opens up the database to send here and fill up the Linked List.
     * for some reason after the method is done running the linked list is empty, but doing it the following way the Linked List isn't
     * empty. In my email it explains further.
     */



public Database(){

    //public void fatabase(File pop) {



           File listOfProducts = new File("src/produceitem.txt");
            // Creates a File object that allows you to work with files on the hardrive.

            try {

                //BufferedReader getInfo = new BufferedReader(
                       // new FileReader(pop));

                BufferedReader getInfo = new BufferedReader(
                        new FileReader(listOfProducts));

                // FileWriter is used to write streams of characters to a file
                // BufferedReader reads as many characters as possible
                // them all at one time (Speeds up the Program)

                String Info = getInfo.readLine();

                // Reads a whole line from the file and saves it in a String


                while (Info != null) {
                    tokenizer = new StringTokenizer(Info, ",");
                    //split the different strings in the Line Info with the condition of ","
                    while (tokenizer.hasMoreElements())
                    // checks if there are more tokens
                    {

                        String type = tokenizer.nextToken();
                        System.out.print(type);
                        String code = tokenizer.nextToken();
                        //gives the first token the String code
                        String name = tokenizer.nextToken();
                        //gives the second token the string name
                        float price = Float.parseFloat(tokenizer.nextToken());
                        //uses a parse float to convert String into a float


                        if (type.equals("F")) {
                            dfruit = new fruit(type, code, name, price);
                            thelist.append(dfruit);
                            //displayfruit.add(dfruit);


                        } else {
                            dveg = new veg(type, code, name, price);
                            thelist.append(dveg);
                            //displayveg.add(dveg);


                        }

                        Info = getInfo.readLine();
                    }


                }
                getInfo.close();
                //closes the file
            } catch (FileNotFoundException e) {
                //you have to catch this when you call Filereader
                System.out.println("Couldn't Find the File");
                System.exit(0);
                //error of the File reader
            } catch (IOException e) {

                System.out.println("An I/O Error Occurred");
                System.exit(0);

            } catch (NumberFormatException exception) {
                System.out.println("Error in input. Line ignored:");

            }


        }

    /**
     * getname accepts a String Parameter called code, which is used to check the ProduceList which is the LinkedList
     * and returns a name by matching the code of the item from the transaction.txt file to the code
     * of ProduceList.
     * @param code code coordinate from transaction.txt
     * @return Name back to Main to output array
     *
     */
    public String getName(String code){
        return thelist.getName(code);
    }

    /**
     * getname accepts a String Parameter called code, which is used to check the ProduceList which is the LinkedList
     * and returns the price by matching the code of the item from the transaction.txt file to the code
     * of ProduceList.
     * @param code code coordinate from transaction.txt
     * @return Price back to Main to output array
     *
     */
    public float getPrice( String code){
        return thelist.getPrice(code);
    }

    /**
     * fills up both arrays to hold the data for displayfruit and displayveg in actions listener.
     * @param type
     */
    public void gettType(String type) {
        node current = thelist.first.getNext();
        if(type.equals("F")) {
            while (current != null)  {
                System.out.println("notnull");
                if (current.getType().equals(type)) {
                    //type = current.getType();
                    fruit[count2++] = current.getType() + "\t" + current.getName() + "\t" + current.getPrice();
                }
                current = current.getNext();
            }
        }

        else if(type.equals("V")){
            while (current != null) {
                if (current.getType().equals(type)) {
                    //type = current.getType();
                    veg[count3++] = current.getType() + "\t" + current.getName() + "\t" + current.getPrice();
                }
                current = current.getNext();
            }
        }

    }

    /**public ProduceItem DisplayFruits(){
        for (int i=0; i<displayfruit.size(); i++){
            return displayfruit.get(i);

        }
        return null;
    }
    public ProduceItem Displayveg(){
        for (int i=0; i<displayveg.size(); i++){
            return displayveg.get(i);

        }
        return null;
    }
    public String getType(String code){
        return thelist.getType(code);
    }**/



}
