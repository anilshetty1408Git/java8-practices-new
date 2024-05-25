package logcs;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 852587459;
        int rev;
        while (n!=0){
            rev=n%10;
            n=n/10;
            System.out.print(rev);
        }
    }
}
