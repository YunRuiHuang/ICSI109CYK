public class Driver {
    public static void main(String[] args){
        Row row = new Row();
        row.setName("S");
        row.addSubset("AS");
        row.addSubset("BS");
        row.addSubset("cS");

        System.out.println(row.toString());
        System.out.println("is AS include " + row.include("AS"));
        System.out.println("is CS include " + row.include("CS"));
    }
}
