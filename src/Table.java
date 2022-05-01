import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Yunrui Huang
 * this class use to hold the table of input string
 */
public class Table {

    private ArrayList<Element> table;
    private int size;

    /**
     * the constructor of Table class
     * @param size
     * the size of x-axis (or y-axis) of this table
     */
    public Table(int size){
        this.table = new ArrayList<Element>();
        this.size = size;
    }


    /**
     * get the element of given (x, y) address
     * @param x
     * the address on x-axis
     * @param y
     * the address on y-axis
     * @return
     * the string list on this address
     */
    public ArrayList<String> getElement(int x, int y){
        for (int i = 0; i < this.table.size(); i++) {
            if(this.table.get(i).getX() == x && this.table.get(i).getY() == y){
                return this.table.get(i).getElements();
            }
        }
        return null;
    }

    /**
     * get the element of given (x, y) address
     * @param x
     * the address on x-axis
     * @param y
     * the address on y-axis
     * @return
     * the element on this address
     */
    public Element getElements(int x, int y){
        for (int i = 0; i < this.table.size(); i++) {
            if(this.table.get(i).getX() == x && this.table.get(i).getY() == y){
                return this.table.get(i);
            }
        }
        return null;
    }

    /**
     * set a new element
     * @param elements
     * the element to set
     */
    public void setElement(Element elements){
        if(this.getElement(elements.getX(),elements.getY())==null){
//            Element newElements = new Element();
            this.table.add(elements);
        }else{
            System.out.println("already have element in this place (x = " + elements.getX() + " y = " + elements.getY() + ")");
        }

        //new element
    }


    /**
     * combine two element to get a new arraylist of string
     * @param ax
     * the x-axis address of left element
     * @param ay
     * the y-axis address of left element
     * @param bx
     * the x-axis address of top element
     * @param by
     * the y-axis address of top element
     * @return
     * the string arraylist after combine
     */
    public ArrayList<String> combine(int ax, int ay, int bx, int by){
        ArrayList<String> elementsA = this.getElement(ax,ay);
        ArrayList<String> elementsB = this.getElement(bx,by);
        if(elementsA.size() == 0 || elementsB.size() == 0){
            return null;
        }else{
            ArrayList<String> output = new ArrayList<>();
            for (int i = 0; i < elementsA.size(); i++) {
                for (int j = 0; j < elementsB.size(); j++) {

                    output.add(elementsA.get(i) + elementsB.get(j));

                }

            }
            return output;
        }




    }


    @Override
    /**
     * override the toString to print the table
     */
    public String toString() {
        String output = "";
        for (int i = size - 1; i > -1 ; i--) {
            for (int j = 0; j < size; j++) {
                if(this.getElement(j,i) == null){
                    output = output + "[    ] ";
                }else{
                    output = output +"[" + this.getElements(j,i).toString() + "] ";
                }

            }



            output = output + "\n";

        }
        if(this.getElements(size-1,0) != null && !this.getElements(size-1,0).toString().equalsIgnoreCase("")){
            output = output + "\nthis string is accept\n";
//            System.out.println(this.getElements(size-1,0).toString());
        }else{
            output = output + "\nthis string isn't accept\n";
        }
        return output;
    }
}
