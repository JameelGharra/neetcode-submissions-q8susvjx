class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int stopIndex = k, left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (stopIndex != pivotIndex) {
            pivotIndex = partition(points, left, right);
            if (pivotIndex > stopIndex) {
                right = pivotIndex - 1;
            }
            else if (pivotIndex < stopIndex) {
                left = pivotIndex + 1;
            }
        }
        int[][] res = Arrays.copyOfRange(points, 0, k);
        return res;
    }
    private int partition(int[][] points, int left, int right) {
        int i = left;
        int distPivot = relaxedDist(points[right]);
        for (int j = left; j < right; ++j) {
            if (relaxedDist(points[j]) <= distPivot) {
                swapPoint(points, i, j);
                ++i;
            }
        }
        swapPoint(points, i, right);
        return i;
    }
    private int relaxedDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    private void swapPoint(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
