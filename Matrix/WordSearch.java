package Matrix;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCCED" ;
        System.out.println(isWordExist(board,word));
    }

    public static boolean isWordExist(char[][] board , String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[i].length; j++) {
                if(word.charAt(0) == board[i][j] && search(board,word,visited,i,j,0))
                    return true;
            }
        }

        return false;
    }

    // Function to perform DFS on matrix
    public static boolean search(char[][] board , String word , boolean[][] visited , int i, int j, int index) {
        if(index == word.length())
            return true;

        if(i<0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j])
            return false;

        visited[i][j] = true;

        if(search(board,word,visited,i+1,j,index+1) ||
                search(board,word,visited,i-1,j,index+1)  ||
                search(board,word,visited,i,j-1,index+1) ||
                search(board,word,visited,i,j+1,index+1))
            return true;

        visited[i][j] = false;

        return false;
    }
}
