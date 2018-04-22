/**
 * an exception that is thrown when an item from the transaction file isn't in the produceitem, thus resulting in an
 * exception thrown that asked for price.
 *
 *
 *
 */
import javax.swing.*;
public class ItemNotFoundException extends IllegalArgumentException{
    public String name;
    public float missingprice;
    public String missingpricecode;

    /**
     * constructor to set the missing item.
     * @param Food
     */
    public ItemNotFoundException(String Food){
        missingpricecode=Food;
    }

    /**gets price
     *
     * @return missing price
     */
    public float getPrice2(){
        return missingprice;
    }

    /**
     * gets name
     * @return name
     */
    public String getName3(){
        return name;
    }

    /**
     * sets missing price
     * @param missingprice
     */
    public void setMissingpricecode(float missingprice){
        this.missingprice=missingprice;
    }

    /**
     * sets missing name;
     * @param name
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * joption that gets the price from u and sets it
     */
    public void getmissingitemprice() {
        Float prices = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter the missing item Price:"+"\t" + missingpricecode));
        this.missingprice = prices;
    }

    /**
     * Joption to gets missing name
     */

    public void getname2() {
        String name=JOptionPane.showInputDialog(null, "Enter the missing item name" +"\t"+ missingpricecode);
        this.name=name;
    }

}