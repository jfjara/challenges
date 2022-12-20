public class Solution {

    public static void main(String[] args) {

        System.out.println(isAllUniqueChars("This is a test text!"));
        System.out.println(isAllUniqueChars("1234567890"));
        System.out.println(isAllUniqueChars("abcdefg"));
        System.out.println(isAllUniqueChars("abcdaefg"));

        System.out.println(isAllUniqueCharsONexp2("This is a test text!"));
        System.out.println(isAllUniqueCharsONexp2("1234567890"));
        System.out.println(isAllUniqueCharsONexp2("abcdefg"));
        System.out.println(isAllUniqueCharsONexp2("abcdaefg"));

        System.out.println(isAllUniqueWithoutAuxiliarArray("This is a test text!"));
        System.out.println(isAllUniqueWithoutAuxiliarArray("1234567890"));
        System.out.println(isAllUniqueWithoutAuxiliarArray("abcdefg"));
        System.out.println(isAllUniqueWithoutAuxiliarArray("aabcdaefg"));

    }

    //O(N)
    private static boolean isAllUniqueChars(String text) {

        if (text.length() > 128) {
            return false;
        }

        boolean[] flags = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            int indexAscii = text.charAt(i);
            if (flags[indexAscii]) {
                return false;
            }
            flags[indexAscii] = true;
        }
        return true;
    }

    private static boolean isAllUniqueWithoutAuxiliarArray(String text) {
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (i != j && text.charAt(i) == text.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(N^2) with auxiliar array
    private static boolean isAllUniqueCharsONexp2(String text) {
        int charsInserted = 0;
        char[] chars = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char charToFind = text.toCharArray()[i];
            for (int j = 0; j < charsInserted; j++) {
                if (charToFind == chars[j]) {
                    return false;
                }
            }
            chars[charsInserted] = charToFind;
            charsInserted++;
        }
        return true;
    }

}
