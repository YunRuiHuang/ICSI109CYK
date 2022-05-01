import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Yunrui Huang
 * this class use to process the CYK algorithm
 */

public class CYKAlgorithm {

    private Table table;
    private ArrayList<Row> rows;

    /**
     * the constructor of the CYKAlgorithm
     * It will first read the test.txt file to get the CFG
     */
    public CYKAlgorithm(){
        //read file
        this.rows = new ArrayList<>();
        readFile("test.txt");

        System.out.println("the testing CFG has read from test.txt file\nthe CFG is :");
        System.out.println(this.toString());

        //loop scanner and analyze
            //$ as command
            //word as word
            //$quit as leave
        while (true){
            String str;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a String for test: (type quit to left)");
            str = scanner.nextLine();
            if(str.equalsIgnoreCase("quit")){
                break;
            }else{
                analyzeWord(str);
                this.table = null;
            }


        }

    }

    /**
     * analyze the input sting to check is it accept by the CFG
     * @param input
     * the String of input by user
     */
    public void analyzeWord(String input){
        //analyze input word
            //build table
            //input char one by one
            //iterate table
            //print table and result
        int size = input.length();
        this.table = new Table(size);
        for (int i = 0; i < size; i++) {
            ArrayList<String> elements = new ArrayList<>();
            for (int j = 0; j < this.rows.size(); j++) {

                if(this.rows.get(j).include(input.substring(i,i+1))){
                    elements.add(this.rows.get(j).getName());
                }

            }
            if(!elements.isEmpty()){
                this.table.setElement(new Element(i,i,elements));
            }
        }

        for (int i = 1; i < size; i++) {
            for(int x = i; x < size; x++){
                ArrayList<String> elements = new ArrayList<>();
                int y = x - i;

                for (int j = 0; j < i; j++) {
                    ArrayList<String> list = new ArrayList<>();
                    ArrayList<String> left = this.table.getElement(y+j,y);
                    ArrayList<String> top = this.table.getElement(x,y+1+j);
                    list = switching(combine(left,top));
                    if(list!= null){
                        for (int k = 0; k < list.size(); k++) {
                            elements.add(list.get(k));
                        }
                    }

                }

                this.table.setElement(new Element(x,y,elements));
            }
        }

        System.out.println(this.table.toString());
    }

    /**
     * concat two list of string
     * @param left
     * the left string to concat, which will be the forward part
     * @param top
     * the top string to concat, which will be the back part
     * @return
     * the string list after concat
     */
    public ArrayList<String> combine(ArrayList<String> left, ArrayList<String> top){
        if(left == null || top == null){
            return null;
        }
        ArrayList<String> combineList = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < top.size(); j++) {
                combineList.add(left.get(i)+top.get(j));
            }
        }
        return combineList;
    }

    /**
     * switch the string to name of row, such as XaZ1 will switch to S
     * @param list
     * the array list of the string for switch
     * @return
     * the string list after switch
     */
    public ArrayList<String> switching(ArrayList<String> list){
        if (list==null){
            return null;
        }
        ArrayList<String> elements = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < this.rows.size(); j++) {
                if(this.rows.get(j).include(list.get(i))){
                    elements.add(this.rows.get(j).getName());
                }
            }
        }
        return elements;
    }

//    public void analyzeCommand(String input){
        //analyze input language

        //read file

        //add/remove row

        //add/remove subset of row

        //print all row


//    }

    /**
     * the method use to read the file and split each CFG row
     * @param fileName
     * the name of file has CFG info
     */
    public void readFile(String fileName){
        String str = "";
        try{
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);
            str = bufferedReader.readLine();
        }catch(IOException e){
            System.out.println("File Not found");
        }
        str = str.replace(" ","");
        System.out.println(str);

        String[] split = str.split(",");

        for (int i = 0; i < split.length; i++) {
            String[] rowSting = split[i].split("->");
            addRow(rowSting[0],rowSting[1].split("\\|"));

//            System.out.println(rowSting[0] + rowSting[1].split("\\|")[rowSting[1].split("\\|").length-1]);
        }

    }

    /**
     * to add the new CFG row to the Array list
     * @param name
     * the name (or head)of CFG row, such as S, Xa, Xb
     * @param subset
     * the subset (or content) of CFG row, such XaS, TXb
     */
    public void addRow(String name, String[] subset){
        ArrayList<String> input = new ArrayList<>();
        for (int i = 0; i < subset.length; i++) {
            input.add(subset[i]);
        }
        this.rows.add(new Row(name,input));
    }


    @Override
    /**
     * override the toString method to print the CFG
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < this.rows.size(); i++) {
            output = output + this.rows.get(i).toString() + "\n";
        }
        return output;
    }
}
