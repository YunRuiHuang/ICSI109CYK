import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Yunrui Huang
 * this class use to hold one row of CFG
 */

public class Row {

    private String name;
    private ArrayList<String> subset;

    /**
     * the constructor of Row
     * @param name
     * the name (or head) of a row of CFG
     * @param subset
     * the subset (or content) of a row of CFG
     */
    public Row(String name, ArrayList<String> subset){
        this.name = name;
        this.subset = subset;
    }

    /**
     * the constructor of Row without input
     */
    public Row(){
        this(null,new ArrayList<String>());
    }

    /**
     * get the name of a row
     * @return
     * the name of this row
     */
    public String getName(){
        return this.name;
    }

    /**
     * set the name of this row
     * @param name
     * the name to set for this row
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * get the subset of this row
     * @return
     * the subset of this row
     */
    public ArrayList<String> getSubset(){
        return this.subset;
    }

    /**
     * set the subset of this row
     * @param subset
     * the subset of thi row
     */
    public void setSubset(ArrayList<String> subset){
        this.subset = subset;
    }

    /**
     * add a new subset for this row
     * @param newSubset
     * the new subset for this row
     */
    public void addSubset(String newSubset){
        boolean flag = true;
        for (int i = 0; i < this.subset.size(); i++) {
            if(this.subset.get(i).equals(newSubset)){
                flag = false;
            }
        }
        if(flag){
            this.subset.add(newSubset);
        }else{
            System.out.println("already has this subset");
        }
    }

    /**
     * check if this input string is equal the name of this row
     * @param name
     * the input name use to check
     * @return
     * true if same
     */
    public boolean equal(String name){
        return this.name.equalsIgnoreCase(name);
    }

    /**
     * check id this input is a part of subset of this row
     * @param subset
     * the string use to check
     * @return
     * true if include
     */
    public boolean include(String subset){
        //if subset include by this subset
        for (int i = 0; i < this.subset.size(); i++) {
            if(this.subset.get(i).equals(subset)){
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * override the toString to print this row
     */
    public String toString() {
        String output = name + " -> ";
        for (int i = 0; i < this.subset.size(); i++) {
            output = output + this.subset.get(i) + " | ";
        }
        return output;
    }


}
