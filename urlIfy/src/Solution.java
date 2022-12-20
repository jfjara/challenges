public class Solution {

    public static void main(String[] args) {
        String r1 = new String(toUrlIfy("Mr Juan Fco Jara"));
        System.out.println(r1);
        String r2= new String(toUrlIfy("    Mr Juan Fco Jara"));
        System.out.println(r2);
        String r3 = new String(toUrlIfy("Mr   Juan Fco Jara  "));
        System.out.println(r3);
    }

    //O(N)
    private static char[] toUrlIfy(String text) {
        int totalSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 32) totalSpaces++;
        }
        int newSize = text.length() - totalSpaces + (totalSpaces * 3);
        char[] urlIfy = new char[newSize];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != 32) {
                urlIfy[index] = text.charAt(i);
                index++;
            } else {
                urlIfy[index] = 37;
                urlIfy[index + 1] = 50;
                urlIfy[index + 2] = 48;
                index = index + 3;
            }
        }
        return urlIfy;
    }
}
