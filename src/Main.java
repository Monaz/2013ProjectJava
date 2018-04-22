import java.awt.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;

/**
 * creates Jframe that intializes a database/opentrans/display fruits/display veg
 */
public class Main extends JFrame implements ActionListener {
    private JMenuItem opentrans = new JMenuItem("opentrans");
    private JMenuItem quit = new JMenuItem("quit");
    private JMenuItem displayfruits = new JMenuItem("displayfruits");
    private JMenuItem displayvegs = new JMenuItem("display veg");
    public JMenuItem openDatabase = new JMenuItem("open database");
    int returnVal;

    public Main() {

        JFrame F = new JFrame("menu");
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("file");
        JMenu menu2 = new JMenu("open DB");
        opentrans.addActionListener(this);
        quit.addActionListener(this);
        displayfruits.addActionListener(this);
        displayvegs.addActionListener(this);
        openDatabase.addActionListener(this);
        menu1.add(opentrans);
        menu1.add(quit);
        menu2.add(openDatabase);
        menu2.add(displayfruits);
        menu2.add(displayvegs);
        menubar.add(menu1);
        menubar.add(menu2);
        F.setJMenuBar(menubar);
        F.setSize(300, 600);
        F.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TextArea area= new TextArea();

    } /**
     * JFrame constructor that accepts three Parameters output[], count and total. These are used to output the String
     * that was created in Main. this constructor prints out the Customer Receipt.
     *
     * @param output output[]
     * @param count count total number of transactions
     * @param total total cost of all the items
     */

    public Main(String output[], int count, String total) {
        super("Customer Receipt");
        TextArea area= new TextArea();

        for (int x = 0; x < count; x++) {
            area.append(output[x]+"\n");
        }

        area.append("Grand Total:                            $" + total);
        add(area);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 600);
        setVisible(true);
    }
    /**
     * JFrame constructor that accepts 2 Parameters output[], count. These are used to output the String
     * that was created in Main. this constructor prints out the display fruits/veg
     *
     * @param output output[]
     * @param count count total number of transactions
     *
     */

    public Main(String output[], int count) {
        super("Produce");
        TextArea area= new TextArea();

        for (int x = 0; x < count; x++) {
            area.append(output[x]+"\n");
        }
        //area.append("Grand Total:                            $"+total);
        add(area);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

         Database object = new Database();

        //object.gettType("F");

        //object.gettType("v");
        String[] output = new String[100];


        int count = 0;
        float total = 0;
        float sum;
        String pattern="##.##";
        DecimalFormat myFormatter = new DecimalFormat(pattern);



        /**
         * pens Transaction.txt using File, BufferedReader and FileReader. The data from the
         * Transaction.txt is split using String Tokenizer, each string is then split using ",". The methods getname and getprice are used to store data in the
         * array called Output[]. Sum is also stored. The "total" variable is also used to retrieve the total value for
         * entire transaction every time a code matches the ProduceList using the methods stated above. The Data
         * created is then sent to Receipt.Gui with three parameters called output, count, total.
         * This is all allowed because instance of the database is initialized.
         * the data is then formatted using DecimalFormat class.
         * @Param does not take in any Parameters.
         * @return does not return anything.
         * @Throws FileNotFoundException and IOException and numberFormatException.
         * @author Mohammad Naz
         */

        if(e.getSource()==opentrans){
            JFileChooser Fa=new JFileChooser();
            Fa.showOpenDialog(null);
            if(returnVal==JFileChooser.APPROVE_OPTION){
                String name;
                float price;



                //File listOfPurchases = Fa.getSelectedFile();

                try {

                    // Creates a File object that allows you to work with files on the hardrive.

                    BufferedReader getInfo = new BufferedReader(
                            new FileReader(Fa.getSelectedFile()));

                    // FileWriter is used to write streams of characters to a file
                    // BufferedReader reads as many characters as possible
                    // them all at one time (Speeds up the Program)

                    String Info = getInfo.readLine();

                    // Reads a whole line from the file and saves it in a String


                    while (Info != null) {
                        String[] item = Info.split(",");
                        // Splits the line into different indexes
                        //String name
                        try {
                            name = object.getName(item[0]);
                            // get the name of item from the database
                            if (name == null) {
                                 throw new ItemNotFoundException(item[0]);
                            }
                            price = object.getPrice(item[0]);
                        } catch (ItemNotFoundException f) {
                            f.getname2();
                            f.getmissingitemprice();
                            name=f.getName3();
                            price = f.getPrice2();
                        }
                        float weight = Float.parseFloat(item[1]);
                        //convert String into a float
                        sum=price*weight;
                        total+=price*weight;
                        output[count++]=((name)+"\t"+(myFormatter.format(price))+"\t"+myFormatter.format(sum));


                        Info = getInfo.readLine();
                    }


                }

                // catch this when you call FileWriter
                catch (FileNotFoundException F) {

                    System.out.println("Couldn't Find the File");
                    //closes the program
                    System.exit(0);


                    // catch this when you call FileWriter
                } catch (IOException F) {

                    System.out.println("An I/O Error Occurred");
                    System.exit(0);

                    // catch this when you call FileWriter

                } catch (NumberFormatException F) {
                    System.out.println("Error in input. Line ignored:");

                }
                  //catch (ItemNotFoundException exception){
                     // JOptionPane.showMessageDialog(null, "enter price");
                 // }

                String grandtotal=myFormatter.format(total);

                Main receipt = new Main(output, count, grandtotal);
                //send data to the GUI to create a receipt*/
            }

        }
        /**
         * initializes database, however doessn't work because when i used Method that is commented out to send the file
         * to Database and to fill the linkedlist, it comes out emtpy. the only possible way i got it to work was have the
         * Database initilized in the start of the program at line 99 that automaticly fills the linkedList. in my email i explained more
         * with a video etc.
         *
         */

        else if(e.getSource()==openDatabase) {
            JFileChooser db = new JFileChooser();
            db.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File database= db.getSelectedFile();

                //object.fatabase(database);
            }
        }


        /**
         *
         * displays fruit
         */

        if(e.getSource()==displayfruits){
           object.gettType("F");

             Main r=new Main(object.fruit,object.count2);

        }
        /**
         * displayed veg
         */


        if(e.getSource()==displayvegs){
            object.gettType("V");
            Main v=new Main(object.veg,object.count3);
            //notify();
        }

        /**
         * quits the Frame
         *
         *
         */
        else if (e.getSource()==quit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Main();


    }
}

