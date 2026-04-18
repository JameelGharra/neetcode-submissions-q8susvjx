class Solution {
    // this solution is not needed, I just put there for reference later on
    // it actually does more work since it removes (shifts in a way) and adds
    // the new level instead of just creating a new result array
    // i would not do this in an interview, its just the same
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.isEmpty()) return queue;
        
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add(""); // Initial state
        
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            
            // Only process the combinations from the PREVIOUS level
            // We know an item is from the previous level if its length equals `i`
            while (queue.peek().length() == i) {
                String curr = queue.remove(); // O(1) removal! No shifting!
                
                for (char c : letters[digit].toCharArray()) {
                    queue.add(curr + c); // Add new combinations to the back
                }
            }
        }
        
        return queue;
    }
}
