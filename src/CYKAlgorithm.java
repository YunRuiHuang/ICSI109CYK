import java.util.Arrays;
import java.util.Scanner;

public class CYKAlgorithm {

    private Table table;
    private Row[] rows;

    public CYKAlgorithm(){
        //read file

        //loop scanner and analyze
            //$ as command
            //word as word
            //$quit as leave
        while(true){
            String input = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Command start with $, word start with nothing, please type in:");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("$quit")){
                System.out.println("quit now!");
                break;
            }
            if(input.substring(0,1).equalsIgnoreCase("$")){
                analyzeCommand(input.substring(1));
            }else{
                analyzeWord(input);
            }
        }

    }

    public void analyzeWord(String input){
        //analyze input word
            //build table
            //input char one by one
            //iterate table
            //print table and result
    }

    public void analyzeCommand(String input){
        //analyze input language

        //read file

        //add/remove row

        //add/remove subset of row

        //print all row
        String[] split = input.split("\\s+");
        if(split[0].equalsIgnoreCase("read")){
            this.readFile(split[1]);
        }else if(split[0].equalsIgnoreCase("addrow")){
            this.addRow(split[1],split[3].split("\\|"));
        }else if(split[0].equalsIgnoreCase("removerow")){
            this.removeRow(split[1]);
        }else if(split[0].equalsIgnoreCase("addsubset")){
            this.addSubset(split[1],split[3].split("\\|"));
        }else if(split[0].equalsIgnoreCase("removesubset")){
            this.removeSubset(split[1],split[3].split("\\|"));
        }else if(split[0].equalsIgnoreCase("print")){
            System.out.println(this.toString());
        }else{
            System.out.println("no such command!");
        }

    }

    public void readFile(String fileName){

    }

    public void addRow(String name, String[] subset){

    }

    public void removeRow(String name){

    }

    public void addSubset(String name, String[] subset){

    }

    public void removeSubset(String name, String[] subset){

    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.rows.length; i++) {
            output = output + this.rows[i].toString() + "\n";
        }
        return output;
    }
}
