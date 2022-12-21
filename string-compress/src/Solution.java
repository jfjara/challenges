public class Solution {

    public static void main(String[] args) {
        System.out.println(compress("aaabbcccccddaaa"));
        System.out.println(compress("aa-bb¡cc ddaaa"));
        System.out.println(compress("a"));
        System.out.println(compress("asdfghjkl"));
        System.out.println(compress("aaasss"));

    }

    //O(N)
    private static String compress(String text) {
        //a.Z
        if (text == null || text.length() == 0) return null;
        int counter = 1;

        String t = clearText(text);
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            if (i + 1 < t.length() && t.charAt(i) == t.charAt(i + 1)) {
                counter++;
            } else {
                result += "" + counter + t.charAt(i);
                counter = 1;
            }
        }
        return result.length() > text.length() ? text : result;
    }

    private static String clearText(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'A' && text.charAt(i) <= 'z') {
                result += "" + text.charAt(i);
            }
        }
        return result;
    }
}
