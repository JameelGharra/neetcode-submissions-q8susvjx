class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(Integer number : nums) {
            if(numbers.contains(number))
                return true;
            numbers.add(number);
        }
        return false;
    }
}
