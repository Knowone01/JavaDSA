import java.util.*;

public class Matrices {

    //Creation
    public static void input_outputArrays(int m, int n){
        int matrix[][] = new int[m][n];
        
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(" "+ matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Max/min element of the matrix
  public static int maxElement(int m, int n){
            int min = Integer.MIN_VALUE;
            int matrix[][] = new int[m][n];
        
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

         for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               min = Math.max(matrix[i][j], min);
            }
        }


            return min;
            
    }

    //Spiral Matrix

    public static void spiralMatrix(int matrix[][]){
        int startRow = 0 ;
        int endRow = matrix.length - 1; //gives number of rows
        int startCol = matrix[0].length - 1; //gives number of cols
        int endCol = 0; 

        while(startRow <= endRow && startCol >= endCol){
            //top
            for(int i = endCol; i <= startCol; i++){
                System.out.print(" " + matrix[startRow][i]);
            }
            //right
            for(int i = startRow  + 1; i <= endRow; i++){
                System.out.print(" " + matrix[i][startCol]);
            }
            //bottom
            for(int i = startCol-1; i>= startRow; i-- ){
                System.out.print(" " + matrix[endRow][i] +" ");
                if(startRow == endRow){
                    break;
                }
            }
            //left
            for(int i = endRow - 1; i >= startRow + 1; i--){
                System.out.print(" " + matrix[i][endCol] + " ");
                 if(startRow == endRow){
                    break;
                }
            }

            startRow++;
            endRow--;
            startCol--;
            endCol++;
        }

    }

    //Diagonal Sum : ONLY APPLICABLE FOR SQUARE MATRICES

    public static void diagonalsum(int matrix[][]){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
            if(i != matrix.length - i -1 ){
                sum += matrix[i][matrix.length - i - 1];
            }
        }
        System.out.println(sum);
    }

    //Searching in a sorted 2D matrix : Staircase method, O(n+m);

    public static void staircase(int matrix[][], int key){
        int startRow = 0;
        int startCol = matrix[0].length - 1;
        int endRow = matrix.length - 1;
        int endCol = 0;

        

        while(startRow <= endRow && startCol >= endCol){
            if(matrix[startRow][startCol] == key){
                System.out.println("" + startRow + " " + startCol);
                return ;
            }

            else if(matrix[startRow][startCol] > key){
                startCol--;
            }
            else if(matrix[startRow][startCol] < key){
                startRow++;
            }

        } 
    }



    public static void main(String[] args) {
       
        int matrix[][]={{1,2,3,4}, {5,8,11,14}, {6,9,12,15}, {7,10,13,16}};
        staircase(matrix, 13);
    }
}
