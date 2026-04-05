class Solution {
    private int rowsBinarySearch(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1, mid = 0;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(matrix[mid][0] < target) {
                left = mid+1;
            }
            else if(matrix[mid][0] > target) {
                right = mid-1;
            }
            else {
                 return mid;
            }
        }
        return mid;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = rowsBinarySearch(matrix, target);
        if(matrix[rowIdx][0] == target)
            return true;
        int foundIdx = Arrays.binarySearch(matrix[rowIdx], target);
        if(foundIdx < matrix[0].length && foundIdx >= 0 &&
         matrix[rowIdx][foundIdx] == target) {
            return true;
        }
        if(rowIdx > 0) {
            int prevIdx = Arrays.binarySearch(matrix[rowIdx-1], target);
            if(prevIdx < matrix[0].length && prevIdx >= 0 &&
            matrix[rowIdx-1][prevIdx] == target) {
                return true;
            }
        }
        return false;
    }
}
