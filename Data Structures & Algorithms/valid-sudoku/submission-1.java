class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> boardSet = new HashSet<>();
        for(int rowId = 0; rowId < board.length; ++rowId) {
            for(int colId = 0; colId < board[0].length; ++colId) {
                char c = board[rowId][colId];
                if(c == '.') {
                    continue;
                }
                if(!boardSet.add(""+rowId+"r="+c) ||
                !boardSet.add(""+colId+"c="+c) ||
                !boardSet.add(""+rowId/3 + "," + colId/3 + c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
