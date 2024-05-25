package interview.programs;

public class ReverseStringRecursive {
    public static void main(String[] args) {
        String string = "anilshetty";
        System.out.println(string.substring(1,4));
        String rev = recursiveReverse(string);
        System.out.println(rev);
    }

    public static String recursiveReverse(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }
         return recursiveReverse(str.substring(1)) + str.charAt(0);
    }
}
