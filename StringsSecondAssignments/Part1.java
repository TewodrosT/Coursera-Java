
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
        int diff = currIndex - startIndex;
        if (diff % 3 == 0){
            return currIndex;
        }
        else {
            currIndex = dna.indexOf(stopCodon, currIndex+1);
        }
        }
        return -1;
    }
    public String findGene (String dna, int where){
        
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon (dna, startIndex, "TAA");
        int tagIndex = findStopCodon (dna, startIndex, "TAG");
        int tgaIndex = findStopCodon (dna, startIndex, "TGA");
        //int tmp = Math.min (taaIndex, tagIndex);
        int minIndex = 0;
        //int minIndex = Math.min (tmp, tgaIndex);
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if (minIndex == -1){
            return "";
        }
        return dna.substring (startIndex, minIndex + 3);
    }
    public void printAllGenes(String dna){
        int startIndex = 0;
        System.out.println ("The dna strand under review is " + dna);
        while (true){
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()){
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }
     
    public void testStopCodon(){
        String dna = "ATGTACTAA";
        System.out.println ("The DNA string is " + dna);
        int startIndex = dna.indexOf("ATG");
        int geneIndex = findStopCodon(dna, startIndex,"TAA");
        String gene = dna.substring (startIndex, geneIndex + 3);
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACTAG";
        System.out.println ("The DNA string is " + dna);
        geneIndex = findStopCodon (dna, startIndex, "TAG");    
        gene = dna.substring (startIndex, geneIndex + 3);
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACGTAGTAA";
        System.out.println ("The DNA string is " + dna);
        geneIndex = findStopCodon(dna, startIndex, "GTA");
        gene = dna.substring (startIndex, geneIndex + 3);
        System.out.println ("The gene is " + gene);
    
        dna = "tatgaacttag";
        System.out.println ("The DNA string is " + dna);
        geneIndex = findStopCodon(dna, startIndex, "TAA");  
        gene = dna.substring (startIndex, geneIndex + 3);
        gene = gene.toLowerCase();
        System.out.println ("The gene is " + gene);
    
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println ("The DNA string is " + dna);
        geneIndex = findStopCodon(dna, startIndex, "TAA");
        gene = dna.substring (startIndex, geneIndex + 3);
        System.out.println ("The gene is " + gene);
    }
    public void testFindGene() {
        String dna = "ACGTACTAA";
        System.out.println ("The DNA string is " + dna);
        String gene = findGene(dna, 0);
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACTAG";
        System.out.println ("The DNA string is " + dna);
        gene = findGene(dna, 0);    
        System.out.println ("The gene is " + gene);
    
        dna = "ATGTACGTATGAT";
        System.out.println ("The DNA string is " + dna);
        gene = findGene(dna, 0);
        System.out.println ("The gene is " + gene);
    
        dna = "tatgtactag";
        dna.toUpperCase();
        System.out.println ("The DNA string is " + dna);
        gene = findGene(dna, 0);  
        gene = gene.toLowerCase();
        System.out.println ("The gene is " + gene);
    
        dna = "AAATGCCCTAACTATGTTAAGATGAAACC";
        System.out.println ("The DNA string is " + dna);
        gene = findGene(dna, 0);
        System.out.println ("The gene is " + gene);
    }
    public void testPrintAllGenes(){
        String dna = "AAATGCCCTAACTATGTTAAGATGAAACC";
        printAllGenes(dna);
        
        dna = "";
        printAllGenes(dna);
        
        dna = "AAATGCCCTAACTATGTTAAGATGAAACCATGCCCCCCCCCTAG";
        printAllGenes(dna);
    }
}
