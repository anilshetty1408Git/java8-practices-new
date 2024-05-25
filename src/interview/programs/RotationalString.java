package interview.programs;

public class RotationalString {
    public static void main(String[] args) {
        String s1 = "anilshetty";
        String s2 = "shettyanii";
        boolean isRotationalString = checkRotationalString(s1, s2);
        System.out.println(isRotationalString);
    }

    private static boolean checkRotationalString(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String str3 = str1 + str1;
        if (str3.contains(str2)) {
            return true;
        } else {
            return false;
        }
    }
}
