import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class Producelist {
    public node first;


    /**
     * Default constructor
     */
    public Producelist() {
        first = new node();
    }//default constructor

    /**
     * Creates a new LinkedList with a dummy node and
     * another node with the input data.
     *
     * @param data, an integer
     */
    public Producelist(ProduceItem data) {
        first = new node();
        first.setNext(new node(data));
    }//one argument constructor

    /**
     * Creates a new node at the end of the Linked List.
     *
     * @param data, an integer
     */
    public void append(ProduceItem data) {
        node current = first;
        while (current.getNext() != null)
            current = current.getNext();
        current.setNext(new node(data));
    }//append

    /**
     * Creates a new node at the beginning of the Linked List.
     *
     * @param data, an integer
     */
    public void prepend(ProduceItem data) {
        first.setNext(new node(data, first.getNext()));
    }//prepend

    /**
     * Prints the Linked List to the console.
     */
    public void printList() {
        node current = first.getNext();
        while (current != null) {
            System.out.print(current.getName() + " ");
            current = current.getNext();
        }//while
        System.out.println();
    }

    /**
     * getName accepts a String Parameter called code, which is used to check the ProduceList which is the LinkedList
     * checks each node and returns a name.
     *
     * @param code code coordinate from transaction.txt
     * @return Name back to Main to output array
     */


    public String getName(String code) {

        node current = first.getNext();
        String name = null;
        while (current != null) {
            if (current.getCode().equals(code)) {

                name = current.getName();
                name= current.getData().getname();
            }
            current = current.getNext();

        }

        return name;
    }

    /**
     * getPrice accepts a String Parameter called code, which is used to check the ProduceList which is the LinkedList
     * checks each node and returns a price.
     *
     * @param code code coordinate from transaction.txt
     * @return price back to Main to output array
     */
    public float getPrice(String code) {
            node current = first.getNext();
            float price = 0;
            while (current != null) {
                if (current.getCode().equals(code)) {
                    price = current.getPrice();
                }
                current = current.getNext();

            }


            return price;

    }


    /**public String getType(String code) {
        node current = first.getNext();
        String type=null;
        while (current != null) {
            if (current.getCode().equals(code)) {
                type = current.getType();
            }
            current = current.getNext();

        }


        return type;
    }



        public ArrayList<String> displayfruits (){
        ArrayList<String> fruit = new ArrayList<>();
            String t="F";
        node current = first.getNext();
        while (current != null) {
            if (current.getType().equals(t)) {
                String str =  current.getType()+"\t"+current.getName()+"\t" + current.getPrice();
                fruit.add(str);

            }
            current.getNext();
        }
            return fruit;


    }

    public ArrayList<String> displayveg(){

        ArrayList<String> veg = new ArrayList<>();
        String t="V";
        node current = first.getNext();
        while (current != null) {
            if (current.getType().equals(t)) {
                String str =  current.getType()+"\t"+current.getName()+"\t" + current.getPrice();
                veg.add(str);

            }
            current.getNext();
        }
        return veg;


    }*/
    }









//class



















































