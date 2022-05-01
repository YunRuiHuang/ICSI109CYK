import javax.annotation.Generated;
import java.util.ArrayList;

/**
 * @Author Yunrui Huang
 * this class is the element of table
 */
public class Element {
    //element of table
    private int x;
    private int y;
    private ArrayList<String> elements;

    /**
     * the constructor of Element
     * @param x
     * the address on the x-axis of this element
     * @param y
     * the address on the y-axis of this element
     * @param elements
     * the string array list on this element
     */
    public Element(int x, int y, ArrayList<String> elements){
        this.x = x;
        this.y = y;
        this.elements = elements;
    }

    /**
     * the constructor of element with not input
     */
    public Element(){
        this(0,0,null);
    }

    /**
     * get the address of x-axis of this element
     * @return
     * the address of x-axis
     */
    public int getX(){
        return x;
    }

    /**
     * set the address of x-axis of this element
     * @param x
     * the address of x-axis of this element
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * get the address of y-axis of this element
     * @return
     * the address of y-axis of this element
     */
    public int getY(){
        return y;
    }

    /**
     * set the address of y-axis of this element
     * @param y
     * the address of y-axis of this element
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * get the string arraylist of this element
     * @return
     * the string arraylist of this element
     */
    public ArrayList<String> getElements(){
        return elements;
    }

    /**
     * set the string arraylist of this element
     * @param elements
     * the string arraylist of this element
     */
    public void setElements(ArrayList<String> elements){
        this.elements = elements;
    }

    /**
     * check the arraylist is empty ot not
     * @return
     * true if arraylist empty
     */
    public boolean ifEmpty(){
        //return true if null
        return this.elements.isEmpty();
    }

    @Override
    /**
     * override the toString method to print the arraylist in this element
     */
    public String toString() {
        String output = "";
        for(int i = 0; i < this.elements.size(); i++){
            output = output + this.elements.get(i) + ",";
        }
        return output;
    }
}
