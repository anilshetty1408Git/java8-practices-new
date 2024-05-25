public class LikeDIslIke {
    public static void main(String[] args) {
        String A = "010101";
        String P = "101101";

        int out_ = count_like_dislike(A, P);
        System.out.println(out_);
    }
    static int count_like_dislike(String A, String P){
        // Write your code here
        int result = 0;

        String[] s1 = A.split("");
        String[] p1 = P.split("");
        int count=0;
        int j=0;

        for (int i = 0; i < s1.length; i++) {
            if(s1[i].equals(p1[j])){
                result++;
            }
            j=j++;
        }


        return result;

    }
}
