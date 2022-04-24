import java.util.Arrays;

public class Row {

    private String name;
    private String[] subset;

    public Row(String name, String[] subset){
        this.name = name;
        this.subset = subset;
    }

    public Row(){
        this(null,null);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String[] getSubset(){
        return this.subset;
    }

    public void setSubset(String[] subset){
        this.subset = subset;
    }

    public void addSubset(String newSubset){
        boolean flag = true;
        for (int i = 0; i < subset.length; i++) {
            if(this.subset[i].equalsIgnoreCase(newSubset)){
                flag = false;
            }
        }
        if(flag){
            this.subset = Arrays.copyOfRange(this.subset, 0, this.subset.length+1);
            this.subset[this.subset.length-1] = newSubset;

        }else{
            System.out.println("already has this subset");
        }
    }

    public void removeSubset(String rmSubset){
        for (int i = 0; i < subset.length; i++) {
            if(this.subset[i].equalsIgnoreCase(rmSubset)){
                this.subset[i] = null;
            }
        }
    }

    public boolean equal(String name){
        return this.name.equalsIgnoreCase(name);
    }

    public boolean include(String subset){
        //if subset include by this subset
        for (int i = 0; i < this.subset.length; i++) {
            if(this.subset[i].equalsIgnoreCase(subset)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String output = name + " -> ";
        for (int i = 0; i < this.subset.length; i++) {
            if(!this.subset[i].equals(null)){
                output = output + this.subset[i] + " | ";

            }
        }
        return output;
    }


}
