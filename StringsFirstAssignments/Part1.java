
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

   public String  findSimpleGene (String dna){
    String result = "";
    int startIndex = dna.indexOf("ATG");
        if (startIndex == -1)
        {
            return "No ATG";
        }
    int stopIndex = dna.indexOf("TAA", startIndex + 3);
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
    String gene = findSimpleGene(dna);
    System.out.println ("The gene in the DNA string is " + gene);
    
    dna = "ATGTACTAG";
    System.out.println ("The DNA string is " + dna);
    gene = findSimpleGene(dna);    
    System.out.println ("The gene in the DNA string is " + gene);
    
    dna = "ATGTACGTACTAA";
    System.out.println ("The DNA string is " + dna);
    gene = findSimpleGene(dna);
    System.out.println ("The gene in the DNA string is " + gene);
    
    dna = "ATGTACTAA";
    System.out.println ("The DNA string is" + dna);
    gene = findSimpleGene(dna);    
    System.out.println ("The gene in the DNA string is " + gene);
    
    dna = "ACGTACTAG";
    System.out.println ("The DNA string is " + dna);
    gene = findSimpleGene(dna);
    System.out.println ("The gene in the DNA string is " + gene);
    
    }
}
