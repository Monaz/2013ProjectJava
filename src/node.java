public class node {
    public ProduceItem data;
    public node next;



    /**Default constructor*/
    public node () {
       data = null;
       next = null;
    }
    /**
     * One argument constructor.
     * @param data, a object
     */
    public node (ProduceItem data) {
        this.data = data;
        next = null;
    }
    /**
     * Two argument constructor that sets data and next.
     * @param data, a object
     * @param next, the next node
     */

    public node (ProduceItem data, node next) {
        this.data = data;
        this.next = next;
    }
    /**
     * Gets the next node.
     * @return the next Node
     */



    public node getNext(){return next;}
    /**
     * Sets the next node.
     * @param n, the next Node
     */
    public void setNext (node n) { next = n; }

    /**
     *getter method that gets data using the data from the ProduceList by using the the getter method getname();
     * from the ProduceItem.java
     * @return name
     */
    public String getName(){
        return data.getname();

    }

    /**
     *getter method that gets data using the data from the ProduceList by using the the getter method getname();
     * from the ProduceItem.java
     * @return price
     */
    public float getPrice(){
        return data.getprice();
    }

    /**
     *getter method that gets data using the data from the ProduceList by using the the getter method getcode();
     * from the ProduceItem.java
     * @return code
     */

    public String getCode(){
        return data.getcode();
    }

    public String getType(){
        return data.gettype();
    }

    public ProduceItem getData() {
        return data;
    }
}






