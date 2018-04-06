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
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource ();
        int startIndex = 0;
        System.out.println ("The dna strand under review is " + dna);
        while (true){
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()){
                break;
            }
            geneList.add(currGene);
            //System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        
        return geneList;
    }
    public void processGenes(StorageResource sr){
        int counterLength = 0;
        int counterCg = 0;
        int maxGeneLength = 0;
        //StorageResource sr = new StorageResource (); // needs correction ????
        //geneList = sr;
        //FileResource fr = new FileResource("brca1line.fa");
        //String dna = fr.asString();
        //sr = getAllGenes(dna);
        System.out.println(sr.size());
        for (String s: sr.data()){
            System.out.println (s);
            
            if (s.length() >60){
                counterLength++;
                //System.out.println(s);
            }
            
            float ratio = cgRatio(s);
            
            if (ratio > 0.35){
                //System.out.println( s + " has a cg ratio of greater than 0.35");
                counterCg++;
            }
            
            if (s.length() > maxGeneLength){
                maxGeneLength = s.length();
            } else {
                maxGeneLength = maxGeneLength;
            }
        }
        System.out.println ("The number of strings whose length is >60 is: " + counterLength);
        System.out.println ("The number of strings whose cg ration is >0.35 is: " + counterCg);
        for (String s: sr.data()){
            if (s.length() == maxGeneLength){
            System.out.println ("The longest gene is:  " + s + "the length is " + maxGeneLength);
            }
        }
        
    }
    public void testProcessGenes(){
        StorageResource sr = new StorageResource ();
        //FileResource fr = new FileResource("brca1line.fa");
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        String dna2 = dna.toUpperCase();
        sr = getAllGenes(dna2);
        /*for(String s:sr.data()){
            System.out.println("genes are " + s);
        }*/
        processGenes(sr);
        int result = countCTG(dna2);
        System.out.println(result);
        //???????
    }
    public float cgRatio(String dna){
        int count=0;
        //char char1 = 'C';
        
        for (char x : dna.toCharArray()){
            if (x== 'C' || x == 'G'){
                count++;
            }
        }
        return (float)count/dna.length();
    }
    public int countCTG(String dna){
        int counter = 0;
        String stringa = "CTG";
        System.out.println("The parameters passed are " + stringa + " and " + dna);
        int contained = dna.indexOf(stringa);
        while (contained != -1) {
            counter++;
            dna = dna.substring(contained + stringa.length());
            contained = dna.indexOf(stringa);
        }
        //System.out.println("No of occurence of " + stringa + " is : " + counter);
        //System.out.println(stringb);
        return counter;
    }
    public void testCountCTG(){
        String dna = "ATGCTGCTGATGCTGATGCTG";
        int result = countCTG(dna);
        System.out.println(result);
    }
    public void testCgRatio (){
        String dna = "ATGCCATAG";
        float result = cgRatio (dna);
        System.out.println(result);
    }
    public void testGetAllGenes(){
        String dna = "AAATGCCCTAACTATGTTAAGATGAAACC";
        System.out.println ("testing getAllGenes on" + dna);
        StorageResource genes = getAllGenes(dna);
        for(String g:genes.data()){
            System.out.println(g);
        }
        dna = "";
        System.out.println ("testing getAllGenes on" + dna);
        genes = getAllGenes(dna);
        for(String g:genes.data()){
            System.out.println(g);
        }
        dna = "AAATGCCCTAACTATGTTAAGATGAAACCATGCCCCCCCCCTAG";
        System.out.println ("testing getAllGenes on" + dna);
        genes = getAllGenes(dna);
        for(String g:genes.data()){
            System.out.println(g);
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
