package Matrix;

public class FloodFill {
    // Driver code
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2 ;
        System.out.println("Input Image : ");
        print(image);
        floodFill(image,sr,sc,newColor);
        System.out.println("Image after flood fill operation : ");
        print(image);
    }

    // Function to print matrix
    private static void print(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to flood fill the image
    private static int[][] floodFill(int[][] image , int sr , int sc , int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }

    // recursive function to fill image
    private static void fill(int[][] image , int sr , int sc, int color , int newColor) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;

        fill(image,sr-1,sc,color,newColor);
        fill(image,sr+1,sc,color,newColor);
        fill(image,sr,sc-1,color,newColor);
        fill(image,sr,sc+1,color,newColor);
    }
}
