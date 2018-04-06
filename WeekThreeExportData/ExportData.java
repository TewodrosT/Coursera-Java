
/**
 * Write a description of ExportData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ExportData {
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record:parser){
            String countries = record.get("Country");
            if (countries.contains(country)){
                String countryName = record.get("Country");
                String countryExports = record.get("Exports");
                String countryValue = record.get("Value (dollars)");
                return countryName + ": " + countryExports + ": " + countryValue;
            }
            else
                return "No Country";
        }
        return "";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
            //prints the names of all countries that have both exportitem1 and exportitem2. 
            //with exports_small.csv file with items "gold" and "diamonds", this method should print Namibia and South Africa
            for (CSVRecord record:parser){
                String exportItems= record.get("Exports");
                if (exportItems.contains(exportitem1) && exportItems.contains(exportitem2)){
                    String bothExpCountry = record.get("Country");
                    System.out.println(bothExpCountry);
                }
            }
    }
    //Write a method named numberOfExporters, which has two parameters, parser is a CSVParser, and exportItem is a String. 
    //This method returns the number of countries that export exportItem. 
    //For example, using the file exports_small.csv, this method called with the item “gold” would return 3.
    public int numberOfExporters (CSVParser parser, String exportItem){
            
            int counter = 0;
            for (CSVRecord record:parser){
                String exportGood = record.get("Exports");
                if (exportGood.contains(exportItem)){
                    String countryName = record.get("Country");
                    System.out.println (countryName);
                    counter++;
                }
            }
            //System.out.println(counter);
            return counter;
    
    }
    
    public void bigExporters(CSVParser parser, String value){
        for(CSVRecord record: parser){
            String dollarValue = record.get("Value (dollars)");
            if(dollarValue.length() > value.length()){
                String countryName = record.get("Country");
                System.out.println(countryName + ":" + " " + dollarValue);
            }
        }
    }
    public void testerCountryInfo (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String result = countryInfo(parser, "Afghanistan");
        //String result = countryInfo(parser,"Germany");
        //String result = countryInfo(parser,"Germany");
        
        System.out.println (result);
    }
    public void testerTwoProducts (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "fish", "nuts");
        //String result = countryInfo(parser, "Germany");
        //System.out.println (result);
    }
    
    public void testerCount (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int exportItemCount = numberOfExporters (parser, "sugar");
        System.out.println("gold is exported by "+ exportItemCount + " countries");
            
    }
    public void testerValueStringSize (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        
    }
    
}
