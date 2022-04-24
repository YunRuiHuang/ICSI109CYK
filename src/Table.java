import java.util.Arrays;

public class Table {

    private Element[] table;
    private int size;

    public Table(int size){
        int length = size * (size + 1) / 2;
        this.table = new Element[length];
        this.size = size;
    }

    public String[] getElement(int x, int y){
        for (int i = 0; i < this.table.length; i++) {
            if(this.table[i].getX() == x && this.table[i].getY() == y){
                return this.table[i].getElements();
            }
        }
        return null;
    }

    public Element getElements(int x, int y){
        for (int i = 0; i < this.table.length; i++) {
            if(this.table[i].getX() == x && this.table[i].getY() == y){
                return this.table[i];
            }
        }
        return null;
    }

    public void setElement(Element elements){
        if(this.getElement(elements.getX(),elements.getY()).equals(null)){
            for (int i = 0; i < this.table.length; i++) {
                if(this.table[i].equals(null)){
                    this.table[i] = elements;
                    break;
                }
            }
        }else{
            System.out.println("already have element in this place (x = " + elements.getX() + " y = " + elements.getY() + ")");
        }

        //new element
    }

    public String[] combine(int ax, int ay, int bx, int by){
        String[] elementsA = this.getElement(ax,ay);
        String[] elementsB = this.getElement(bx,by);
        if(elementsA.length == 0 || elementsB.length == 0){
            return null;
        }else{
            String[] output = new String[elementsA.length*elementsB.length];
            int adds = 0;
            for (int i = 0; i < elementsA.length; i++) {
                for (int j = 0; j < elementsB.length; j++) {

                    output[adds] = elementsA[i] + elementsB[j];
                    adds++;
                }

            }
            return output;
        }




    }


    @Override
    public String toString() {
        String output = "";
        for (int i = size - 1; i > -1 ; i--) {
            for (int j = 0; j < size; j++) {
                if(this.getElement(j,i).equals(null)){
                    output = output + "\t| ";
                }else{
                    output = output + this.getElements(j,i).toString() + " | ";
                }

            }

            output = output + "\n";

        }
        return output;
    }
}
