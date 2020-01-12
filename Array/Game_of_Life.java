time complexity: O(9*m*n)
space complexity; O(1)


检查每个cell的8个neighbor, 如果neighbor的值为1或者2, 则count++, 2表示的意思是原来这个cell的值为1, 但是next generation为0.
如果当前cell本来为1, count < 2 或者 count > 3, 则把这个cell更新成 2
如果当前cell本来为0, count == 3， 则把这个cell更新成更新成3

最后遍历一遍board 每个cell %= 2

public void gameOfLife(int[][] board) {
    int m = board.length;
    if (m == 0) return ;
    int n = board[0].length;
    if (n == 0) return ;
    
    int[] move = {-1, 0, 1};
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            int count = 0;
            for (int a = 0; a < 3; ++a) {
                for (int b = 0; b < 3; ++b) {
                    if (move[a] == 0 && move[b] == 0) continue;
                    int x = i + move[a];
                    int y = j + move[b];
                    if (x >= 0 && y >= 0 && x < m && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
                        count++;
                    }
                }
            }
            if (board[i][j] == 1) {
                if (count < 2 || count > 3) {
                    board[i][j] = 2;
                }
            } else {
                if (count == 3) {
                    board[i][j] = 3;
                }
            }
        }
    }
    
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            board[i][j] %= 2;
        }
    }
    
}