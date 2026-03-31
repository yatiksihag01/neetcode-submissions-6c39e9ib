public class Solution {
    private int searchIterCol(int[][] matrix, int target) {
        int n = matrix[0].length;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][n-1] >= target && matrix[mid][0] <= target) {
                return mid;
            }
            else if (matrix[mid][n-1] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private int searchIterRow(int[][] matrix, int rowIndex, int target) {
        int low = 0;
        int high = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[rowIndex][mid] == target) return mid;
            else if (matrix[rowIndex][mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = searchIterCol(matrix, target);
        if (rowIndex == -1) return false;
        return searchIterRow(matrix, rowIndex, target) != -1;
    }

}
