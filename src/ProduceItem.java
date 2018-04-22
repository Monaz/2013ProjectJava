
public abstract class ProduceItem {
    public String code;
    public String name;
    public float price;
    public String type;


    /**
     * Constructs and initialized when ProduceItem is being built.
     *@param code code from produceitem.txt
     * @param name name from produceitem.txt
     * @param price price from produceitem.txt
     *
     */



    public ProduceItem(String type, String code, String name, float price) {
        this.type=type;
        this.code = code;
        this.name = name;
        this.price = price;
    }
    //constructor that is called in Database

    /**
     * getter method that returns name
     * @return name
     */

    protected String getname() {
        return name;
    }
    //returns name

    /**
     * getter method that returns price
     * @return price
     */
    public float getprice() {
        return price;
    }
    //getsprice

    /**
     * getter method that returns code
     * @return code
     */
    public String getcode() {
        return code;
        //gets code;
    }
    public String gettype(){
        return type;
    }

    /**
     * setter method that sets code
     */
    public void setCode(String code){
        this.code=code;
    }
    //setter for code

    /**
     * setter method that sets name
     */
    public void setName(String name) {
        this.name=name;
    }
    //setters for method

    /**
     * setter methord that sets price
     */
    public void setPrice(float price) {
        this.price=price;
    }
    //setter for void

}
