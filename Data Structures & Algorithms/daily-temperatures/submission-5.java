// dynamic prog
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length-1] = 0;
        for(int i = arr.length-2; i >= 0; --i) {
            if(arr[i+1] > arr[i]) {
                res[i] = 1;
            }
            else {
                int j = i+1;
                while(j <= arr.length-1 && arr[i] >= arr[j+res[j]]) {
                    if(res[j] == 0) {
                        res[i] = 0;
                        break;
                    }
                    j = j+res[j];
                }
                if(res[j] != 0) {
                    res[i] = j-i+res[j];
                }
            }

        }
        return res;
    }
}
