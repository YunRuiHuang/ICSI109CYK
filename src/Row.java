import java.util.ArrayList;
import java.util.Arrays;

public class Row {

    private String name;
    private ArrayList<String> subset;

    public Row(String name, ArrayList<String> subset){
        this.name = name;
        this.subset = subset;
    }

    public Row(){
        this(null,new ArrayList<String>());
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<String> getSubset(){
        return this.subset;
    }

    public void setSubset(ArrayList<String> subset){
        this.subset = subset;
    }

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

    public boolean equal(String name){
        return this.name.equalsIgnoreCase(name);
    }

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
    public String toString() {
        String output = name + " -> ";
        for (int i = 0; i < this.subset.size(); i++) {
            output = output + this.subset.get(i) + " | ";
        }
        return output;
    }


}
