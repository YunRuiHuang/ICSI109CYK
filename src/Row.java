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

    }

    public void removeSubset(String rmSubset){

    }

    public boolean equal(String name){
        return this.name.equalsIgnoreCase(name);
    }

    public boolean include(String subset){
        //if subset include by this subset

        return true;
    }

    @Override
    public String toString() {
        return "";
    }


}
