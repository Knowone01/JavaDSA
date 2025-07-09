public class backTracking {

    // Backtracking on arrays
    public static void arraysBack(int arr[], int val, int i) {
        if (i == arr.length) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(" " + arr[j]);
            }
            System.out.println();
            return;
        } 

        arr[i] = val;
        arraysBack(arr, val + 1, i + 1);
        arr[i] = arr[i] - 2; // backtracking
    }

    //Finding subsets : 

    public static void findSubsets(String test, int i, String ans){
        if(i == test.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
            System.out.println(ans);
            }
            return;
        }
        findSubsets(test, i + 1, ans + test.charAt(i));
        findSubsets(test, i + 1, ans); // backtracking step

    }

    //Finding all possible permutations : 

    public static void permutations(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++ ){
            char currChar = str.charAt(i);
            String NewStr = str.substring(0,i) + str.substring(i+1); // all the characters before ith index + all the characters after ith index
            permutations(NewStr, ans + currChar);

        }
    }

    // N queens : 

        public static void nQueens(int row, char board[][]) {
            if (row == board.length) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                return;
            }
            for (int col = 0; col < board.length; col++) {
                if(isSafe(row, col, board) == true){
                board[row][col] = 'Q';
                nQueens(row + 1, board);
                board[row][col] = 'X'; // backtrack
                }
            }
           
        }

        public static boolean isSafe(int row, int col, char board[][]){
            for(int i = row - 1, j = col; i >= 0; i--){
                if(board[i][j] == 'Q'){
                    return false;
                }
        }
        for(int i = row  -1, j = col - 1; i >=0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row  -1, j = col + 1; i >=0 && j < board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    // Grid ways problem : 

    public static int gridways(int i, int j, int m, int n){
        // if(i == m- 1 && j == n-1){
        //     return 1;
        // }
        if(i == m || j == n){
            return 1;
        }
        
       int w1 =  gridways(i + 1, j, m, n);
        int w2  =gridways(i, j + 1, m, n);
        return w1 + w2;

    }

    //Sudoku problem : 
    public static boolean solnSudoku(int i, int j, int sudoku[][]){
        if(i == 9){
            return true;
        }
        int newRow , newCol;
        if(j == 8){
            newRow = i + 1;
            newCol = 0;
        }
        else{
         newRow = i;
        newCol = j + 1;
        }
        if(sudoku[i][j] != 0){
            return solnSudoku(newRow, newCol, sudoku);
        }
        
        for(int digit = 1; digit <= 9; digit++){  
            if(isSafeDigit(i, j, digit, sudoku) == true){     
            sudoku[i][j] = digit;
                if(solnSudoku(newRow, newCol, sudoku)){
                    return true;
                } // recursion 
                sudoku[i][j] = 0; // back tracking
            }
        
           
    }
        return false;
    }
    public static boolean isSafeDigit(int row, int col,int digit, int sudoku[][]){
        //Checking col : 
        for(int i = 0; i <= 8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //Checking row : 
        for(int j = 0; j <= 8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        //Checking the box : 
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++){
            for(int j = startCol; j < startCol + 3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;

    }

    
    
        public static void main(String args[]) {
        //     int sudoku[][] = {
        //         {0,0,8,0,0,0,0,0,0},
        //         {4,9,0,1,5,7,0,0,2},
        //         {0,0,3,0,0,4,1,9,0},
        //         {1,8,5,0,6,0,0,2,0},
        //         {0,0,0,0,2,0,0,6,0},
        //         {9,6,0,4,0,5,3,0,0},
        //         {0,3,0,0,7,2,0,0,4},
        //         {0,4,9,0,3,0,0,5,7},
        //         {8,2,7,0,0,9,0,1,3},
        //     };
        //   if (solnSudoku(0, 0, sudoku) == true){
        //     for(int i = 0 ; i < 9; i ++){
        //         for(int j = 0; j < 9; j++){
        //             System.out.print ("  " + sudoku[i][j]);
        //         }
        //         System.err.println();
        //     }
        //   }
        System.out.println(gridways(1, 1, 4, 3));
}
}
