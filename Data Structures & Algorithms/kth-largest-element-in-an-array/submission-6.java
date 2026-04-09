class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k < 1) {
            return -1;
        }
        int stopIndex = nums.length - k;
        int left = 0, right = nums.length - 1, pivotIndex = nums.length;
        while (left <= right) {
            pivotIndex = partition(nums, left, right);
            if (pivotIndex == stopIndex) {
                return nums[pivotIndex];
            }
            else if (pivotIndex > stopIndex) {
                right = pivotIndex - 1;
            }
            else if (pivotIndex < stopIndex) {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private int partition(int[] arr, int left, int right) {
        int randomIdx = left + new Random().nextInt(right - left + 1);
        swap(arr, randomIdx, right);
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; ++j) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                ++i;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
