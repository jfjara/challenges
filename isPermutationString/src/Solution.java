public class Solution {

    public static void main(String[] args) {
        System.out.println(isPermutation("((", "edcba"));
        System.out.println(isPermutation("123456789abc", "abc123456788"));
        System.out.println(isPermutation("123456789abc", "9876a54b32c1"));
    }


    //O(N)
    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int[] ascii = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            ascii[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            ascii[str2.charAt(i)]--;
            if (ascii[str2.charAt(i)] < 0) return false;
        }
        return true;
    }
}
