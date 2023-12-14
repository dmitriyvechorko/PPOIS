import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RealMatrix {

        private double[][] matrix;
        private int rows;
        private int cols;
        public int getRows() {return rows;}
        public int getCols() {return cols;}
        public RealMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            matrix = new double[rows][cols];
        }
        public void setElement(int row, int col, double value) {
            matrix[row][col] = value;
        }
        public double getElement(int row, int col) {
        return matrix[row][col];
    }
        public double[][] getMatrix() { return matrix; }
        public void setRows(int rows) {
            double[][] newMatrix = new double[rows][cols];
            for (int i = 0; i < Math.min(rows, this.rows); i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, cols);
            }
            matrix = newMatrix;
            this.rows = rows;
        }
        public void setCols(int cols) {
            double[][] newMatrix = new double[rows][cols];
            for (int i = 0; i < Math.min(cols, this.cols); i++) {
                for (int j = 0; j < rows; j++) {
                    newMatrix[j][i] = matrix[j][i];
                }
            }
            matrix = newMatrix;
            this.cols = cols;
        }
        public void loadFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int rows = 0;
        int cols = 0;

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().trim().split(" ");
            cols = Math.max(cols, values.length);
            rows++;
        }
        scanner.close();
        scanner = new Scanner(file);

        matrix = new double[rows][cols];
        int row = 0;
        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().trim().split(" ");
            for (int col = 0; col < values.length; col++) {
                matrix[row][col] = Double.parseDouble(values[col]);
            }
            row++;
        }
        scanner.close();
        }
        public RealMatrix getSubMatrix(int startRow, int startCol, int numRows, int numCols) {
            RealMatrix subMatrix = new RealMatrix(numRows, numCols);
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    subMatrix.setElement(i, j, matrix[startRow + i][startCol + j]);
                }
            }
            return subMatrix;
        }
        public boolean isSquare() {
            return rows == cols;
        }
        public boolean isDiagonal() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i != j && matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isZero() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isIdentity() {
            if (!isSquare()) {
                return false;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i == j && matrix[i][j] != 1) {
                        return false;
                    } else if (i != j && matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isSymmetric() {
            if (!isSquare()) {
                return false;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != matrix[j][i]) {
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isUpperTriangular() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < i; j++) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isLowerTriangular() {
            for (int i = 0; i < rows; i++) {
                for (int j = i + 1; j < cols; j++) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public RealMatrix transpose() {
            RealMatrix transposedMatrix = new RealMatrix(cols, rows);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposedMatrix.setElement(j, i, matrix[i][j]);
                }
            }
            return transposedMatrix;
        }
}
