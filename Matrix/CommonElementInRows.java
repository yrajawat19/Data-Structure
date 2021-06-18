package Matrix;

import java.util.HashMap;

public class CommonElementInRows {
    public static void CommonElement(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(matrix[0][i],1);

        for(int i = 1;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i) {
                    map.put(matrix[i][j], i + 1);

                    if(i == m-1)
                        System.out.print(matrix[i][j]+" ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},};

        CommonElement(matrix);
    }
}
