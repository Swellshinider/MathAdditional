package com.mathAdditional;

import com.mathAdditional.Exceptions.CannotUseMatrixException;
import com.mathAdditional.Exceptions.IncompatibleMatrixException;
import com.mathAdditional.Exceptions.InvalidMatrixException;

import java.util.Arrays;

/**
 *  The class {@code MAMatrix} consists of creating a matrix according to
 *  the ideal parameters for operations between matrices.
 *
 * @author Eduardo Ribeiro Leal
 * @version 1.0.0
 * @see com.mathAdditional
 */
public class MAMatrix {

    private final double[][] matrix;

    /**
     *
     * @param matrix receive the matrix in double[][] format.
     * @throws InvalidMatrixException if the matrix are invalid.
     */
    public MAMatrix(double[][] matrix) throws InvalidMatrixException {
        for (double[] line : matrix)
            for (double val: line)
                if (Double.isNaN(val) || Double.isInfinite(val))
                    throw new InvalidMatrixException();
        this.matrix = matrix;
    }

    /**
     *
     * @param other (other MAMatrix)
     * @return returns a new matrix, this matrix times the other matrix
     * @throws IncompatibleMatrixException if the matrices are
     * impossible to multiply
     */
    public double[][] multiply(MAMatrix other) throws IncompatibleMatrixException {
        return doMultiplication(matrix, other.getMatrix());
    }

    /**
     *
     * @param other (other MAMatrix)
     * @return returns a new matrix, this matrix plus the other matrix
     * @throws IncompatibleMatrixException if the matrices are
     *      * impossible to multiply
     */
    public double[][] sum(MAMatrix other) throws IncompatibleMatrixException {
        return doSum(matrix, other.getMatrix());
    }

    /**
     *
     * @param other (other MAMatrix)
     * @return returns a new matrix, this matrix minus the other matrix
     * @throws IncompatibleMatrixException if the matrices are
     *      * impossible to multiply
     */
    public double[][] sub(MAMatrix other) throws IncompatibleMatrixException {
        return doSub(matrix, other.getMatrix());
    }

    /**
     *
     * @return double[][] matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     *
     * @return double, determinant of matrix
     */
    public double getDeterminant() throws CannotUseMatrixException {
        if (matrix.length != matrix[0].length)
            throw new CannotUseMatrixException();

        return determinant(getMatrix());
    }

    /**
     *
     * @return The inverse matrix, returns null if do not have inverse.
     * @throws CannotUseMatrixException if matrix is invalid
     */
    public double[][] getInverse() throws CannotUseMatrixException {
        if(getDeterminant() == 0)
            return null;

        if(matrix.length != matrix[0].length)
            throw new CannotUseMatrixException();

        return invert(matrix);
    }

    /**
     *
     * @return the matrix indentity
     * @throws CannotUseMatrixException if matrix is invalid
     */
    public double[][] getIdentity() throws CannotUseMatrixException{
        if(matrix.length != matrix[0].length)
            throw new CannotUseMatrixException();

        double[][] identity = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                identity[i][j] = i == j ? 1 : 0;
            }
        }

        return identity;
    }

    /**
     *
     * @return returns tranpose matrix
     */
    public double[][] getTranspose(){
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];

        return transpose;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            double[] line = matrix[i];
            string.append(Arrays.toString(line)).append(i + 1 != matrix.length ? "\n" : "");
        }

        return string.toString();
    }

    // Private methods
    private double[][] doSum(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixException {

        if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixException("to add matrices they must be the same size");

        double[][] matrix3 = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix2[0].length; j++)
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];

        return matrix3;
    }

    private double[][] doSub(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixException {

        if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixException("to subtract matrices they must be the same size");

        double[][] matrix3 = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix2[0].length; j++)
                matrix3[i][j] = matrix1[i][j] - matrix2[i][j];

        return matrix3;
    }

    private double[][] doMultiplication(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixException {

        if(matrix1.length != matrix2[0].length)
            throw new IncompatibleMatrixException();

        double[][] matrix3 = new double[matrix1.length][matrix2[0].length];

        for(int i = 0; i < matrix1.length; i++)
            for(int j = 0; j < matrix2[0].length; j++){
                double sum = 0;

                for(int k = 0; k < matrix1[0].length; k++)
                    sum += matrix1[i][k] * matrix2[k][j];

                matrix3[i][j] = sum;
            }

        return matrix3;
    }

    private double determinant(double[][] matrix){
        int result = 0;
        int saver;

        if(matrix.length == 1)
            return(matrix[0][0]);

        for(int i = 0; i < matrix.length; i++){
            double[][] smaller = new double[matrix.length-1][matrix.length-1];

            for(int a = 1; a < matrix.length; a++){
                for(int b = 0; b < matrix.length; b++){
                    if(b < i)
                        smaller[a - 1][b] = matrix[a][b];
                    else if(b > i)
                        smaller[a - 1][b - 1] = matrix[a][b];
                }
            }

            saver = i % 2 == 0 ? 1 : -1;
            result += saver * matrix[0][i] * (determinant(smaller));
        }

        return(result);
    }

    private double[][] invert(double[][] a) {
        int n = a.length;
        int[] index = new int[n];

        double[][] x = new double[n][n];
        double[][] b = new double[n][n];

        for (int i = 0; i < n; i++)
            b[i][i] = 1;

        gaussian(a, index);

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = 0; k < n; k++)
                    b[index[j]][k] -= a[index[j]][i] * b[index[i]][k];

        for (int i=0; i<n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];

            for (int j = n - 2; j >= 0; j--) {
                x[j][i] = b[index[j]][i];

                for (int k=j+1; k<n; ++k)
                    x[j][i] -= a[index[j]][k] * x[k][i];

                x[j][i] /= a[index[j]][j];
            }
        }

        return x;
    }

    private void gaussian(double[][] a, int[] index) {
        int n = index.length;
        double[] c = new double[n];

        for (int i = 0; i < n; i++)
            index[i] = i;

        for (int i = 0; i < n; i++) {
            double c1 = 0;

            for (int j = 0; j < n; j++) {
                double c0 = Math.abs(a[i][j]);

                if (c0 > c1)
                    c1 = c0;
            }

            c[i] = c1;
        }

        int k = 0;

        for (int j = 0; j < n - 1; j++) {
            double pi1 = 0;

            for (int i = j; i < n; i++) {
                double pi0 = Math.abs(a[index[i]][j]);

                pi0 /= c[index[i]];

                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;

            for (int i = j + 1; i < n; i++) {
                double pj = a[index[i]][j] / a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l = j + 1; l < n; l++)
                    a[index[i]][l] -= pj * a[index[j]][l];
            }
        }
    }
}
