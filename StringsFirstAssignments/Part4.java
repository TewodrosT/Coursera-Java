import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public static void main(String[] args){
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for(String s:ur.words()){
     // print or process s
     String sLower = s.toLowerCase();
     int checkIndex = sLower.indexOf("youtube.com");
     if (checkIndex !=-1){
        int startQuoteIndex = s.indexOf("\""); //i did not use the last index of option. 
        //I looked for the first occurence of the quotaton and had it as the beginning
        
        int stopQuoteIndex = s.indexOf("\"", startQuoteIndex + 1); //the search for the quotation after the first quotation, 
        //which is the last quotation
        String result = s.substring(startQuoteIndex, stopQuoteIndex+1); //output includes the first and last quotation,
        //we can also exclude it by changing result = s.substring(startQuoteIndex-1, stopQuoteIndex);
        System.out.println(result);
        }
     
 }
 
}
    
}
