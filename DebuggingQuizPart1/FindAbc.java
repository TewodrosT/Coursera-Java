
/**
 * Write a description of FindAbc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindAbc {
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3) {
            break;
        }
        int newIndex1 = index;
        int newIndex2 = index+4;
        System.out.println (newIndex1);
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        
        index = input.indexOf("abc", index+3);
        System.out.println("index after updating " + index);
    }
}
   public void test() {
    //no code yet
    //findAbc ("abcd");
    //findAbc("abcdabc");
    //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    findAbc("abcabcabcabca");
}
}
