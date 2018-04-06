
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String  findSimpleGene (String dna, String startCodon, String stopCodon){
        String result = "";
        dna = dna.toUpperCase();
        int startIndex = dna.indexOf(startCodon);
            if (startIndex == -1)
            {
            return "No ATG";
            }
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
           if (stopIndex == -1)
            {
              return "No TAA";
            }
        else if ((stopIndex-startIndex)%3 == 0)
            {
              result = dna.substring(startIndex, stopIndex  +3);
              return result;
            }
        
    return "not a valid gene";
}
    public void testSimpleGene(){
        
        String dna = "ACGTACTAA";
        System.out.println ("The DNA string is " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACTAG";
        System.out.println ("The DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");    
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACGTACTAA";
        System.out.println ("The DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println ("The gene is " + gene);
    
        dna = "tatgtactaag";
        System.out.println ("The DNA string is " + dna);
       
        gene = findSimpleGene(dna, "ATG", "TAA");  
        gene = gene.toLowerCase();
        System.out.println ("The gene is " + gene);
    
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println ("The DNA string is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println ("The gene is " + gene);
    
    }
}
