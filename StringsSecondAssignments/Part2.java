
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int counter = 0;
        System.out.println("The parameters passed are " + stringa + " and " + stringb);
        int contained = stringb.indexOf(stringa);
        while (contained != -1) {
            counter++;
            stringb = stringb.substring(contained + stringa.length());
            contained = stringb.indexOf(stringa);
        }
        //System.out.println("No of occurence of " + stringa + " is : " + counter);
        //System.out.println(stringb);
        return counter;
    
    }
    public void testHowMany(){
       String stringa = ("aa");
       String stringb = ("yesaanoaayesaaaosa");
       int result = howMany(stringa, stringb);
       System.out.println ("No of occurence of " + stringa + " is : " + result);
       stringa = ("ab");
       stringb = ("yesaanoaayesaanosa");
       result = howMany(stringa, stringb);
       System.out.println ("No of occurence of " + stringa + " is : " + result);
       stringa = ("aa");
       stringb = ("yesaanoaanosa");
       result = howMany(stringa, stringb);
       System.out.println ("No of occurence of " + stringa + " is : " + result);
    }
}
