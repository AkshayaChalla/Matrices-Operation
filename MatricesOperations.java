public class MatricesOperations {

    // Matrix Addition
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        
        return result;
    }

    // Matrix Subtraction
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        
        return result;
    }

    // Matrix Multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        
        // Check if multiplication is possible
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix multiplication not possible. Columns of A must be equal to rows of B.");
        }
        
        int[][] result = new int[rowsA][colsB];
        
        // Perform matrix multiplication
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return result;
    }

    // Matrix Inversion for 2x2 Matrix
    public static double[][] inverseMatrix(int[][] B) {
        int a = B[0][0];
        int b = B[0][1];
        int c = B[1][0];
        int d = B[1][1];
        
        // Calculate determinant
        int determinant = a * d - b * c;
        
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is not invertible.");
        }
        
        double[][] inverse = new double[2][2];
        inverse[0][0] = d / (double) determinant;
        inverse[0][1] = -b / (double) determinant;
        inverse[1][0] = -c / (double) determinant;
        inverse[1][1] = a / (double) determinant;
        
        return inverse;
    }

    // Matrix Division (A / B is equivalent to A * B^-1)
    public static double[][] divideMatrices(int[][] A, int[][] B) {
        // Step 1: Find the inverse of B
        double[][] BInverse = inverseMatrix(B);

        // Step 2: Multiply A with B^-1
        return multiplyMatricesDouble(A, BInverse);
    }

    // Matrix Multiplication for double values (to handle inverse)
    public static double[][] multiplyMatricesDouble(int[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix multiplication not possible.");
        }
        
        double[][] result = new double[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return result;
    }

    // Method to print the matrix (for int and double)
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example matrices
        int[][] A = {{1, 2},{3, 4}};
        
        int[][] B = {{5, 6},{7, 8} };

        System.out.println("Matrix A IS :");
        printMatrix(A);
        System.out.println("Matrix B IS :");
        printMatrix(B);
        
        // Matrix Addition
        System.out.println("\nADDITION OF MATRICES(A+B) :");
        int[][] sum = addMatrices(A, B);
        printMatrix(sum);

        // Matrix Subtraction
        System.out.println("\nSUBTRACTION OF MATRICES(A-B) :");
        int[][] difference = subtractMatrices(A, B);
        printMatrix(difference);

        // Matrix Multiplication
        System.out.println("\nMULTIPLICAATION OF MATRICES (A*B) :");
        int[][] product = multiplyMatrices(A, B);
        printMatrix(product);

        // Matrix Division (A / B)
        System.out.println("\n DIVISION OF MATRICES (A/B) :");
        double[][] divisionResult = divideMatrices(A, B);
        printMatrix(divisionResult);
    }
}


       