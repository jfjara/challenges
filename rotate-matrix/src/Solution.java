public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { {1,2,3}, {4,5,6}, {7,8,9}};
        int[][] rotated = rotate(matrix);
        rotated = rotate(rotated);
        rotated = rotate(rotated);
        rotated = rotate(rotated);
    }

    //O(N^2)
    private static int[][] rotate(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix.length];
        int ip = 0;
        for (int j = matrix.length - 1; j >= 0; j--) {
            int jp = 0;
            for (int i = 0; i < matrix.length; i++) {
                rotated[jp][ip] = matrix[j][i];
                jp++;
            }
            ip++;
        }
        return rotated;
    }
}
