class Solution {
    public boolean isValidSudoku(char[][] board) {
        //  r1 -> set(2, 3, 1, 2)
        // c1
        // 3x3
        // rows col 3x3
        Map<Integer, Set<Integer>> rMap = new HashMap<>();
        Map<Integer, Set<Integer>> cMap = new HashMap<>();
        Map<String, Set<Integer>> sqMap = new HashMap<>();
        for(int i = 0; i < 9; ++i) {
            rMap.put(i, new HashSet<>());
            cMap.put(i, new HashSet<>());
        }
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                sqMap.putIfAbsent(i/3+"-"+j/3, new HashSet<>());
            }
        }
        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                if(board[i][j] != '.') {
                    if(
                        !rMap.get(i).add((int)board[i][j]) ||
                        !cMap.get(j).add((int)board[i][j]) ||
                        !sqMap.get(""+i/3+"-"+j/3).add((int)board[i][j])
                      ) {
                        return false;
                    }
                }   
            }
        }
        return true;
    }
}
