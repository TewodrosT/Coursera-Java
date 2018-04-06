
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences (String stringa, String stringb){
        int counter = 0;
        System.out.println("The parameters passed are " + stringa + " and " + stringb);
        int contained = stringb.indexOf(stringa);
        while (contained != -1) {
            counter++;
            stringb = stringb.substring(contained + 1);
            contained = stringb.indexOf(stringa);
        }
        System.out.println("No of occurence of " + stringa + " is : " + counter);
        //System.out.println(stringb);
        if (counter>1){
        return true;
         }
        return false;
    
    }
    
    public String lastPart(String stringa, String stringb){
       System.out.println("The parameters passed are " + stringa + " and " + stringb);
       String result = "";
       int index = stringb.indexOf(stringa);
       if (index != -1){
           result = stringb.substring(index + stringa.length());
           return result;
        }
        result = stringb;
        return result;
    }
    public void testOccurrences(){
       String stringa = ("aa");
       String stringb = ("yesaanoaayesaanosa");
       boolean result = twoOccurrences(stringa, stringb);
       System.out.println (result);
       stringa = ("ab");
       stringb = ("yesaanoaayesaanosa");
       result = twoOccurrences(stringa, stringb);
       System.out.println (result);
       stringa = ("aa");
       stringb = ("yesaanoaanosa");
       result = twoOccurrences(stringa, stringb);
       System.out.println (result);
       
       stringa = ("an");
       stringb = ("banana");
       String result2 = lastPart (stringa, stringb);
       System.out.println ("The part of the string after " + stringa + " in " + stringb + " is: " + result2);
       stringa = ("Zoo");
       stringb = ("Forest");
       result2 = lastPart(stringa, stringb);
       System.out.println ("The part of the string after " + stringa + " in " + stringb + " is: " + result2);
       stringa = ("david");
       stringb = ("davidson");
       result2 = lastPart(stringa, stringb);
       System.out.println ("The part of the string after " + stringa + " in " + stringb + " is: " + result2);
       
       
    }

}
