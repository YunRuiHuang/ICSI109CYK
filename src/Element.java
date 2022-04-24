import javax.annotation.Generated;
import java.util.Arrays;

public class Element {
    //element of table
    private int x;
    private int y;
    private String[] elements;

    public Element(int x, int y, String[] elements){
        this.x = x;
        this.y = y;
        this.elements = elements;
    }

    public Element(){
        this(0,0,null);
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public String[] getElements(){
        return elements;
    }

    public void setElements(String[] elements){
        this.elements = elements;
    }

    public boolean ifEmpty(){
        //return true if null
        return this.elements.equals(null);
    }

    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < this.elements.length; i++){
            output = output + this.elements[i] + ",";
        }
        return output;
    }
}
