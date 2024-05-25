package interview.programs;

public class removeWhitespaces {
    public static void main(String[] args) {
        String str = "anil shetty trasi";
        String removed = removeWhitespacesFromStringInBuilt(str);
        System.out.println(removed);
        String logical = removeWhiteSpaceAgain(str);
    }

    private static String removeWhiteSpaceAgain(String str) {
        return null;
    }

    private static String removeWhitespacesFromStringInBuilt(String str) {

        return str.replaceAll("\\s+", "");
    }

}
