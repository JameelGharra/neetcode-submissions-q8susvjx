class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(Integer number : nums) {
            if(!numbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}